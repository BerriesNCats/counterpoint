package core.composition;

import static core.entity.Utilities.DEFAULT_OCTAVE;

import core.entity.interval.Interval;
import core.entity.interval.IntervalQuality;
import core.entity.interval.IntervalType;
import core.entity.key.Key;
import core.entity.pitch.Pitch;
import core.composition.voice.CantusFirmusVoice;
import core.composition.voice.CounterPointVoice;
import core.entity.pitch.PitchClass;
import java.util.ArrayList;
import java.util.List;

public class NoteAgainstNote {

  private final Key key;
  private final CantusFirmusVoice cantusFirmusVoice;
  private final CounterPointVoice counterPointVoice;
  private final List<Interval> intervals;

  public NoteAgainstNote(Key key) {
    this(
        key,
        CantusFirmusVoice.createNewCantus(key, DEFAULT_OCTAVE),
        CounterPointVoice.createNewCounterpoint(key, DEFAULT_OCTAVE));
  }

  public NoteAgainstNote(
      Key key, CantusFirmusVoice cantusFirmusVoice, CounterPointVoice counterPointVoice) {
    this.key = key;
    this.cantusFirmusVoice = cantusFirmusVoice;
    this.counterPointVoice = counterPointVoice;
    this.intervals = createIntervals();
  }

  public boolean isValidCantusFirstNote() {
    return cantusFirmusVoice.isRootPitch(key);
  }

  public boolean isValidOpeningInterval() {
    if (!isValidCantusFirstNote()) {
      return false;
    }
    return intervals.get(0).getIntervalType() == IntervalType.PERFECT_CONSONANCE;
  }

  public boolean isValidPenultimateNote() {
    PitchClass penUltimateNote =
        this.cantusFirmusVoice
            .getNotes()
            .get(cantusFirmusVoice.getNotes().size() - 2)
            .getPitchClass();

    return penUltimateNote.equals(key.getSuperTonic())
        || penUltimateNote.equals(key.getLeadingTone());
  }

  public boolean isValidPenultimateInterval() {
    IntervalQuality penUltimateIntervalQuality =
        this.intervals.get(this.intervals.size() - 2).getQuality();

    return penUltimateIntervalQuality.equals(IntervalQuality.MAJOR_SIXTH)
        || penUltimateIntervalQuality.equals(IntervalQuality.MINOR_THIRD);
  }

  public boolean isValidUltimateNote() {
    PitchClass ultimateNote =
        this.cantusFirmusVoice
            .getNotes()
            .get(cantusFirmusVoice.getNotes().size() - 1)
            .getPitchClass();

    return ultimateNote.equals(key.getTonic());
  }

  public boolean isValidUltimateInterval() {
    IntervalQuality ultimateIntervalQuality =
        this.intervals.get(this.intervals.size() - 1).getQuality();

    return ultimateIntervalQuality.equals(IntervalQuality.UNISON)
        || ultimateIntervalQuality.equals(IntervalQuality.OCTAVE);
  }

  public List<Interval> createIntervals() {
    List<Interval> intervals = new ArrayList<>();
    for (int i = 0; i < cantusFirmusVoice.getNotes().size() - 1; i++) {
      Note cantusNote = cantusFirmusVoice.getNotes().get(i);
      Note counterNote = counterPointVoice.getNotes().get(i);
      intervals.add(new Interval(cantusNote.getPitch(), counterNote.getPitch()));
    }
    return intervals;
  }

  public List<Interval> findIntervals(List<Pitch> cantusFirmus, List<Pitch> counterpoint) {
    List<Interval> intervals = new ArrayList<>();
    for (int i = 0; i < cantusFirmus.size() - 1; i++) {
      intervals.add(new Interval(cantusFirmus.get(i), counterpoint.get(i)));
    }
    return intervals;
  }

  public Interval createInterval(Note cantusNote, Note counterNote) {
    return new Interval(cantusNote.getPitch(), counterNote.getPitch());
  }
}

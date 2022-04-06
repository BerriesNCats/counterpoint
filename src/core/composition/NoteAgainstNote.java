package core.composition;

import core.entity.Note;
import core.entity.interval.Interval;
import core.entity.key.Key;
import core.entity.pitch.Pitch;
import core.species.CantusFirmusVoice;
import core.species.CounterPointVoice;
import java.util.ArrayList;
import java.util.List;

public class NoteAgainstNote {

  private final Key key;
  private final CantusFirmusVoice cantusFirmusVoice;
  private final CounterPointVoice counterPointVoice;

  public NoteAgainstNote(
      Key key, CantusFirmusVoice cantusFirmusVoice, CounterPointVoice counterPointVoice) {
    this.key = key;
    this.cantusFirmusVoice = cantusFirmusVoice;
    this.counterPointVoice = counterPointVoice;
  }

  public boolean isValidCantusFirstNote() {
    return cantusFirmusVoice.isRootPitch(key);
  }

//  public boolean isValidOpeningInterval() {
//    if (!isValidCantusFirstNote()) {
//      return false;
//    }
//    return intervals.get(0).getIntervalType() == IntervalType.PERFECT_CONSONANCE;
//  }

  // TODO
  public boolean isValidPenultimateNote() {
    return false;
  }

  public boolean isValidPenultimateInterval() {
    return false;
  }

  public boolean isValidUltimateNote() {
    return false;
  }

  public boolean isValidUltimateInterval() {
    return false;
  }

  private List<Interval> createIntervals() {
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

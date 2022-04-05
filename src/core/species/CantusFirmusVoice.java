package core.species;

import static core.entity.interval.IntervalQuality.*;

import core.entity.Note;
import core.entity.interval.IntervalQuality;
import core.entity.key.Key;
import core.entity.pitch.PitchClass;
import java.util.List;
import java.util.Random;

public class CantusFirmusVoice extends Voice {
  public static final int MAX_RANGE = 10;
  public static final List<IntervalQuality> VALID_CANTUS_INTERVALS = loadValidCantusIntervals();


  public CantusFirmusVoice() {}

  public CantusFirmusVoice(List<Note> notes) {
    super(notes);
  }

  public CantusFirmusVoice createCantus(Key key, int octave) {
    int cantusLength = new Random().nextInt(15 - 10) + 10;
    this.setVoiceLength(cantusLength);
    CantusFirmusVoice cantus = new CantusFirmusVoice();
    cantus.setVoiceLength(cantusLength);
    Note tonic = new Note(key.getTonic(), octave);
    cantus.addTonic(tonic);

    for (int i = 1; i < cantusLength - 2; i++) {
      cantus.addNote(generateNote(cantus.notes));
    }
    cantus.addPenUltimate(cantus.generatePenUltimate(key, octave), cantusLength - 2);
    cantus.addUltimate(tonic, cantusLength - 1);
    return cantus;
  }

  private Note generatePenUltimate(Key key, int octave) {
    Note previousNote = this.getNotes().get(this.notes.size() - 3);

    PitchClass superTonic = key.getSuperTonic();
    PitchClass leadingTone = key.getLeadingTone();
    //TODO
    // Adjust Notes if octave throws it off
//    if (superTonic.getPitch().isLowerThan(this.notes.get(0).getPitch())) {
//      //adjust
//    } else if (leadingTone.getPitch().isHigherThan(this.notes.get(0).getPitch())) {
//      //adjust
//    }
    //TODO
    // Return based on previousNote if obvious

//    // Otherwise random
//    if (new Random().nextBoolean()) {
//      return superTonic;
//    }
//    return leadingTone;
    return null;
  }

  private static Note generateNote(List<Note> previousNotes) {
    Random random = new Random();
    // Double check how random works
    int randomNote = random.nextInt(8);
    //TODO
    // Also shouldn't be random most of the time
    // Each previous note should inform the new note according to melodic rules

    return null;
  }

  private void addPenUltimate(Note penUltimate, int secondToLastIndexInCantus) {
    this.notes.add(secondToLastIndexInCantus, penUltimate);
  }

  private void addUltimate(Note ultimate, int lastIndexInCantus) {
    this.notes.add(lastIndexInCantus, ultimate);
  }

  public void addTonic(Note tonic) {
    this.notes.add(0, tonic);
  }

  public void addNote(Note note) {
    this.notes.add(note);
  }

  public boolean beginsWithRootNote(Key key) {
    PitchClass firstPitch = this.notes.get(0).getPitchClass();
    PitchClass rootPitch = key.getTonic();
    return firstPitch.equals(rootPitch);
  }

  public boolean isValidCantusInterval(IntervalQuality quality) {
    return VALID_CANTUS_INTERVALS.contains(quality);
  }

  private static List<IntervalQuality> loadValidCantusIntervals() {
    return List.of(
        MINOR_SECOND,
        MAJOR_SECOND,
        MINOR_THIRD,
        MAJOR_THIRD,
        PERFECT_FOURTH,
        PERFECT_FIFTH,
        MINOR_SIXTH,
        MAJOR_SIXTH,
        OCTAVE);
  }
}

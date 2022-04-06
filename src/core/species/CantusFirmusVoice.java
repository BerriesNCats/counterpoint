package core.species;

import static core.UtilityListsAndMaps.VALID_CANTUS_INTERVALS;
import static core.entity.interval.IntervalQuality.*;
import static core.entity.key.ScaleDegree.*;

import core.entity.Note;
import core.entity.interval.IntervalQuality;
import core.entity.key.Key;
import core.entity.pitch.PitchClass;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CantusFirmusVoice extends Voice {
  public static final int MAX_RANGE = 10;

  public CantusFirmusVoice(Key key) {
    super(key);
  }

  public CantusFirmusVoice(List<Note> notes, Key key) {
    super(notes, key);
  }

  // Should probably be static and take in an object or create List<Note> and return new
  public CantusFirmusVoice createCantus(Key key, int octave) {
    int cantusLength = new Random().nextInt(15 - 10) + 10;
    CantusFirmusVoice cantusFirmus = new CantusFirmusVoice(key);
    cantusFirmus.setVoiceLength(cantusLength);

    Note tonic = new Note(key.getTonic(), octave);
    cantusFirmus.addTonic(tonic);

    for (int i = 1; i < cantusLength - 2; i++) {
      cantusFirmus.addNote(generateNote(this.notes));
    }
    cantusFirmus.addPenUltimate(this.generatePenUltimate(key, octave), cantusLength - 2);
    cantusFirmus.addUltimate(tonic, cantusLength - 1);
    return cantusFirmus;
  }

  private Note generatePenUltimate(Key key, int octave) {
    PitchClass previousPitchClass = this.getNotes().get(this.notes.size() - 3).getPitchClass();
    // TODO Might Need to Adjust for different octaves so there aren't unexpected leaps when they
    // should be steps
    // REDO THIS
    // ACCOUNT FOR SITUATIONS WHERE IT SHOULD BE OR COULD BE SUPER TONIC
    // THEN RETURN LEADING TONE IF ALL OF THOSE AREN'T MET
    if (previousPitchClass.equals(scaleDegrees.get(SUB_MEDIANT))) {
      return new Note(scaleDegrees.get(LEADING_TONE), octave);
    } else if (previousPitchClass.equals(scaleDegrees.get(MEDIANT))) {
      return new Note(scaleDegrees.get(SUPER_TONIC), octave);
    }

    if (new Random().nextBoolean()) {
      return new Note(scaleDegrees.get(LEADING_TONE), octave);
    }
    return new Note(scaleDegrees.get(SUPER_TONIC), octave);
  }

  private static Note generateNote(List<Note> previousNotes) {
    Random random = new Random();
    // Double check how random works
    int randomNote = random.nextInt(8);
    // TODO
    // Also shouldn't be random most of the time
    // Each previous note should inform the new note according to melodic rules

    // Look at the two or three previous notes and create a valid list based on them
    // and other cantus rules such as motion, tritone, climax, leaps

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

  public boolean isRootPitch(Key key) {
    PitchClass firstPitch = this.notes.get(0).getPitchClass();
    PitchClass rootPitch = key.getTonic();
    return firstPitch.equals(rootPitch);
  }

  public boolean isValidCantusInterval(IntervalQuality quality) {
    return VALID_CANTUS_INTERVALS.contains(quality);
  }
}

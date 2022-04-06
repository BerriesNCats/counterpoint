package core.species;

import static core.Utilities.VALID_CANTUS_INTERVALS;
import static core.entity.key.ScaleDegree.*;

import core.entity.Note;
import core.entity.interval.IntervalQuality;
import core.entity.key.Key;
import core.entity.pitch.PitchClass;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CantusFirmusVoice extends Voice {

  public static final int MAX_RANGE_OF_CANTUS_VOICE = 10;
  public static final int MAX_CANTUS_LENGTH = 15;
  public static final int MIN_CANTUS_LENGTH = 8;

  public CantusFirmusVoice(Key key) {
    this(key, new ArrayList<>());
  }

  public CantusFirmusVoice(Key key, List<Note> notes) {
    super(key, notes);
  }

  public CantusFirmusVoice createNewCantus(Key key, int octave) {
    int cantusLength =
        new Random().nextInt(MAX_CANTUS_LENGTH - MIN_CANTUS_LENGTH) + MIN_CANTUS_LENGTH;
    CantusFirmusVoice cantusFirmus = new CantusFirmusVoice(key);
    Note tonic = new Note(key.getTonic(), octave);

    cantusFirmus.setVoiceLength(cantusLength);
    cantusFirmus.addTonic(tonic);

    for (int i = 1; i < cantusLength - 2; i++) {
      cantusFirmus.addNote(generateNote(this.notes));
    }

    cantusFirmus.addPenUltimate(this.generatePenUltimate(key, octave), cantusLength - 2);
    cantusFirmus.addUltimate(tonic, cantusLength - 1);
    return cantusFirmus;
  }

  private Note generatePenUltimate(Key key, int octave) {
    // TODO Might Need to Adjust for different octaves so there aren't unexpected leaps when they
    // need to be steps
    PitchClass previousPitchClass = this.getNotes().get(this.notes.size() - 3).getPitchClass();
    PitchClass superTonic = pitchClassByScaleDegree.get(SUPER_TONIC);
    PitchClass leadingTone = pitchClassByScaleDegree.get(SUPER_TONIC);

    if (previousPitchClass.equals(superTonic) || previousPitchClass.equals(leadingTone)) {
      throw new IllegalArgumentException(
          "A cantus must stay in continuous motion and the penultimate note must be of either the "
              + "super tonic or leading tone and therefore the note preceding the pen ultimate note "
              + "must not be the super tonic or sub mediant. ");
    }

    if (previousPitchClass.equals(pitchClassByScaleDegree.get(SUB_DOMINANT))) {
      return new Note(superTonic, octave);
    }
    // If not the super tonic, leading tone or sub dominant return randomly.
    return new Random().nextBoolean()
        ? new Note(superTonic, octave)
        : new Note(leadingTone, octave);
  }

  private static Note generateNote(List<Note> previousNotes) {
    Random random = new Random();
    // TODO
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

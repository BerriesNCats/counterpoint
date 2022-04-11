package core.composition.voice;

import static core.entity.Utilities.VALID_CANTUS_INTERVALS;
import static core.entity.key.ScaleDegree.*;

import core.entity.interval.Interval;
import core.entity.motion.Motion;
import core.entity.motion.MotionDirection;
import core.entity.motion.MotionDistance;
import core.entity.note.Note;
import core.entity.interval.IntervalType;
import core.entity.key.Key;
import core.entity.note.PitchClass;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A Cantus Firmus is a group of notes adhering to the rules of counterpoint that serves as the
 * basis for a polyphonic composition.
 */
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

  /**
   * Generates a new Cantus Firmus in a given key.
   * @param key the key of the cantus.
   * @param octave the octave of the cantus.
   * @return a newly generated cantus.
   */
  public static CantusFirmusVoice createNewCantus(Key key, int octave) {
    int cantusLength =
        new Random().nextInt(MAX_CANTUS_LENGTH - MIN_CANTUS_LENGTH) + MIN_CANTUS_LENGTH;
    CantusFirmusVoice cantusFirmus = new CantusFirmusVoice(key);
    Note tonic = new Note(key.getTonic(), octave);

    cantusFirmus.setVoiceLength(cantusLength);
    cantusFirmus.addTonic(tonic);

    for (int i = 1; i < cantusLength - 2; i++) {
      cantusFirmus.addNote(generateNote(cantusFirmus.notes, i));
    }

    cantusFirmus.addPenUltimate(cantusFirmus.generatePenUltimate(key, octave), cantusLength - 2);
    cantusFirmus.addUltimate(tonic, cantusLength - 1);
    return cantusFirmus;
  }

  /**
   * Generates the pen ultimate note of a cantus.
   * @param key the key of the cantus.
   * @param octave the octave of the cantus.
   * @return a super tonic or leading tone.
   */
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
              + "must not be the super tonic or leading tone. ");
    }

    if (previousPitchClass.equals(pitchClassByScaleDegree.get(SUB_DOMINANT))) {
      return new Note(superTonic, octave);
    }
    // If not the super tonic, leading tone or sub dominant return randomly.
    return new Random().nextBoolean()
        ? new Note(superTonic, octave)
        : new Note(leadingTone, octave);
  }

  /**
   * Generates a random note to fill in the body of the cantus.
   * @param previousNotes a list of notes already in the cantus.
   * @param index the index of the note to be generated
   * @return a suitable random note based on it's position in the cantus.
   */
  public static Note generateNote(List<Note> previousNotes, int index) {
    Random random = new Random();
    Motion previousMotion =
        new Motion(List.of(previousNotes.get(index - 2), previousNotes.get(index - 1)));
    Interval previousInterval =
        new Interval(previousNotes.get(index - 2), previousNotes.get(index - 1));
    int octave = previousNotes.get(index - 1).getOctave();


    if (previousMotion.findMotionDistance() == MotionDistance.LEAP) {
      if (previousMotion.findMotionDirection() == MotionDirection.UP) {

      } else {

      }
    }
    //if previous motion is leap greater than 3rd, change direction with step
    //

    // TODO
    // Each previous note should inform the new note according to melodic rules

    // Look at the two or three previous notes and create a valid list based on them
    // and other cantus rules such as motion, tritone, climax, leaps

    return null;
  }

  /**
   * Adds the pen ultimate note to a cantus.
   * @param penUltimate the pen ultimate note.
   * @param secondToLastIndexInCantus the index of the pen ultimate note.
   */
  public void addPenUltimate(Note penUltimate, int secondToLastIndexInCantus) {
    this.notes.add(secondToLastIndexInCantus, penUltimate);
  }

  /**
   * Adds the ultimate note to the cantus.
   * @param ultimate the ultimate note.
   * @param lastIndexInCantus the index of the ultimate.
   */
  public void addUltimate(Note ultimate, int lastIndexInCantus) {
    this.notes.add(lastIndexInCantus, ultimate);
  }

  /**
   * Adds the tonic note to the cantus
   * @param tonic the tonic tone.
   */
  public void addTonic(Note tonic) {
    this.notes.add(0, tonic);
  }

  /**
   * Adds a given note to the cantus.
   * @param note the given note.
   */
  public void addNote(Note note) {
    this.notes.add(note);
  }

  /**
   * Compares the first pitch in the cantus with the root of the cantus key.
   * @param key the key of the cantus.
   * @return true if the pitches match.
   */
  public boolean isRootPitch(Key key) {
    PitchClass firstPitch = this.notes.get(0).getPitchClass();
    PitchClass rootPitch = key.getTonic();
    return firstPitch.equals(rootPitch);
  }

  /**
   * Checks to see if a given interval is a valid cantus interval.
   * @param quality the quality of the interval.
   * @return true if a valid cantus interval.
   */
  public boolean isValidCantusInterval(IntervalType quality) {
    return VALID_CANTUS_INTERVALS.contains(quality);
  }
}

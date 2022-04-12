package com.davidamateau.counterpoint.core.composition.voice;

import static com.davidamateau.counterpoint.core.entity.Utilities.VALID_CANTUS_INTERVALS;
import static com.davidamateau.counterpoint.core.entity.key.ScaleDegree.SUB_DOMINANT;
import static com.davidamateau.counterpoint.core.entity.key.ScaleDegree.SUPER_TONIC;

import com.davidamateau.counterpoint.core.entity.interval.IntervalType;
import com.davidamateau.counterpoint.core.entity.key.Key;
import com.davidamateau.counterpoint.core.entity.motion.Motion;
import com.davidamateau.counterpoint.core.entity.motion.MotionDirection;
import com.davidamateau.counterpoint.core.entity.motion.MotionDistance;
import com.davidamateau.counterpoint.core.entity.note.Note;
import com.davidamateau.counterpoint.core.entity.note.PitchClass;
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
   *
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
    cantusFirmus.addNote(cantusFirmus.generateSecondNote(key, octave));
    for (int index = 2; index < cantusLength - 3; index++) {
      cantusFirmus.addNote(generateNote(key, cantusFirmus.getNotes(), octave, index));
    }
    cantusFirmus.addPenUltimate(cantusFirmus.generatePenUltimate(octave), cantusLength - 2);
    cantusFirmus.addUltimate(tonic, cantusLength - 1);

    return cantusFirmus;
  }

  /**
   * Generates randomly the second note for the cantus.
   *
   * @param key the key of the cantus.
   * @param octave the octave of the cantus.
   * @return the newly generated second note.
   */
  public Note generateSecondNote(Key key, int octave) {
    return switch (new Random().nextInt(12)) {
      case 0 -> new Note(key.getSuperTonic(), octave);
      case 1 -> new Note(key.getMediant(), octave);
      case 2 -> new Note(key.getSubDominant(), octave);
      case 3 -> new Note(key.getDominant(), octave);
      case 4 -> new Note(key.getSubMediant(), octave);
      case 5 -> new Note(key.getLeadingTone(), octave);
      case 6 -> new Note(key.getSuperTonic(), octave - 1);
      case 7 -> new Note(key.getMediant(), octave - 1);
      case 8 -> new Note(key.getSubDominant(), octave - 1);
      case 9 -> new Note(key.getDominant(), octave - 1);
      case 10 -> new Note(key.getSubMediant(), octave - 1);
      default -> new Note(key.getLeadingTone(), octave - 1);
    };
  }

  /**
   * Generates the pen ultimate note of a cantus.
   *
   * @param octave the octave of the cantus.
   * @return a super tonic or leading tone.
   */
  public Note generatePenUltimate(int octave) {
    // TODO Might Need to Adjust for different octaves so there aren't unexpected leaps when they
    // need to be steps
    PitchClass previousPitchClass = this.getNotes().get(this.notes.size() - 3).getPitchClass();
    PitchClass superTonic = scaleDegreesToPitchClass.get(SUPER_TONIC);
    PitchClass leadingTone = scaleDegreesToPitchClass.get(SUPER_TONIC);

    if (previousPitchClass.equals(superTonic) || previousPitchClass.equals(leadingTone)) {
      throw new IllegalArgumentException(
          "A cantus must stay in continuous motion and the penultimate note must be of either the "
              + "super tonic or leading tone and therefore the note preceding the pen ultimate note "
              + "must not be the super tonic or leading tone. ");
    }

    if (previousPitchClass.equals(scaleDegreesToPitchClass.get(SUB_DOMINANT))) {
      return new Note(superTonic, octave);
    }
    // If not the super tonic, leading tone or sub dominant return randomly.
    return new Random().nextBoolean()
        ? new Note(superTonic, octave)
        : new Note(leadingTone, octave);
  }

  /**
   * Generates a random note to fill in the body of the cantus.
   *
   * @param key the key of the cantus.
   * @param previousNotes a list of notes already in the cantus.
   * @param index the index of the note to be generated
   * @return a suitable random note based on it's position in the cantus.
   */
  public static Note generateNote(Key key, List<Note> previousNotes, int octave, int index) {
    Note previousNote = previousNotes.get(index - 2);
    Note currentNote = previousNotes.get(index - 1);
    Note generatedNote;
    List<Note> previousTwoNotes = new ArrayList<>();
    previousTwoNotes.add(previousNote);
    previousTwoNotes.add(currentNote);
    Motion previousMotion = new Motion(previousTwoNotes);
//    Interval previousInterval =
//        new Interval(previousNote, currentNote);
//    int octave = currentNote.getOctave();

    if (previousMotion.findMotionDistance() != MotionDistance.STEP) {
      if (previousMotion.findMotionDirection() == MotionDirection.UP) {
        generatedNote =
            Note.createNewNoteByMotion(
                key, previousNote, octave, MotionDistance.STEP, MotionDirection.DOWN);
      }
    } // TODO more distinct rule cases before completely random return
    MotionDistance distance = MotionDistance.getRandomDistance(true);
    MotionDirection direction = MotionDirection.getRandomDirection(true);
    generatedNote = Note.createNewNoteByMotion(key, previousNote, octave, distance, direction);

    // if previous motion is leap greater than 3rd, change direction with step
    // Each previous note should inform the new note according to melodic rules
    // Look at the two or three previous notes and create a valid list based on them
    // and other cantus rules such as motion, tritone, climax, leaps

    return generatedNote;
  }

  /**
   * Adds the tonic note to the cantus
   *
   * @param tonic the tonic tone.
   */
  public void addTonic(Note tonic) {
    this.notes.add(0, tonic);
  }

  /**
   * Compares the first pitch in the cantus with the root of the cantus key.
   *
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
   *
   * @param quality the quality of the interval.
   * @return true if a valid cantus interval.
   */
  public boolean isValidCantusInterval(IntervalType quality) {
    return VALID_CANTUS_INTERVALS.contains(quality);
  }
}

package com.davidamateau.counterpoint.core.composition.voice;

import com.davidamateau.counterpoint.core.entity.interval.Interval;
import com.davidamateau.counterpoint.core.entity.interval.IntervalType;
import com.davidamateau.counterpoint.core.entity.key.Key;
import com.davidamateau.counterpoint.core.entity.motion.Motion;
import com.davidamateau.counterpoint.core.entity.motion.MotionDirection;
import com.davidamateau.counterpoint.core.entity.motion.MotionDistance;
import com.davidamateau.counterpoint.core.entity.note.Note;
import com.davidamateau.counterpoint.core.entity.note.NoteLetter;
import com.davidamateau.counterpoint.core.entity.note.PitchClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.davidamateau.counterpoint.core.entity.Utilities.VALID_CANTUS_INTERVALS;
import static com.davidamateau.counterpoint.core.entity.key.ScaleDegree.SUB_DOMINANT;
import static com.davidamateau.counterpoint.core.entity.key.ScaleDegree.SUPER_TONIC;

/**
 * A Cantus Firmus is a group of notes adhering to the rules of counterpoint that serves as the
 * basis for a polyphonic composition.
 */
public class CantusFirmusVoice extends Voice {
  //TODO Adjust everywhere for OCTAVE changes when crossing C, might need to always pass previous note
  //so have octave in return
  Logger log = LoggerFactory.getLogger(CantusFirmusVoice.class);

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
    CantusFirmusVoice cantus = new CantusFirmusVoice(key);
    Note tonic = new Note(key.getTonic(), octave);
    cantus.setVoiceLength(cantusLength);

    cantus.addTonic(tonic);
    cantus.addNote(cantus.generateSecondNote(key, octave));
    int index;
    for (index = 2; index < cantusLength - 2; index++) {
      Note generatedNote = generateNote(key, cantus.getNotes(), index);
      // If appears too many times in cantus or is previous pitch class, try again
      //TODO debug repeating notes
      if (cantus.pitchClassAppearance.containsKey(generatedNote.getPitchClass())) {
        if (cantus.pitchClassAppearance.get(generatedNote.getPitchClass()) > 3) {
          --index;
          continue;
        }
      } else if (generatedNote.equals(cantus.getNotes().get(index - 1))) {
        --index;
        continue;
      }

      cantus.addNote(generatedNote);
    }
    cantus.addPenUltimate(cantus.generatePenUltimate(octave), index++);
    cantus.addUltimate(tonic, index);

    return cantus;
  }

  /**
   * Generates randomly the second note for the cantus.
   *
   * @param key the key of the cantus.
   * @param octave the octave of the cantus.
   * @return the newly generated second note.
   */
  public Note generateSecondNote(Key key, int octave) {
    PitchClass secondPitchClass;

    switch (new Random().nextInt(6)) {
      case 0 -> secondPitchClass = key.getSuperTonic();
      case 1 -> secondPitchClass = key.getMediant();
      case 2 -> secondPitchClass = key.getSubDominant();
      case 3 -> secondPitchClass = key.getDominant();
      case 4 -> secondPitchClass = key.getSubMediant();
      default -> secondPitchClass = key.getLeadingTone();
    }

    if (secondPitchClass.getNoteLetter() == NoteLetter.B || new Random().nextBoolean()) {
      octave--;
    }

    return new Note(secondPitchClass, octave);
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
      log.error("A cantus must stay in continuous motion and the penultimate note must be of either the "
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
  public static Note generateNote(Key key, List<Note> previousNotes, int index) {
    Note previousNote = previousNotes.get(index - 2);
    Note currentNote = previousNotes.get(index - 1);
    Note generatedNote;
    int octave = currentNote.getOctave();
    List<Note> previousTwoNotes = new ArrayList<>();
    previousTwoNotes.add(previousNote);
    previousTwoNotes.add(currentNote);
    Motion previousMotion = new Motion(previousTwoNotes);
    Interval previousInterval = new Interval(previousNote, currentNote);

    if (previousMotion.findMotionDistance() != MotionDistance.STEP) {
      if (previousMotion.findMotionDirection() == MotionDirection.UP) {
        generatedNote =
            Note.createNewNoteByMotion(
                key, previousNote, octave, MotionDistance.STEP, MotionDirection.DOWN);
        return generatedNote;
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
    addToAppearanceMap(tonic.getPitchClass());
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

  @Override
  public String toString() {
    StringBuilder string = new StringBuilder();

    for (Note note : this.notes) {
      string
          .append(note.toString())
          .append(", ");
    }
    return string.toString();
  }
}

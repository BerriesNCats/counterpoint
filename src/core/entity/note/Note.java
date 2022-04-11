package core.entity.note;

import core.entity.key.Key;
import core.entity.motion.MotionDirection;
import core.entity.motion.MotionDistance;

public class Note {

  private final Pitch pitch;
  private final NoteDurationCommonTime duration;

  public Note(Pitch pitch) {
    this(pitch, NoteDurationCommonTime.WHOLE_NOTE);
  }

  public Note(PitchClass pitchClass, int octave) {
    this(new Pitch(pitchClass, octave), NoteDurationCommonTime.WHOLE_NOTE);
  }

  public Note(Pitch pitch, NoteDurationCommonTime duration) {
    this.pitch = pitch;
    this.duration = duration;
  }

  public static Note createNewNoteByMotion(
      Key key, Note previousNote, MotionDistance distance, MotionDirection direction) {

    // What do you need to create a Note
    // -- Pitch -- PitchClass(Note Letter/Accidental) & Octave

    // How to transform Note
    return null;
  }

  public int getNoteNumber() {
    return this.pitch.getNoteNumber();
  }

  public Pitch getPitch() {
    return this.pitch;
  }

  public PitchClass getPitchClass() {
    return this.getPitch().getPitchClass();
  }

  public int getOctave() {
    return this.getPitch().getOctave();
  }

  public NoteDurationCommonTime getDuration() {
    return duration;
  }

  public boolean isHigherThan(Note that) {
    return this.pitch.isHigherThan(that.pitch);
  }

  public boolean isSameAs(Note that) {
    return this.pitch.equals(that.pitch);
  }

  public boolean isLowerThan(Note that) {
    return this.pitch.isLowerThan(that.pitch);
  }

  public int compareTo(Note that) {
    return this.pitch.compareTo(that.pitch);
  }

  @Override
  public String toString() {
    return this.pitch.getPitchClass().toString();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }

    Note note = (Note) other;

    if (!getPitch().equals(note.getPitch())) {
      return false;
    }
    return getDuration() == note.getDuration();
  }

  @Override
  public int hashCode() {
    int result = getPitch().hashCode();
    result = 31 * result + getDuration().hashCode();
    return result;
  }
}

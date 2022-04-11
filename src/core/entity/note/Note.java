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
      Key key, Note previousNote, MotionDistance step, MotionDirection down) {
    // What do you need to create a Note
    // -- Pitch -- PitchClass(Note Letter/Accidental) & Octave

    // How to transform Note
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
}

package com.davidamateau.counterpoint.core.entity.note;

import com.davidamateau.counterpoint.core.entity.key.Key;
import com.davidamateau.counterpoint.core.entity.motion.MotionDirection;
import com.davidamateau.counterpoint.core.entity.motion.MotionDistance;

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
      Key key, Note previousNote, int octave, MotionDistance distance, MotionDirection direction) {
    PitchClass previousNotePitchClass = previousNote.getPitchClass();
    int previousNoteIndexInKey = key.findPitchClassIndex(previousNotePitchClass);
    int step = 0;
    int indexOfNewNoteInKey = 0;

    switch (distance) {
      case NONE -> step = 0;
      case STEP -> step = 1;
      case LEAP_THIRD -> step = 2;
      case LEAP_FOURTH -> step = 3;
      case LEAP_FIFTH -> step = 4;
      case LEAP_SIXTH -> step = 5;
      case LEAP_SEVENTH -> step = 6;
      case LEAP_OCTAVE -> step = 7;
    }

    switch (direction) {
      case UP -> step = Math.abs(step);
      case DOWN -> step = - step;
    }
    indexOfNewNoteInKey = previousNoteIndexInKey + step;

    if (indexOfNewNoteInKey >= 7) indexOfNewNoteInKey -= 7;
    if (indexOfNewNoteInKey < 0) indexOfNewNoteInKey += 7;

    return new Note(key.getScale().get(indexOfNewNoteInKey), octave);
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
    return this.pitch.toString();
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


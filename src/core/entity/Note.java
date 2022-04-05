package core.entity;

import core.entity.pitch.Pitch;
import core.entity.pitch.PitchClass;

public class Note {

  private final Pitch pitch;
  private final NoteDurationCommonTime duration;

  public Note(Pitch pitch) {
    this.pitch = pitch;
    this.duration = NoteDurationCommonTime.WHOLE_NOTE;
  }

  public Note(Pitch pitch, NoteDurationCommonTime duration) {
    this.pitch = pitch;
    this.duration = duration;
  }

  public Note(PitchClass pitchClass, int octave) {
    this.pitch = new Pitch(pitchClass, octave);
    this.duration = NoteDurationCommonTime.WHOLE_NOTE;
  }

  public Pitch getPitch() {
    return pitch;
  }

  public PitchClass getPitchClass() {
    return this.getPitch().getPitchClass();
  }

  public NoteDurationCommonTime getDuration() {
    return duration;
  }

  public boolean isHigherThan(Note that) {
    return this.pitch.isHigherThan(that.pitch);
  }

  public boolean isLowerThan(Note that) {
    return this.pitch.isLowerThan(that.pitch);
  }

  public int compareTo(Note that) {
    return this.pitch.compareTo(that.pitch);
  }

  @Override
  public String toString() {
    return pitch.getPitchClass().toString();
  }
}

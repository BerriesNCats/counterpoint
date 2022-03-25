package core.entity;

import core.entity.pitch.Pitch;

public class Note {

  private final Pitch pitch;
  private final NoteDurationCommonTime duration;


  public Note(Pitch pitch, NoteDurationCommonTime duration) {
    this.pitch = pitch;
    this.duration = duration;
  }

  public Pitch getPitch() {
    return pitch;
  }

  public NoteDurationCommonTime getDuration() {
    return duration;
  }

  @Override
  public String toString() {
    return pitch.getPitchClass().toString();
  }
}

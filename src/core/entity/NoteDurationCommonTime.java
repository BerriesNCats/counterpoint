package core.entity;

public enum NoteDurationCommonTime {
  WHOLE_NOTE(4.0),
  HALF_NOTE(2.0),
  QUARTER_NOTE(1.0),
  EIGHTH_NOTE(.5),
  SIXTEENTH_NOTE(.25),
  THIRTY_SECOND_NOTE(.125);

  private final double length;

  NoteDurationCommonTime(double length) {
    this.length = length;
  }

  public double getLength() { return this.length; }
}

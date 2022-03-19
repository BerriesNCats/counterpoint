package core.entity;

// This duration class is explicitly only functional for counterpoint exercises where we are
// not truly concerned with time signatures or length of a measure but merely a notes duration
// in comparison to the duration of notes from other voices.
public enum Duration {
  WHOLE(4.0),
  HALF(2.0),
  QUARTER(1.0),
  EIGHTH(.5),
  SIXTEENTH(.25);

  private final double length;

  Duration(double length) {
    this.length = length;
  }

  public double getLength() { return this.length; }
}

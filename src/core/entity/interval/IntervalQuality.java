package core.entity.interval;

public enum IntervalQuality {
  UNISON(0, 0),
  MINOR_SECOND(1, 1),
  MAJOR_SECOND(1, 2),
  MINOR_THIRD(2, 3),
  MAJOR_THIRD(2, 4),
  PERFECT_FOURTH(3, 5),
  TRITONE(3, 6),
  PERFECT_FIFTH(4, 7),
  MINOR_SIXTH(5, 8),
  MAJOR_SIXTH(5, 9),
  MINOR_SEVENTH(6, 10),
  MAJOR_SEVENTH(6, 11),
  OCTAVE(7, 12);

  private final int stepInKey;
  private final int stepInSemitones;

  IntervalQuality(int stepInKey, int stepInSemitones) {
    this.stepInKey = stepInKey;
    this.stepInSemitones = stepInSemitones;
  }

  public int getStepInKey() {
    return this.stepInKey;
  }

  public int getStepInSemitones() {
    return this.stepInSemitones;
  }
}

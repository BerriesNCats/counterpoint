package core.entity.interval;

import java.util.Random;

/**
 * An Interval Type describes the distance between a set of pitches.
 */
public enum IntervalType {
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

  private final int stepsInKey;
  private final int stepsInSemitones;

  IntervalType(int stepsInKey, int stepsInSemitones) {
    this.stepsInKey = stepsInKey;
    this.stepsInSemitones = stepsInSemitones;
  }

  public static IntervalType getRandomIntervalType(boolean excludeTritoneAndUnison) {
    if (excludeTritoneAndUnison) {
      return switch (new Random().nextInt(10)) {
        case 0 -> MINOR_SECOND;
        case 1 -> MAJOR_SECOND;
        case 2 -> MINOR_THIRD;
        case 3 -> MAJOR_THIRD;
        case 4 -> PERFECT_FOURTH;
        case 5 -> PERFECT_FIFTH;
        case 6 -> MINOR_SIXTH;
        case 7 -> MAJOR_SIXTH;
        case 8 -> MINOR_SEVENTH;
        case 9 -> MAJOR_SEVENTH;
        case 10 -> OCTAVE;
        default -> null;
      };
    } else {
      return switch (new Random().nextInt(12)) {
        case 0 -> UNISON;
        case 1 -> MINOR_SECOND;
        case 2 -> MAJOR_SECOND;
        case 3 -> MINOR_THIRD;
        case 4 -> MAJOR_THIRD;
        case 5 -> PERFECT_FOURTH;
        case 6 -> TRITONE;
        case 7 -> PERFECT_FIFTH;
        case 8 -> MINOR_SIXTH;
        case 9 -> MAJOR_SIXTH;
        case 10 -> MINOR_SEVENTH;
        case 11 -> MAJOR_SEVENTH;
        case 12 -> OCTAVE;
        default -> null;
      };
    }
  }

  public int getStepsInKey() {
    return this.stepsInKey;
  }

  public int getStepsInSemitones() {
    return this.stepsInSemitones;
  }
}

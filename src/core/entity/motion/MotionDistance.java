package core.entity.motion;

import java.util.Random;

public enum MotionDistance {
  NONE,
  STEP,
  LEAP_THIRD,
  LEAP_FOURTH,
  LEAP_FIFTH,
  LEAP_SIXTH,
  LEAP_SEVENTH,
  LEAP_OCTAVE;

  public static MotionDistance getRandomDistance(boolean excludeNone) {
    Random r = new Random();
    int random;

    if (excludeNone) {
      random = r.nextInt(7);
      return switch (random) {
        case 0 -> MotionDistance.STEP;
        case 1 -> MotionDistance.LEAP_THIRD;
        case 2 -> MotionDistance.LEAP_FOURTH;
        case 3 -> MotionDistance.LEAP_FIFTH;
        case 4 -> MotionDistance.LEAP_SIXTH;
        case 5 -> MotionDistance.LEAP_SEVENTH;
        default -> MotionDistance.LEAP_OCTAVE;
      };
    } else {
      random = r.nextInt(8);
      return switch (random) {
        case 0 -> MotionDistance.STEP;
        case 1 -> MotionDistance.LEAP_THIRD;
        case 2 -> MotionDistance.LEAP_FOURTH;
        case 3 -> MotionDistance.LEAP_FIFTH;
        case 4 -> MotionDistance.LEAP_SIXTH;
        case 5 -> MotionDistance.LEAP_SEVENTH;
        case 6 -> MotionDistance.LEAP_OCTAVE;
        default -> MotionDistance.NONE;
      };
    }


  }
}

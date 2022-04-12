package com.davidamateau.counterpoint.core.entity.motion;

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
        case 0 -> STEP;
        case 1 -> LEAP_THIRD;
        case 2 -> LEAP_FOURTH;
        case 3 -> LEAP_FIFTH;
        case 4 -> LEAP_SIXTH;
        case 5 -> LEAP_SEVENTH;
        default -> LEAP_OCTAVE;
      };
    } else {
      random = r.nextInt(8);
      return switch (random) {
        case 0 -> STEP;
        case 1 -> LEAP_THIRD;
        case 2 -> LEAP_FOURTH;
        case 3 -> LEAP_FIFTH;
        case 4 -> LEAP_SIXTH;
        case 5 -> LEAP_SEVENTH;
        case 6 -> LEAP_OCTAVE;
        default -> NONE;
      };
    }
  }
}


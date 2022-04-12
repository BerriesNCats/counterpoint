package com.davidamateau.counterpoint.core.entity.interval;

import java.util.Random;

public enum IntervalQuality {
  PERFECT_CONSONANCE,
  DISSONANCE,
  IMPERFECT_CONSONANCE;

  public static IntervalQuality getRandomIntervalQuality() {
    return switch (new Random().nextInt(3)) {
      case 0 -> PERFECT_CONSONANCE;
      case 1 -> DISSONANCE;
      default -> IMPERFECT_CONSONANCE;
    };
  }
}


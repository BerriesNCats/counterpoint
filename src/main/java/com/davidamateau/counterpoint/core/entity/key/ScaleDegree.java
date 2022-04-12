package com.davidamateau.counterpoint.core.entity.key;

import java.util.Random;

public enum ScaleDegree {
  TONIC,
  SUPER_TONIC,
  MEDIANT,
  SUB_DOMINANT,
  DOMINANT,
  SUB_MEDIANT,
  LEADING_TONE;

  public static ScaleDegree getRandomScaleDegree() {
    return switch (new Random().nextInt(7)) {
      case 0 -> TONIC;
      case 1 -> SUPER_TONIC;
      case 2 -> MEDIANT;
      case 3 -> SUB_DOMINANT;
      case 4 -> DOMINANT;
      case 5 -> SUB_MEDIANT;
      default -> LEADING_TONE;
    };
  }
}

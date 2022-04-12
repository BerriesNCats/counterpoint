package com.davidamateau.counterpoint.core.entity.note;

import java.util.Random;

public enum NoteLetter {
  A,
  B,
  C,
  D,
  E,
  F,
  G;

  public static NoteLetter getRandomNoteLetter() {
    return switch (new Random().nextInt(7)) {
      case 0 -> A;
      case 1 -> B;
      case 2 -> C;
      case 3 -> D;
      case 4 -> E;
      case 5 -> F;
      default -> G;
    };
  }
}

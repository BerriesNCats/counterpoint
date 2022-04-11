package core.entity.note;

import java.util.Random;

public enum Accidental {
  NATURAL(""),
  SHARP("#"),
  FLAT("b");

  private final String accidental;

  Accidental(String accidental) {
    this.accidental = accidental;
  }

  public String getAccidental() {
    return this.accidental;
  }

  public static Accidental getRandomAccidental() {
    return switch (new Random().nextInt(3)) {
      case 0 -> NATURAL;
      case 1 -> SHARP;
      default -> FLAT;
    };
  }
}

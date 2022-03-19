package core.entity.pitch;

public enum PitchLetter {
  A("A"),
  B("B"),
  C("C"),
  D("D"),
  E("E"),
  F("F"),
  G("G");

  private final String letter;

  PitchLetter(String letter) { this.letter = letter; }

  public String getLetter() {
    return this.letter;
  }
}

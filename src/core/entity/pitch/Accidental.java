package core.entity.pitch;

public enum Accidental {
  NATURAL(""),
  SHARP("#"),
  FLAT("b");

  private final String accidental;

  Accidental(String accidental) { this.accidental = accidental; }

  public String getAccidental() {
    return this.accidental;
  }
}

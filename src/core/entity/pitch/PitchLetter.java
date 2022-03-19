package core.entity.pitch;

public enum PitchLetter {
  A('A'),
  B('B'),
  C('C'),
  D('D'),
  E('E'),
  F('F'),
  G('G');

  private final char letter;

  PitchLetter(char letter) { this.letter = letter; }

  public char getLetter() {
    return this.letter;
  }
}

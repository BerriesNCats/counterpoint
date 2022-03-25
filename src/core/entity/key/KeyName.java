package core.entity.key;

import core.entity.pitch.Accidental;
import static core.entity.pitch.Accidental.*;
import static core.entity.key.KeyQuality.*;
import static core.entity.pitch.NoteLetter.*;

public enum KeyName {
  A_FLAT_MAJOR(4, FLAT, MAJOR, A.name() + FLAT.name()),
  A_FLAT_MINOR(7, FLAT, MINOR, A.name() + FLAT.name()),
  A_MAJOR(3, SHARP, MAJOR, A.name()),
  A_MINOR(0, NATURAL, MINOR, A.name()),
  A_SHARP_MINOR(7, SHARP, MINOR, A.name() + SHARP.name()),
  B_FLAT_MAJOR(2, FLAT, MAJOR, B.name() + FLAT.name()),
  B_FLAT_MINOR(5, FLAT, MINOR, B.name() + FLAT.name()),
  B_MAJOR(5, SHARP, MAJOR, B.name()),
  B_MINOR(2, SHARP, MINOR, B.name()),
  C_FLAT_MAJOR(7, FLAT, MAJOR, C.name() + FLAT.name()),
  C_MAJOR(0, NATURAL, MAJOR, C.name()),
  C_MINOR(3, FLAT, MINOR, C.name()),
  C_SHARP_MAJOR(7, SHARP, MAJOR, C.name() + SHARP.name()),
  C_SHARP_MINOR(4, SHARP, MINOR, C.name() + SHARP.name()),
  D_FLAT_MAJOR(5, FLAT, MAJOR, D.name() + FLAT.name()),
  D_MAJOR(2, SHARP, MAJOR, D.name()),
  D_MINOR(1, FLAT, MINOR, D.name()),
  D_SHARP_MINOR(6, SHARP, MINOR, D.name() + SHARP.name()),
  E_FLAT_MAJOR(3, FLAT, MAJOR, E.name() + FLAT.name()),
  E_FLAT_MINOR(6, FLAT, MINOR, E.name() + FLAT.name()),
  E_MAJOR(4, SHARP, MAJOR, E.name()),
  E_MINOR(1, SHARP, MINOR, E.name()),
  F_MAJOR(1, FLAT, MAJOR, F.name()),
  F_MINOR(4, FLAT, MINOR, F.name()),
  F_SHARP_MAJOR(6, SHARP, MAJOR, F.name() + SHARP.name()),
  F_SHARP_MINOR(3, SHARP, MINOR, F.name() + SHARP.name()),
  G_FLAT_MAJOR( 6, FLAT, MAJOR, G.name() + FLAT.name()),
  G_MAJOR(1, SHARP, MAJOR, G.name()),
  G_MINOR(2, FLAT, MINOR, G.name()),
  G_SHARP_MINOR(5, SHARP, MINOR, G.name() + SHARP.name());

  private final int numberOfSharpsOrFlats;
  private final Accidental accidental;
  private final KeyQuality quality;
  private final String tonic;

  KeyName(int numberOfSharpsOrFlats, Accidental accidental, KeyQuality quality,
      String tonic) {
    this.numberOfSharpsOrFlats = numberOfSharpsOrFlats;
    this.accidental = accidental;
    this.quality = quality;
    this.tonic = tonic;
  }

  public int getNumberOfSharpsOrFlats() {
    return this.numberOfSharpsOrFlats;
  }
  public Accidental getAccidental() {
    return this.accidental;
  }
  public KeyQuality getQuality() {
    return this.quality;
  }
  public String getTonic() { return this.tonic; }
}

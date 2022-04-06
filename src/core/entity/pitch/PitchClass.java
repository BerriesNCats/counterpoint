package core.entity.pitch;

import static core.UtilityListsAndMaps.PITCH_NUMBERS;
import static core.entity.pitch.Accidental.*;
import static core.entity.pitch.NoteLetter.A;
import static core.entity.pitch.NoteLetter.B;
import static core.entity.pitch.NoteLetter.C;
import static core.entity.pitch.NoteLetter.D;
import static core.entity.pitch.NoteLetter.E;
import static core.entity.pitch.NoteLetter.F;
import static core.entity.pitch.NoteLetter.G;

import java.util.HashMap;
import java.util.Map;

public class PitchClass {

  private final NoteLetter noteLetter;
  private final Accidental accidental;
  private final int pitchNumber;

  public PitchClass(NoteLetter noteLetter) {
    this.noteLetter = noteLetter;
    this.accidental = NATURAL;
    this.pitchNumber = findPitchNumber();
  }

  public PitchClass(NoteLetter noteLetter, Accidental accidental) {
    this.noteLetter = noteLetter;
    this.accidental = accidental;
    this.pitchNumber = this.findPitchNumber();
  }

  public int findPitchNumber() {
    String pitchName = noteLetter.name() + accidental.getAccidental();
    return PITCH_NUMBERS.get(pitchName);
  }

  public NoteLetter getNoteLetter() {
    return this.noteLetter;
  }

  public Accidental getAccidental() {
    return this.accidental;
  }

  public int getPitchNumber() {
    return this.pitchNumber;
  }

  @Override
  public String toString() {
    return noteLetter.name() + accidental.getAccidental();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    PitchClass that = (PitchClass) o;

    if (getPitchNumber() != that.getPitchNumber()) {
      return false;
    }
    if (getNoteLetter() != that.getNoteLetter()) {
      return false;
    }
    return getAccidental() == that.getAccidental();
  }

  @Override
  public int hashCode() {
    int result = getNoteLetter().hashCode();
    result = 31 * result + getAccidental().hashCode();
    result = 31 * result + getPitchNumber();
    return result;
  }
}

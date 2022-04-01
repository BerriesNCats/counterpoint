package core.entity.pitch;

import java.util.HashMap;
import java.util.Map;

import static core.entity.pitch.Accidental.*;
import static core.entity.pitch.NoteLetter.*;

public class PitchClass {

  public static final Map<String, Integer> PITCH_NUMBERS = loadPitchNumbers();
  public static final HashMap<String, PitchClass> PITCH_CLASSES = loadPitchClasses();

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

  public static HashMap<String, PitchClass> loadPitchClasses() {
    return new HashMap<>() {
      {
        put(A.name(), new PitchClass(A, NATURAL));
        put(B.name(), new PitchClass(B, NATURAL));
        put(C.name(), new PitchClass(C, NATURAL));
        put(D.name(), new PitchClass(D, NATURAL));
        put(E.name(), new PitchClass(E, NATURAL));
        put(F.name(), new PitchClass(F, NATURAL));
        put(G.name(), new PitchClass(G, NATURAL));

        put(A.name() + FLAT.getAccidental(), new PitchClass(A, FLAT));
        put(B.name() + FLAT.getAccidental(), new PitchClass(B, FLAT));
        put(C.name() + FLAT.getAccidental(), new PitchClass(C, FLAT));
        put(D.name() + FLAT.getAccidental(), new PitchClass(D, FLAT));
        put(E.name() + FLAT.getAccidental(), new PitchClass(E, FLAT));
        put(F.name() + FLAT.getAccidental(), new PitchClass(F, FLAT));
        put(G.name() + FLAT.getAccidental(), new PitchClass(G, FLAT));

        put(A.name() + SHARP.getAccidental(), new PitchClass(A, SHARP));
        put(B.name() + SHARP.getAccidental(), new PitchClass(B, SHARP));
        put(C.name() + SHARP.getAccidental(), new PitchClass(C, SHARP));
        put(D.name() + SHARP.getAccidental(), new PitchClass(D, SHARP));
        put(E.name() + SHARP.getAccidental(), new PitchClass(E, SHARP));
        put(F.name() + SHARP.getAccidental(), new PitchClass(F, SHARP));
        put(G.name() + SHARP.getAccidental(), new PitchClass(G, SHARP));
      }
    };
  }

  public int findPitchNumber() {
    String pitchName = noteLetter.name() + accidental.getAccidental();
    return PITCH_NUMBERS.get(pitchName);
  }

  public static Map<String, Integer> loadPitchNumbers() {
    return new HashMap<>() {
      {
        put(C.name() + FLAT.getAccidental(), -1);
        put(C.name() + NATURAL.getAccidental(), 0);
        put(C.name() + SHARP.getAccidental(), 1);
        put(D.name() + FLAT.getAccidental(), 1);
        put(D.name() + NATURAL.getAccidental(), 2);
        put(D.name() + SHARP.getAccidental(), 3);
        put(E.name() + FLAT.getAccidental(), 3);
        put(E.name() + NATURAL.getAccidental(), 4);
        put(F.name() + FLAT.getAccidental(), 4);
        put(E.name() + SHARP.getAccidental(), 5);
        put(F.name() + NATURAL.getAccidental(), 5);
        put(F.name() + SHARP.getAccidental(), 6);
        put(G.name() + FLAT.getAccidental(), 6);
        put(G.name() + NATURAL.getAccidental(), 7);
        put(G.name() + SHARP.getAccidental(), 8);
        put(A.name() + FLAT.getAccidental(), 8);
        put(A.name() + NATURAL.getAccidental(), 9);
        put(A.name() + SHARP.getAccidental(), 10);
        put(B.name() + FLAT.getAccidental(), 10);
        put(B.name() + NATURAL.getAccidental(), 11);
        put(B.name() + SHARP.getAccidental(), 12);
      }
    };
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

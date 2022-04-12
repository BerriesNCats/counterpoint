package com.davidamateau.counterpoint.core.entity.note;

import static com.davidamateau.counterpoint.core.entity.note.Accidental.*;
import static com.davidamateau.counterpoint.core.entity.note.NoteLetter.*;

import java.util.HashMap;

public class PitchClass {

  public static final HashMap<String, Integer> PITCH_NUMBERS = loadPitchNumbers();

  private final NoteLetter noteLetter;
  private final Accidental accidental;
  private final int pitchNumber;

  public PitchClass(NoteLetter noteLetter) {
    this(noteLetter, NATURAL);
  }

  public PitchClass(NoteLetter noteLetter, Accidental accidental) {
    this.noteLetter = noteLetter;
    this.accidental = accidental;
    this.pitchNumber = findPitchNumber();
  }

  public int findPitchNumber() {
    String pitchName = noteLetter.name() + accidental.getAccidental();
    return PITCH_NUMBERS.get(pitchName);
  }

  public static HashMap<String, Integer> loadPitchNumbers() {
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
    return this.noteLetter.name() + this.accidental.getAccidental();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || this.getClass() != other.getClass()) {
      return false;
    }

    PitchClass otherPitchClass = (PitchClass) other;

    if (this.getPitchNumber() != otherPitchClass.getPitchNumber()) {
      return false;
    }
    if (this.getNoteLetter() != otherPitchClass.getNoteLetter()) {
      return false;
    }
    return this.getAccidental() == otherPitchClass.getAccidental();
  }

  @Override
  public int hashCode() {
    int result = getNoteLetter().hashCode();
    result = 31 * result + getAccidental().hashCode();
    result = 31 * result + getPitchNumber();
    return result;
  }
}

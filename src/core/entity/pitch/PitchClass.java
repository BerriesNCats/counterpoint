package core.entity.pitch;

import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.Contract;

import static core.entity.pitch.NoteLetter.*;
import static core.entity.pitch.Accidental.*;

public class PitchClass {

  public static final Map<String, Integer> PITCH_NUMBERS = loadPitchNumbers();

  private final NoteLetter noteLetter;
  private final Accidental accidental;
  private final int pitchNumber;

  public PitchClass(NoteLetter noteLetter, Accidental accidental) {
    this.noteLetter = noteLetter;
    this.accidental = accidental;
    this.pitchNumber = findPitchNumber(noteLetter, accidental);
  }

  private int findPitchNumber(NoteLetter noteLetter, Accidental accidental) {
    String pitchName = noteLetter.name() + accidental.getAccidental();
    return PITCH_NUMBERS.get(pitchName);
  }

  @Contract(" -> new")
  private static Map<String, Integer> loadPitchNumbers() {
    return new HashMap<String, Integer>() {
      {
        put(C.name() + FLAT.getAccidental(), 11);
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
        put(B.name() + SHARP.getAccidental(), 0);
      }
    };
  }

  public NoteLetter getPitchLetter() {
    return this.noteLetter;
  }
  public Accidental getAccidental() {
    return this.accidental;
  }
  public int getPitchNumber() { return this.pitchNumber; }

  @Override
  public String toString() {
    return noteLetter.name() + accidental.getAccidental();
  }
}

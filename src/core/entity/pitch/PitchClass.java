package core.entity.pitch;

import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.Contract;

import static core.entity.pitch.PitchLetter.*;
import static core.entity.pitch.Accidental.*;

public class PitchClass {

  private static final Map<String, Integer> PITCH_NUMBERS = loadPitchNumbers();

  private final PitchLetter pitchLetter;
  private final Accidental accidental;
  private final int pitchNumber;

  public PitchClass(PitchLetter pitchLetter, Accidental accidental) {
    this.pitchLetter = pitchLetter;
    this.accidental = accidental;
    this.pitchNumber = findPitchNumber(pitchLetter, accidental);
  }

  private int findPitchNumber(PitchLetter pitchLetter, Accidental accidental) {
    String pitchName = pitchLetter.getLetter() + accidental.getAccidental();
    return PITCH_NUMBERS.get(pitchName);
  }

  @Contract(" -> new")
  private static Map<String, Integer> loadPitchNumbers() {
    return new HashMap<String, Integer>() {
      {
        put(C.getLetter() + FLAT.getAccidental(), 11);
        put(C.getLetter() + NATURAL.getAccidental(), 0);
        put(C.getLetter() + SHARP.getAccidental(), 1);
        put(D.getLetter() + FLAT.getAccidental(), 1);
        put(D.getLetter() + NATURAL.getAccidental(), 2);
        put(D.getLetter() + SHARP.getAccidental(), 3);
        put(E.getLetter() + FLAT.getAccidental(), 3);
        put(E.getLetter() + NATURAL.getAccidental(), 4);
        put(F.getLetter() + FLAT.getAccidental(), 4);
        put(E.getLetter() + SHARP.getAccidental(), 5);
        put(F.getLetter() + NATURAL.getAccidental(), 5);
        put(F.getLetter() + SHARP.getAccidental(), 6);
        put(G.getLetter() + FLAT.getAccidental(), 6);
        put(G.getLetter() + NATURAL.getAccidental(), 7);
        put(G.getLetter() + SHARP.getAccidental(), 8);
        put(A.getLetter() + FLAT.getAccidental(), 8);
        put(A.getLetter() + NATURAL.getAccidental(), 9);
        put(A.getLetter() + SHARP.getAccidental(), 10);
        put(B.getLetter() + FLAT.getAccidental(), 10);
        put(B.getLetter() + NATURAL.getAccidental(), 11);
        put(B.getLetter() + SHARP.getAccidental(), 0);
      }
    };
  }

  public PitchLetter getPitchLetter() {
    return pitchLetter;
  }
  public Accidental getAccidental() {
    return accidental;
  }
  public int getPitchNumber() { return this.pitchNumber; }

  @Override
  public String toString() {
    return pitchLetter.getLetter() + accidental.getAccidental();
  }
}

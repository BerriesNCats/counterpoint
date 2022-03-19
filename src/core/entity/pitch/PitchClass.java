package core.entity.pitch;

import java.util.HashMap;
import java.util.Map;

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

  private static Map<String, Integer> loadPitchNumbers() {
    return new HashMap<String, Integer>() {{
      put("Cb", 11);
      put("C",  0);
      put("C#", 1);
      put("Db", 1);
      put("D",  2);
      put("D#", 3);
      put("Eb", 3);
      put("E",  4);
      put("Fb", 4);
      put("E#", 5);
      put("F",  5);
      put("F#", 6);
      put("Gb", 6);
      put("G",  7);
      put("G#", 8);
      put("Ab", 8);
      put("A",  9);
      put("A#", 10);
      put("Bb", 10);
      put("B",  11);
      put("B#", 0);
    }};
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

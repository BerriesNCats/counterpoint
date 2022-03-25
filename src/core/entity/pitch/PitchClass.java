package core.entity.pitch;


import java.util.Map;
import static core.entity.key.KeyUtils.*;


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

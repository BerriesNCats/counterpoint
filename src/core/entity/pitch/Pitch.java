package core.entity.pitch;

public class Pitch implements Comparable<Pitch> {

  private final PitchClass pitchClass;
  private final int octave;
  private final int noteNumber;
  private final int midiNoteNumber;

  public Pitch(PitchClass pitchClass, int octave) {
    this.pitchClass = pitchClass;
    this.octave = octave;
    this.noteNumber = findNoteNumber(pitchClass, octave);
    this.midiNoteNumber = findMidiNoteNumber(noteNumber);
  }

  public int findMidiNoteNumber(int noteNumber) {
    return noteNumber + 21;
  }

  public int findNoteNumber(PitchClass pitchClass, int octave) {
    int noteNumber = pitchClass.getPitchNumber();
    if (noteNumber < -1) throw new IllegalArgumentException("Valid Pitch Numbers are -1 - 12");

    if (pitchClass.getNoteLetter().equals(NoteLetter.A)) {
      if (!pitchClass.getAccidental().equals(Accidental.FLAT)) {
        if (octave == 0) return noteNumber - 9;
      }
      noteNumber += 3;
    } else if (pitchClass.getNoteLetter().equals(NoteLetter.B)) {
      if (octave == 0) return noteNumber - 9;
      noteNumber += 3;
    } else {
      noteNumber += 3;
    }

    if (octave == 1) return noteNumber;

    return noteNumber + ((octave - 1) * 12);
  }

  public boolean isHigherThan(Pitch that) {
    return this.noteNumber > that.noteNumber;
  }

  public boolean isLowerThan(Pitch that) {
    return this.noteNumber < that.noteNumber;
  }

  /** @return The distance in semitones between pitches. */
  @Override
  public int compareTo(Pitch that) {
    return this.noteNumber - that.noteNumber;
  }

  @Override
  public boolean equals(Object that) {
    if (this == that) {
      return true;
    }
    if (!(that instanceof Pitch)) {
      return false;
    }

    Pitch pitch = (Pitch) that;

    if (this.getOctave() != pitch.getOctave()) {
      return false;
    }
    if (this.getNoteNumber() != pitch.getNoteNumber()) {
      return false;
    }
    return this.getPitchClass().equals(pitch.getPitchClass());
  }

  @Override
  public int hashCode() {
    int result = getPitchClass().hashCode();
    result = 31 * result + getOctave();
    result = 31 * result + getNoteNumber();
    return result;
  }

  public PitchClass getPitchClass() {
    return this.pitchClass;
  }

  public int getOctave() {
    return this.octave;
  }

  public int getNoteNumber() {
    return this.noteNumber;
  }

  public int getMidiNoteNumber() {
    return this.midiNoteNumber;
  }

  @Override
  public String toString() {
    return this.pitchClass.toString() + this.octave;
  }
}

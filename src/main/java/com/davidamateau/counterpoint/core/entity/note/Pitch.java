package com.davidamateau.counterpoint.core.entity.note;

import static com.davidamateau.counterpoint.core.entity.Utilities.DEFAULT_OCTAVE;

public class Pitch implements Comparable<Pitch> {

  private final PitchClass pitchClass;
  private final int octave;
  private final int noteNumber;
  private final int midiNoteNumber;

  public Pitch(PitchClass pitchClass) {
    this(pitchClass, DEFAULT_OCTAVE);
  }

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
    if (noteNumber < -1)
      throw new IllegalArgumentException("Valid Pitch Numbers must be in range of -1, 12");

    // Transform Pitch Number Identity to Note Number Identity
    if ((pitchClass.getNoteLetter().equals(NoteLetter.A)
        && !pitchClass.getAccidental().equals(Accidental.FLAT)
        && octave == 0)
        || (pitchClass.getNoteLetter().equals(NoteLetter.B) && octave == 0)) {
      return noteNumber - 9;
    } else {
      noteNumber += 3;
    }

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
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof Pitch)) {
      return false;
    }

    Pitch otherPitch = (Pitch) other;

    if (this.getOctave() != otherPitch.getOctave()) {
      return false;
    }
    if (this.getNoteNumber() != otherPitch.getNoteNumber()) {
      return false;
    }
    return this.getPitchClass().equals(otherPitch.getPitchClass());
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

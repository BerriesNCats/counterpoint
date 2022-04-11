package test;

import static org.junit.jupiter.api.Assertions.*;
import static core.entity.note.NoteLetter.*;
import static core.entity.note.Accidental.*;

import core.entity.note.Pitch;
import core.entity.note.PitchClass;
import org.junit.Test;

class PitchTest {

  @Test
  public void findNoteNumberForA() {
    Pitch aNatural0 = new Pitch(new PitchClass(A, NATURAL), 0);
    Pitch aSharp0 = new Pitch(new PitchClass(A, SHARP), 0);
    Pitch aFlat1 = new Pitch(new PitchClass(A, FLAT), 1);
    Pitch aNatural1 = new Pitch(new PitchClass(A, NATURAL), 1);
    Pitch aSharp1 = new Pitch(new PitchClass(A, SHARP), 1);
    Pitch aFlat2 = new Pitch(new PitchClass(A, FLAT), 2);
    Pitch aNatural2 = new Pitch(new PitchClass(A, NATURAL), 2);
    Pitch aSharp2 = new Pitch(new PitchClass(A, SHARP), 2);

    assertEquals(0, aNatural0.getNoteNumber());
    assertEquals(1, aSharp0.getNoteNumber());
    assertEquals(11, aFlat1.getNoteNumber());
    assertEquals(12, aNatural1.getNoteNumber());
    assertEquals(13, aSharp1.getNoteNumber());
    assertEquals(23, aFlat2.getNoteNumber());
    assertEquals(24, aNatural2.getNoteNumber());
    assertEquals(25, aSharp2.getNoteNumber());
  }

  @Test
  public void findNoteNumberForB() {
    Pitch bFlat0 = new Pitch(new PitchClass(B, FLAT), 0);
    Pitch bNatural0 = new Pitch(new PitchClass(B, NATURAL), 0);
    Pitch bSharp0 = new Pitch(new PitchClass(B, SHARP), 0);
    Pitch bFlat1 = new Pitch(new PitchClass(B, FLAT), 1);
    Pitch bNatural1 = new Pitch(new PitchClass(B, NATURAL), 1);
    Pitch bSharp1 = new Pitch(new PitchClass(B, SHARP), 1);
    Pitch bFlat2 = new Pitch(new PitchClass(B, FLAT), 2);
    Pitch bNatural2 = new Pitch(new PitchClass(B, NATURAL), 2);
    Pitch bSharp2 = new Pitch(new PitchClass(B, SHARP), 2);

    assertEquals(1, bFlat0.getNoteNumber());
    assertEquals(2, bNatural0.getNoteNumber());
    assertEquals(3, bSharp0.getNoteNumber());
    assertEquals(13, bFlat1.getNoteNumber());
    assertEquals(14, bNatural1.getNoteNumber());
    assertEquals(15, bSharp1.getNoteNumber());
    assertEquals(25, bFlat2.getNoteNumber());
    assertEquals(26, bNatural2.getNoteNumber());
    assertEquals(27, bSharp2.getNoteNumber());
  }

  @Test
  public void findNoteNumberForC() {
    Pitch cFlat1 = new Pitch(new PitchClass(C, FLAT), 1);
    Pitch cNatural1 = new Pitch(new PitchClass(C, NATURAL), 1);
    Pitch cSharp1 = new Pitch(new PitchClass(C, SHARP), 1);
    Pitch cFlat2 = new Pitch(new PitchClass(C, FLAT), 2);
    Pitch cNatural2 = new Pitch(new PitchClass(C, NATURAL), 2);
    Pitch cSharp2 = new Pitch(new PitchClass(C, SHARP), 2);
    Pitch cFlat3 = new Pitch(new PitchClass(C, FLAT), 3);
    Pitch cNatural3 = new Pitch(new PitchClass(C, NATURAL), 3);
    Pitch cSharp3 = new Pitch(new PitchClass(C, SHARP), 3);

    assertEquals(2, cFlat1.getNoteNumber());
    assertEquals(3, cNatural1.getNoteNumber());
    assertEquals(4, cSharp1.getNoteNumber());
    assertEquals(14, cFlat2.getNoteNumber());
    assertEquals(15, cNatural2.getNoteNumber());
    assertEquals(16, cSharp2.getNoteNumber());
    assertEquals(26, cFlat3.getNoteNumber());
    assertEquals(27, cNatural3.getNoteNumber());
    assertEquals(28, cSharp3.getNoteNumber());
  }

  @Test
  public void findNoteNumberForD() {
    Pitch dFlat1 = new Pitch(new PitchClass(D, FLAT), 1);
    Pitch dNatural1 = new Pitch(new PitchClass(D, NATURAL), 1);
    Pitch dSharp1 = new Pitch(new PitchClass(D, SHARP), 1);
    Pitch dFlat2 = new Pitch(new PitchClass(D, FLAT), 2);
    Pitch dNatural2 = new Pitch(new PitchClass(D, NATURAL), 2);
    Pitch dSharp2 = new Pitch(new PitchClass(D, SHARP), 2);
    Pitch dFlat3 = new Pitch(new PitchClass(D, FLAT), 3);
    Pitch dNatural3 = new Pitch(new PitchClass(D, NATURAL), 3);
    Pitch dSharp3 = new Pitch(new PitchClass(D, SHARP), 3);

    assertEquals(4, dFlat1.getNoteNumber());
    assertEquals(5, dNatural1.getNoteNumber());
    assertEquals(6, dSharp1.getNoteNumber());
    assertEquals(16, dFlat2.getNoteNumber());
    assertEquals(17, dNatural2.getNoteNumber());
    assertEquals(18, dSharp2.getNoteNumber());
    assertEquals(28, dFlat3.getNoteNumber());
    assertEquals(29, dNatural3.getNoteNumber());
    assertEquals(30, dSharp3.getNoteNumber());
  }

  @Test
  public void findMidiNoteNumber() {
    Pitch pitch1 = new Pitch(new PitchClass(A, NATURAL), 0);
    Pitch pitch2 = new Pitch(new PitchClass(C, NATURAL), 1);
    Pitch pitch3 = new Pitch(new PitchClass(C, NATURAL), 3);
    Pitch pitch4 = new Pitch(new PitchClass(F, SHARP), 4);
    Pitch pitch5 = new Pitch(new PitchClass(E, SHARP), 5);

    assertEquals(21, pitch1.getMidiNoteNumber());
    assertEquals(24, pitch2.getMidiNoteNumber());
    assertEquals(48, pitch3.getMidiNoteNumber());
    assertEquals(66, pitch4.getMidiNoteNumber());
    assertEquals(77, pitch5.getMidiNoteNumber());
  }

  @Test
  public void isHigherThan() {
    Pitch pitch1 = new Pitch(new PitchClass(A, NATURAL), 0);
    Pitch pitch2 = new Pitch(new PitchClass(C, NATURAL), 1);

    assertTrue(pitch2.isHigherThan(pitch1));
    assertFalse(pitch1.isHigherThan(pitch2));
  }

  @Test
  public void isLowerThan() {
    Pitch pitch1 = new Pitch(new PitchClass(C, NATURAL), 3);
    Pitch pitch2 = new Pitch(new PitchClass(F, SHARP), 4);

    assertTrue(pitch1.isLowerThan(pitch2));
    assertFalse(pitch2.isLowerThan(pitch1));
  }
}

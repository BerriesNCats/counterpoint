package com.davidamateau.counterpoint.core.entity.note;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.davidamateau.counterpoint.core.entity.note.Accidental.*;
import static com.davidamateau.counterpoint.core.entity.note.NoteLetter.*;

class PitchClassTest {

  @Test
  void pitchClassConstructorTest() {
    PitchClass pitchClass = new PitchClass(A, NATURAL);
    Assertions.assertEquals(pitchClass.findPitchNumber(), 9);
    Assertions.assertEquals(pitchClass.getNoteLetter(), A);
    Assertions.assertEquals(pitchClass.getAccidental(), NATURAL);
  }
}
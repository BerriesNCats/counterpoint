package test;

import core.entity.pitch.PitchClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static core.entity.pitch.Accidental.*;
import static core.entity.pitch.NoteLetter.*;

class PitchClassTest {

  @Test
  void pitchClassConstructorTest() {
    PitchClass pitchClass = new PitchClass(A, NATURAL);
    Assertions.assertEquals(pitchClass.findPitchNumber(), 9);
    Assertions.assertEquals(pitchClass.getNoteLetter(), A);
    Assertions.assertEquals(pitchClass.getAccidental(), NATURAL);
  }
}

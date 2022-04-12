package com.davidamateau.counterpoint.core.entity.interval;

import static com.davidamateau.counterpoint.core.entity.note.NoteLetter.*;
import static com.davidamateau.counterpoint.core.entity.note.Accidental.*;

import com.davidamateau.counterpoint.core.entity.note.Pitch;
import com.davidamateau.counterpoint.core.entity.note.PitchClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntervalTest {

  @Test
  void findIntervalQualityTest() {
    Pitch pitchA2 = new Pitch(new PitchClass(A, NATURAL), 2);
    Pitch pitchC3 = new Pitch(new PitchClass(C, NATURAL), 3);

    Interval interval = new Interval(pitchA2, pitchC3);

    Assertions.assertEquals(IntervalType.MINOR_THIRD, interval.getQuality());
  }
}

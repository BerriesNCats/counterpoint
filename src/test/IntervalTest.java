package test;

import static core.entity.pitch.NoteLetter.*;
import static core.entity.pitch.Accidental.*;

import core.entity.interval.Interval;
import core.entity.interval.IntervalQuality;
import core.entity.key.Key;
import core.entity.key.KeyName;
import core.entity.pitch.Pitch;
import core.entity.pitch.PitchClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntervalTest {

  @Test
  void findIntervalQualityTest() {
    Key cMajorKey = new Key(KeyName.C_MAJOR);
    Pitch pitchA2 = new Pitch(new PitchClass(A, NATURAL), 2);
    Pitch pitchC3 = new Pitch(new PitchClass(C, NATURAL), 3);

    Interval interval = new Interval(pitchA2, pitchC3, cMajorKey);

    Assertions.assertEquals(IntervalQuality.MINOR_THIRD, interval.getQuality());
  }
}

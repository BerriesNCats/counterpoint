package core.entity.interval;

import static core.entity.interval.IntervalQuality.*;
import static core.entity.interval.IntervalType.*;

import java.util.HashMap;
import java.util.List;

public class IntervalUtils {

  static HashMap<IntervalQuality, IntervalType> loadIntervalTypes() {
    return new HashMap<>() {
      {
        put(UNISON, PERFECT_CONSONANCE);
        put(MINOR_SECOND, DISSONANCE);
        put(MAJOR_SECOND, DISSONANCE);
        put(MINOR_THIRD, IMPERFECT_CONSONANCE);
        put(MAJOR_THIRD, IMPERFECT_CONSONANCE);
        put(PERFECT_FOURTH, DISSONANCE);
        put(TRITONE, DISSONANCE);
        put(PERFECT_FIFTH, PERFECT_CONSONANCE);
        put(MINOR_SIXTH, IMPERFECT_CONSONANCE);
        put(MAJOR_SIXTH, IMPERFECT_CONSONANCE);
        put(MINOR_SEVENTH, DISSONANCE);
        put(MAJOR_SEVENTH, DISSONANCE);
        put(OCTAVE, PERFECT_CONSONANCE);
      }
    };
  }

  static List<IntervalQuality> loadConsonantIntervals() {
    return List.of(
        UNISON, MINOR_THIRD, MAJOR_THIRD, PERFECT_FIFTH, MAJOR_SIXTH, MAJOR_SIXTH, OCTAVE);
  }

  static List<IntervalQuality> loadDissonantIntervals() {
    return List.of(
        MINOR_SECOND,
        MAJOR_SECOND,
        PERFECT_FOURTH,
        TRITONE,
        MINOR_SEVENTH,
        MAJOR_SEVENTH);
  }
}

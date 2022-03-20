package core.entity.interval;

import java.util.HashMap;

import static core.entity.interval.IntervalStep.*;
import static core.entity.interval.IntervalQuality.*;

public class Interval {

  public static final HashMap<IntervalStep, IntervalQuality> INTERVAL_QUALITIES = loadIntervalQualities();

  private final IntervalQuality quality;
  private final IntervalStep step;

  public Interval(IntervalStep step) {
    this.quality = findQuality(step);
    this.step = step;
  }

  private IntervalQuality findQuality(IntervalStep step) {
    return INTERVAL_QUALITIES.get(step);
  }

  private static HashMap<IntervalStep, IntervalQuality> loadIntervalQualities() {
    return new HashMap<IntervalStep, IntervalQuality>() {
      {
        put(UNISON, PERFECT_CONSONANCE);
        put(MINOR_SECOND, DISSONANCE);
        put(MAJOR_SECOND, DISSONANCE);
        put(MINOR_THIRD, IMPERFECT_CONSONANCE);
        put(MAJOR_THIRD, IMPERFECT_CONSONANCE);
        put(PERFECT_FOURTH, DISSONANCE);
        put(AUGMENTED_FOURTH, DISSONANCE);
        put(DIMINISHED_FIFTH, DISSONANCE);
        put(PERFECT_FIFTH, PERFECT_CONSONANCE);
        put(MINOR_SIXTH, IMPERFECT_CONSONANCE);
        put(MAJOR_SIXTH, IMPERFECT_CONSONANCE);
        put(MINOR_SEVENTH, DISSONANCE);
        put(MAJOR_SEVENTH, DISSONANCE);
        put(OCTAVE, PERFECT_CONSONANCE);
      }
    };
  }


}

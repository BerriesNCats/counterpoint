package core.entity.interval;

import java.util.HashMap;
import java.util.List;

import static core.entity.interval.IntervalUtils.*;

public class Interval {

  public static final HashMap<IntervalStep, IntervalQuality> INTERVAL_QUALITIES_MAP = loadIntervalQualities();
  public static final List<IntervalStep> CONSONANCES = loadConsonantIntervals();
  public static final List<IntervalStep> DISSONANCES = loadDissonantIntervals();

  private final IntervalQuality quality;
  private final IntervalStep step;

  public Interval(IntervalStep step) {
    this.quality = findQuality(step);
    this.step = step;
  }

  public boolean isConsonance() {
    return CONSONANCES.contains(step);
  }

  public boolean isDissonant() {
    return DISSONANCES.contains(step);
  }

  public boolean isTritone() {
    return step.getStepInSemitones() == 6;
  }

  public static IntervalQuality findQuality(IntervalStep step) {
    return INTERVAL_QUALITIES_MAP.get(step);
  }
}

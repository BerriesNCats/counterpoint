package core.entity.interval;

import static core.UtilityListsAndMaps.*;
import core.entity.pitch.Pitch;

public class Interval {

  private final Pitch pitch1;
  private final Pitch pitch2;
  private final IntervalQuality quality;
  private final IntervalType type;

  public Interval(Pitch pitch1, Pitch pitch2) {
    this.pitch1 = pitch1;
    this.pitch2 = pitch2;
    this.quality = findIntervalQuality();
    this.type = findIntervalType();
  }

  public IntervalType findIntervalType() {
    return INTERVAL_TYPES.get(this.quality);
  }

  public IntervalQuality findIntervalQuality() {
    int distanceInSemitones = Math.abs(this.pitch1.getNoteNumber() - this.pitch2.getNoteNumber());
    return INTERVAL_QUALITIES.get(distanceInSemitones);
  }

  public Pitch getPitch1() {
    return this.pitch1;
  }

  public Pitch getPitch2() {
    return this.pitch2;
  }

  public IntervalType getIntervalType() {
    return this.type;
  }

  public IntervalQuality getQuality() {
    return quality;
  }
}

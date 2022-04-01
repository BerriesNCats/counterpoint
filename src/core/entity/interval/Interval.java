package core.entity.interval;

import static core.entity.interval.IntervalUtils.*;
import static core.entity.interval.IntervalQuality.*;

import core.entity.pitch.Pitch;
import java.util.HashMap;

public class Interval {

  public static final HashMap<Integer, IntervalQuality> INTERVAL_QUALITIES =
      loadIntervalQualities();
  public static final HashMap<IntervalQuality, IntervalType> INTERVAL_TYPES = loadIntervalTypes();

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

  public static HashMap<Integer, IntervalQuality> loadIntervalQualities() {
    return new HashMap<>() {
      {
        put(UNISON.getStepInSemitones(), UNISON);
        put(MINOR_SECOND.getStepInSemitones(), MINOR_SECOND);
        put(MAJOR_SECOND.getStepInSemitones(), MAJOR_SECOND);
        put(MINOR_THIRD.getStepInSemitones(), MINOR_THIRD);
        put(MAJOR_THIRD.getStepInSemitones(), MAJOR_THIRD);
        put(PERFECT_FOURTH.getStepInSemitones(), PERFECT_FOURTH);
        put(TRITONE.getStepInSemitones(), TRITONE);
        put(PERFECT_FIFTH.getStepInSemitones(), PERFECT_FIFTH);
        put(MINOR_SIXTH.getStepInSemitones(), MINOR_SIXTH);
        put(MAJOR_SIXTH.getStepInSemitones(), MAJOR_SIXTH);
        put(MINOR_SEVENTH.getStepInSemitones(), MINOR_SEVENTH);
        put(MAJOR_SEVENTH.getStepInSemitones(), MAJOR_SEVENTH);
        put(OCTAVE.getStepInSemitones(), OCTAVE);
      }
    };
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

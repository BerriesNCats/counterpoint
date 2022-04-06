package core.entity.interval;

import static core.entity.interval.IntervalQuality.*;
import static core.entity.interval.IntervalType.*;

import core.entity.pitch.Pitch;
import java.util.HashMap;
import java.util.Map;

public class Interval {

  public static final Map<Integer, IntervalQuality> INTERVAL_QUALITIES = loadIntervalQualities();
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

  private static HashMap<Integer, IntervalQuality> loadIntervalQualities() {
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

  private static HashMap<IntervalQuality, IntervalType> loadIntervalTypes() {
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

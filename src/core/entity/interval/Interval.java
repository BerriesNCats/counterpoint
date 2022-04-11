package core.entity.interval;

import static core.entity.interval.IntervalType.*;
import static core.entity.interval.IntervalQuality.*;

import core.entity.note.Note;
import core.entity.note.Pitch;
import java.util.HashMap;
import java.util.Map;

/**
 * An Interval describes the relationship and quality between two given Pitches.
 */
public class Interval {

  public static final Map<Integer, IntervalType> INTERVAL_QUALITIES = loadIntervalQualities();
  public static final HashMap<IntervalType, IntervalQuality> INTERVAL_TYPES = loadIntervalTypes();

  private final Pitch pitch1;
  private final Pitch pitch2;
  private final IntervalType quality;
  private final IntervalQuality type;

  public Interval(Note note1, Note note2) {
    this(note1.getPitch(), note2.getPitch());
  }
  public Interval(Pitch pitch1, Pitch pitch2) {
    this.pitch1 = pitch1;
    this.pitch2 = pitch2;
    this.quality = findIntervalType();
    this.type = findIntervalQuality();
  }

  /**
   * Finds the interval quality associated with the given pitches.
   * @return the associated interval quality.
   */
  public IntervalQuality findIntervalQuality() {
    return INTERVAL_TYPES.get(this.quality);
  }

  /**
   * Finds the interval type associated with the given pitches.
   * @return the associated interval type.
   */
  public IntervalType findIntervalType() {
    int distanceInSemitones = Math.abs(this.pitch1.getNoteNumber() - this.pitch2.getNoteNumber());
    return INTERVAL_QUALITIES.get(distanceInSemitones);
  }

  /**
   * Maps interval types by their inherit step in semitones.
   * @return a map of semitones to interval types.
   */
  private static HashMap<Integer, IntervalType> loadIntervalQualities() {
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

  /**
   * Maps interval types to their associated interval quality.
   * @return a map of interval types to interval qualities.
   */
  private static HashMap<IntervalType, IntervalQuality> loadIntervalTypes() {
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

  public IntervalQuality getType() {
    return this.type;
  }

  public IntervalType getQuality() {
    return quality;
  }
}

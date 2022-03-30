package core.entity.interval;

import static core.entity.interval.IntervalUtils.*;
import static core.entity.interval.IntervalQuality.*;

import core.entity.key.Key;
import core.entity.pitch.Pitch;
import core.entity.pitch.PitchClass;
import java.util.HashMap;
import java.util.List;

public class Interval {

  public static final HashMap<Integer, IntervalQuality> INTERVAL_QUALITIES =
      loadIntervalQualities();
  public static final HashMap<IntervalQuality, IntervalType> INTERVAL_TYPES = loadIntervalTypes();

  private final Pitch pitch1;
  private final Pitch pitch2;
  private final Key key;
  private final IntervalQuality quality;
  private final IntervalType type;

  public Interval(Pitch pitch1, Pitch pitch2, Key key) {
    this.pitch1 = pitch1;
    this.pitch2 = pitch2;
    this.key = key;
    this.quality = findIntervalQuality();
    this.type = findIntervalType();
  }

  private IntervalType findIntervalType() {
    return INTERVAL_TYPES.get(this.quality);
  }

  private IntervalQuality findIntervalQuality() {
    int distanceInKey = 0;
    int distanceInSemitones = Math.abs(this.pitch1.getNoteNumber() - this.pitch2.getNoteNumber());
    List<PitchClass> orderedPitchesInKey = this.key.getKeyScale().getScale();
    // Key |NoteNumber |Pitch1Index |NoteNumber Pitch2Index | ExpectedOutput
    // C                  A = 5                   C = 0       MINOR THIRD = 3
    // C                  C = 0                   D = 1


    int indexOfPitch1InKey = orderedPitchesInKey.indexOf(pitch1.getPitchClass()); // A2 index 5
    int indexOfPitch2InKey = orderedPitchesInKey.indexOf(pitch2.getPitchClass()); // C3 index 0
    // Should return distance in key of 3

    if (indexOfPitch2InKey < indexOfPitch1InKey) {
      indexOfPitch2InKey += 8;
    }

    distanceInKey = indexOfPitch2InKey - indexOfPitch1InKey;

    if (distanceInSemitones == 6) {
      if (distanceInKey == 3) {
        return AUGMENTED_FOURTH;
      }
    }
    return INTERVAL_QUALITIES.get(distanceInSemitones);
  }

  public static HashMap<Integer, IntervalQuality> loadIntervalQualities() {
    return new HashMap<Integer, IntervalQuality>() {
      {
        put(UNISON.getStepInSemitones(), UNISON);
        put(MINOR_SECOND.getStepInSemitones(), MINOR_SECOND);
        put(MAJOR_SECOND.getStepInSemitones(), MAJOR_SECOND);
        put(MINOR_THIRD.getStepInSemitones(), MINOR_THIRD);
        put(MAJOR_THIRD.getStepInSemitones(), MAJOR_THIRD);
        put(PERFECT_FOURTH.getStepInSemitones(), PERFECT_FOURTH);
        put(DIMINISHED_FIFTH.getStepInSemitones(), DIMINISHED_FIFTH);
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
    return pitch1;
  }

  public Pitch getPitch2() {
    return pitch2;
  }

  public Key getKey() {
    return key;
  }

  public IntervalQuality getQuality() {
    return quality;
  }
}

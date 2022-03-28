package core.entity.interval;

import core.entity.Note;
import core.entity.key.Key;
import core.entity.pitch.Pitch;
import java.util.HashMap;
import java.util.List;

import static core.entity.interval.IntervalUtils.*;

public class Interval {

  public static final HashMap<IntervalStep, IntervalQuality> INTERVAL_QUALITIES_MAP =
      loadIntervalQualities();
  public static final List<IntervalStep> CONSONANCES = loadConsonantIntervals();
  public static final List<IntervalStep> DISSONANCES = loadDissonantIntervals();

  private final Note lowVoice;
  private final Note highVoice;
  private final IntervalStep step;
  private final IntervalQuality quality;
  private final Key key;

  public Interval(Note lowVoice, Note highVoice, Key key) {
    this.lowVoice = lowVoice;
    this.highVoice = highVoice;
    this.key = key;
    this.step = findStep(lowVoice, highVoice);
    this.quality = findQuality(step);
  }

  // TODO
  private IntervalStep findStep(Note lowNote, Note highNote) {
    int differenceInSemiTones = lowNote.compareTo(highNote);
    Pitch lowNotePitch = lowNote.getPitch();
    Pitch highNotePitch = highNote.getPitch();

    return null;
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

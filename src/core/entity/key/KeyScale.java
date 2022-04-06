package core.entity.key;

import core.entity.pitch.PitchClass;
import java.util.List;

public class KeyScale {

  private final List<PitchClass> scale;

  public List<PitchClass> getScale() {
    return scale;
  }

  public KeyScale(List<PitchClass> orderedNotesInScale) {
    this.scale = orderedNotesInScale;
  }
}

package core.entity.key;

import core.entity.pitch.PitchClass;
import java.util.List;

public class KeyScale {

  private final List<PitchClass> pitchesInKey;

  public KeyScale(List<PitchClass> pitchesInKey) {
    this.pitchesInKey = pitchesInKey;
  }
}

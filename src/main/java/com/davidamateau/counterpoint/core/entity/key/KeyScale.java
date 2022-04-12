package com.davidamateau.counterpoint.core.entity.key;

import com.davidamateau.counterpoint.core.entity.note.PitchClass;
import java.util.List;

public class KeyScale {

  private final List<PitchClass> scale;

  public KeyScale(List<PitchClass> orderedNotesInScale) {
    this.scale = orderedNotesInScale;
  }

  public List<PitchClass> getScale() {
    return scale;
  }
}

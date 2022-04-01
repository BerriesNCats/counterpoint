package core.species;

import core.entity.key.Key;
import core.entity.pitch.PitchClass;

public class CantusFirmusVoice extends CounterpointVoice {

  public boolean beginsWithRootNote(Key key) {
    PitchClass firstPitch = this.notes.get(0).getPitch().getPitchClass();
    PitchClass rootPitch = key.getTonic();
    return firstPitch.equals(rootPitch);
  }
}

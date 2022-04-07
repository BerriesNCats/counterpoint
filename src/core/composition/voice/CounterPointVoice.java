package core.composition.voice;

import core.entity.key.Key;

public class CounterPointVoice extends Voice {

  private final CantusFirmusVoice cantusFirmusVoice;

  public CounterPointVoice(CantusFirmusVoice cantusFirmusVoice, Key key) {
    super(key);
    this.cantusFirmusVoice = cantusFirmusVoice;
  }

  public static CounterPointVoice createNewCounterpoint(Key key, int octave) {
    // TODO
    return null;
  }
}

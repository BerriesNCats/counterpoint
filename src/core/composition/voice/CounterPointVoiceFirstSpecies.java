package core.composition.voice;

import core.entity.key.Key;

public class CounterPointVoiceFirstSpecies extends Voice {

  private final CantusFirmusVoice cantusFirmusVoice;

  public CounterPointVoiceFirstSpecies(CantusFirmusVoice cantusFirmusVoice, Key key) {
    super(key);
    this.cantusFirmusVoice = cantusFirmusVoice;
  }

  public static CounterPointVoiceFirstSpecies createNewCounterpoint(Key key, int octave) {
    // TODO
    return null;
  }
}

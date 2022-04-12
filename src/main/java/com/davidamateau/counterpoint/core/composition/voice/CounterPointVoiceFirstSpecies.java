package com.davidamateau.counterpoint.core.composition.voice;

import com.davidamateau.counterpoint.core.entity.key.Key;

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

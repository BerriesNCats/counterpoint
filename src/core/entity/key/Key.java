package core.entity.key;

import static core.entity.pitch.PitchClass.PITCH_CLASSES;

import core.entity.pitch.PitchClass;

public class Key {

  private final KeyName keyName;
  private final PitchClass tonic;
  private final KeyScale keyScale;

  public Key(KeyName keyName) {
    this.keyName = keyName;
    this.tonic = findTonic(keyName);
    this.keyScale = loadScale(keyName);
  }

  public PitchClass getTonic() {
    return this.tonic;
  }

  public static KeyScale loadScale(KeyName keyName) {
    return KeyScale.SCALES.get(keyName);
  }

  public static PitchClass findTonic(KeyName keyName) {
    return PITCH_CLASSES.get(keyName.getTonic());
  }

  public KeyName getKeyName() {
    return keyName;
  }

  public KeyScale getKeyScale() {
    return keyScale;
  }

  @Override
  public String toString() {
    return tonic.toString() + keyName.getQuality().name();
  }
}

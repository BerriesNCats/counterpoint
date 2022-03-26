package core.entity.key;

import static core.entity.key.KeyUtils.*;

import core.entity.pitch.PitchClass;
import java.util.HashMap;

public class Key {

  public static final HashMap<String, PitchClass> PITCH_CLASSES = loadPitchClasses();
  public static final HashMap<KeyName, KeyScale> SCALES = loadScales();

  private final KeyName keyName;
  private final PitchClass tonic;
  private final KeyScale scale;

  public Key(KeyName keyName) {
    this.keyName = keyName;
    this.tonic = findTonic(keyName);
    this.scale = loadScale(keyName);
  }

  public PitchClass getTonic() {
    return this.tonic;
  }

  @Override
  public String toString() {
    return tonic.toString() + keyName.getQuality().name();
  }
}

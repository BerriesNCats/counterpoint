package core.entity.key;

import static core.entity.pitch.PitchClass.PITCH_CLASSES;

import core.entity.Note;
import core.entity.pitch.PitchClass;
import java.util.HashMap;
import java.util.List;

public class Key {

  public static final HashMap<KeyName, KeyScale> SCALES = KeyScale.loadScales();

  private final KeyName keyName;
  private final PitchClass tonic;
  private final KeyScale keyScale;

  public Key(KeyName keyName) {
    this.keyName = keyName;
    this.tonic = findTonic(keyName);
    this.keyScale = findScale(keyName);
  }

  public PitchClass getTonic() {
    return this.tonic;
  }

  public static KeyScale findScale(KeyName keyName) {
    return SCALES.get(keyName);
  }

  public static PitchClass findTonic(KeyName keyName) {
    return PITCH_CLASSES.get(keyName.getTonic());
  }

  public List<PitchClass> getScale() {
    return this.keyScale.getScale();
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

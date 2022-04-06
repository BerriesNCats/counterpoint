package core.entity.key;

import static core.entity.Utilities.*;

import core.entity.pitch.PitchClass;
import java.util.List;

public class Key {

  private final KeyName keyName;
  private final KeyScale keyScale;

  public Key(KeyName keyName) {
    this.keyName = keyName;
    this.keyScale = findScale(keyName);
  }

  public PitchClass getTonic() {
    return this.getScale().get(0);
  }

  public PitchClass getSuperTonic() {
    return this.getScale().get(1);
  }

  public PitchClass getMediant() {
    return this.getScale().get(2);
  }

  public PitchClass getSubDominant() {
    return this.getScale().get(3);
  }

  public PitchClass getDominant() {
    return this.getScale().get(4);
  }

  public PitchClass getSubMediant() {
    return this.getScale().get(5);
  }

  public PitchClass getLeadingTone() {
    return this.getScale().get(6);
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
    return this.getTonic().toString() + this.keyName.getQuality().name();
  }
}

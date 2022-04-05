package core.entity.key;

import static core.entity.key.ScaleDegree.DOMINANT;
import static core.entity.key.ScaleDegree.LEADING_TONE;
import static core.entity.key.ScaleDegree.MEDIANT;
import static core.entity.key.ScaleDegree.SUB_DOMINANT;
import static core.entity.key.ScaleDegree.SUB_MEDIANT;
import static core.entity.key.ScaleDegree.SUPER_TONIC;
import static core.entity.key.ScaleDegree.TONIC;
import static core.entity.pitch.PitchClass.PITCH_CLASSES;

import core.entity.Note;
import core.entity.pitch.PitchClass;
import java.util.HashMap;
import java.util.List;

public class Key {

  public static final HashMap<KeyName, KeyScale> SCALES = KeyScale.loadScales();


  private final KeyName keyName;
  private final KeyScale keyScale;

  public Key(KeyName keyName) {
    this.keyName = keyName;
    this.keyScale = findScale(keyName);
  }

  public HashMap<ScaleDegree, PitchClass> loadDegrees(Key key) {
    return new HashMap<ScaleDegree, PitchClass>() {
      {
        put(TONIC, key.getTonic());
        put(SUPER_TONIC, key.getSuperTonic());
        put(MEDIANT, key.getMediant());
        put(SUB_DOMINANT, key.getSubDominant());
        put(DOMINANT, key.getDominant());
        put(SUB_MEDIANT, key.getSubMediant());
        put(LEADING_TONE, key.getLeadingTone());
      }
    };
  }

  public PitchClass getTonic() {
    return this.getScale().get(0);
  }
  public PitchClass getSuperTonic() { return this.getScale().get(1); }
  public PitchClass getMediant() { return this.getScale().get(2); }
  public PitchClass getSubDominant() { return this.getScale().get(3); }
  public PitchClass getDominant() { return this.getScale().get(4); }
  public PitchClass getSubMediant() { return this.getScale().get(5); }
  public PitchClass getLeadingTone() { return this.getScale().get(6); }

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

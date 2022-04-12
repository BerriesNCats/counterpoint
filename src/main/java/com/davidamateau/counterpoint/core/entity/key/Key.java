package com.davidamateau.counterpoint.core.entity.key;

import static com.davidamateau.counterpoint.core.entity.Utilities.*;
import static com.davidamateau.counterpoint.core.entity.note.Accidental.*;
import static com.davidamateau.counterpoint.core.entity.note.NoteLetter.*;

import com.davidamateau.counterpoint.core.entity.note.PitchClass;
import java.util.HashMap;
import java.util.List;

public class Key {

  public static final int KEYSCALE_SIZE = 7;
  public static final HashMap<KeyName, KeyScale> SCALES = loadScales();

  private final KeyName keyName;
  private final KeyScale keyScale;

  public Key(KeyName keyName) {
    this.keyName = keyName;
    this.keyScale = findScale(keyName);
  }

  public int findPitchClassIndex(PitchClass previousNotePitchClass) {
    int index;

    for (index = 0; index <= KEYSCALE_SIZE; index++) {
      if (keyScale.getScale().get(index).equals(previousNotePitchClass)) {
        return index;
      }
    }
    return index;
  }

//  public PitchClass getPitchClassByDistanceInKey(PitchClass pitchClass, int stepsInKey) {
//    PitchClass pitchClassByDistance;
//    //TODO
//    return null;
//  }

  private static HashMap<KeyName, KeyScale> loadScales() {
    return new HashMap<>() {
      {
        put(
            KeyName.A_FLAT_MAJOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(B.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(C.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(D.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(E.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(F.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(G.name() + NATURAL.getAccidental()))));
        put(
            KeyName.A_FLAT_MINOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(B.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(C.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(D.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(E.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(F.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(G.name() + FLAT.getAccidental()))));
        put(
            KeyName.A_MAJOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(B.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(C.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(D.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(E.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(F.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(G.name() + SHARP.getAccidental()))));
        put(
            KeyName.A_MINOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(B.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(C.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(D.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(E.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(F.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(G.name() + NATURAL.getAccidental()))));
        put(
            KeyName.A_SHARP_MINOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(B.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(C.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(D.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(E.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(F.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(G.name() + SHARP.getAccidental()))));
        put(
            KeyName.B_FLAT_MAJOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(B.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(C.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(D.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(E.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(F.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(G.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(A.name() + NATURAL.getAccidental()))));
        put(
            KeyName.B_FLAT_MINOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(B.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(C.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(D.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(E.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(F.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(G.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(A.name() + FLAT.getAccidental()))));
        put(
            KeyName.B_MAJOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(B.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(C.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(D.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(E.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(F.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(G.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(A.name() + SHARP.getAccidental()))));
        put(
            KeyName.B_MINOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(B.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(C.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(D.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(E.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(F.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(G.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(A.name() + NATURAL.getAccidental()))));
        put(
            KeyName.C_FLAT_MAJOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(C.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(D.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(E.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(F.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(G.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(A.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(B.name() + FLAT.getAccidental()))));
        put(
            KeyName.C_MAJOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(C.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(D.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(E.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(F.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(G.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(A.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(B.name() + NATURAL.getAccidental()))));
        put(
            KeyName.C_MINOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(C.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(D.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(E.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(F.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(G.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(A.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(B.name() + FLAT.getAccidental()))));
        put(
            KeyName.C_SHARP_MAJOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(C.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(D.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(E.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(F.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(G.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(A.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(B.name() + SHARP.getAccidental()))));
        put(
            KeyName.C_SHARP_MINOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(C.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(D.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(E.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(F.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(G.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(A.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(B.name() + NATURAL.getAccidental()))));
        put(
            KeyName.D_FLAT_MAJOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(D.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(E.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(F.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(G.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(A.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(B.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(C.name() + NATURAL.getAccidental()))));
        put(
            KeyName.D_MAJOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(D.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(E.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(F.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(G.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(A.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(B.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(C.name() + SHARP.getAccidental()))));
        put(
            KeyName.D_MINOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(D.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(E.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(F.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(G.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(A.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(B.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(C.name() + NATURAL.getAccidental()))));
        put(
            KeyName.D_SHARP_MINOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(D.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(E.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(F.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(G.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(A.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(B.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(C.name() + SHARP.getAccidental()))));
        put(
            KeyName.E_FLAT_MAJOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(E.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(F.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(G.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(A.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(B.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(C.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(D.name() + NATURAL.getAccidental()))));
        put(
            KeyName.E_FLAT_MINOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(E.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(F.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(G.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(A.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(B.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(C.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(D.name() + FLAT.getAccidental()))));

        put(
            KeyName.E_MAJOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(E.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(F.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(G.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(A.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(B.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(C.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(D.name() + SHARP.getAccidental()))));

        put(
            KeyName.E_MINOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(E.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(F.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(G.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(A.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(B.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(C.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(D.name() + NATURAL.getAccidental()))));
        put(
            KeyName.F_MAJOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(F.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(G.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(A.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(B.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(C.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(D.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(E.name() + NATURAL.getAccidental()))));
        put(
            KeyName.F_MINOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(F.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(G.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(A.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(B.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(C.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(D.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(E.name() + FLAT.getAccidental()))));
        put(
            KeyName.F_SHARP_MAJOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(F.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(G.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(A.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(B.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(C.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(D.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(E.name() + SHARP.getAccidental()))));
        put(
            KeyName.F_SHARP_MINOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(F.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(G.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(A.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(B.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(C.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(D.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(E.name() + NATURAL.getAccidental()))));
        put(
            KeyName.G_FLAT_MAJOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(G.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(A.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(B.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(C.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(D.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(E.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(F.name() + NATURAL.getAccidental()))));
        put(
            KeyName.G_MAJOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(G.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(A.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(B.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(C.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(D.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(E.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(F.name() + SHARP.getAccidental()))));
        put(
            KeyName.G_MINOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(G.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(A.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(B.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(C.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(D.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(E.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(F.name() + NATURAL.getAccidental()))));
        put(
            KeyName.G_SHARP_MINOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(G.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(A.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(B.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(C.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(D.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(E.name() + NATURAL.getAccidental()),
                    PITCH_CLASSES.get(F.name() + SHARP.getAccidental()))));
      }
    };
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
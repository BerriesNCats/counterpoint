package core.entity.key;

import static core.entity.key.Key.PITCH_CLASSES;
import static core.entity.key.Key.SCALES;
import static core.entity.pitch.Accidental.*;
import static core.entity.pitch.NoteLetter.*;

import core.entity.pitch.PitchClass;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyUtils {


  public static HashMap<String, PitchClass> loadPitchClasses() {
    return new HashMap<String, PitchClass>() {
      {
        put(A.name() + FLAT.getAccidental(), new PitchClass(A, FLAT));
        put(A.name(), new PitchClass(A, NATURAL));
        put(A.name() + SHARP.getAccidental(), new PitchClass(A, SHARP));
        put(B.name() + FLAT.getAccidental(), new PitchClass(B, FLAT));
        put(B.name(), new PitchClass(B, NATURAL));
        put(B.name() + SHARP.getAccidental(), new PitchClass(B, SHARP));
        put(C.name() + FLAT.getAccidental(), new PitchClass(C, FLAT));
        put(C.name(), new PitchClass(C, NATURAL));
        put(C.name() + SHARP.getAccidental(), new PitchClass(C, SHARP));
        put(D.name() + FLAT.getAccidental(), new PitchClass(D, FLAT));
        put(D.name(), new PitchClass(D, NATURAL));
        put(D.name() + SHARP.getAccidental(), new PitchClass(D, SHARP));
        put(E.name() + FLAT.getAccidental(), new PitchClass(E, FLAT));
        put(E.name(), new PitchClass(E, NATURAL));
        put(E.name() + SHARP.getAccidental(), new PitchClass(E, SHARP));
        put(F.name() + FLAT.getAccidental(), new PitchClass(F, FLAT));
        put(F.name(), new PitchClass(F, NATURAL));
        put(F.name() + SHARP.getAccidental(), new PitchClass(F, SHARP));
        put(G.name() + FLAT.getAccidental(), new PitchClass(G, FLAT));
        put(G.name(), new PitchClass(G, NATURAL));
        put(G.name() + SHARP.getAccidental(), new PitchClass(G, SHARP));
      }
    };
  }

  public static PitchClass findTonic(KeyName keyName) {
    return PITCH_CLASSES.get(keyName.getTonic());
  }

  public static KeyScale loadScale(KeyName keyName) {
    return SCALES.get(keyName);
  }

  public static HashMap<KeyName, KeyScale> loadScales() {
    return new HashMap<KeyName, KeyScale>() {
      {
        put(
            KeyName.A_FLAT_MAJOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(B.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(C.name()),
                    PITCH_CLASSES.get(D.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(E.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(F.name()),
                    PITCH_CLASSES.get(G.name()))));
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
                    PITCH_CLASSES.get(A.name()),
                    PITCH_CLASSES.get(B.name()),
                    PITCH_CLASSES.get(C.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(D.name()),
                    PITCH_CLASSES.get(E.name()),
                    PITCH_CLASSES.get(F.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(G.name() + SHARP.getAccidental()))));
        put(
            KeyName.A_MINOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name()),
                    PITCH_CLASSES.get(B.name()),
                    PITCH_CLASSES.get(C.name()),
                    PITCH_CLASSES.get(D.name()),
                    PITCH_CLASSES.get(E.name()),
                    PITCH_CLASSES.get(F.name()),
                    PITCH_CLASSES.get(G.name()))));
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
                    PITCH_CLASSES.get(A.name()),
                    PITCH_CLASSES.get(B.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(C.name()),
                    PITCH_CLASSES.get(D.name()),
                    PITCH_CLASSES.get(E.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(F.name()),
                    PITCH_CLASSES.get(G.name()))));
        put(
            KeyName.B_FLAT_MINOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(B.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(C.name()),
                    PITCH_CLASSES.get(D.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(E.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(F.name()),
                    PITCH_CLASSES.get(G.name() + FLAT.getAccidental()))));
        put(
            KeyName.B_MAJOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(B.name()),
                    PITCH_CLASSES.get(C.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(D.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(E.name()),
                    PITCH_CLASSES.get(F.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(G.name() + SHARP.getAccidental()))));
        put(
            KeyName.B_MINOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name()),
                    PITCH_CLASSES.get(B.name()),
                    PITCH_CLASSES.get(C.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(D.name()),
                    PITCH_CLASSES.get(E.name()),
                    PITCH_CLASSES.get(F.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(G.name()))));
        put(
            KeyName.C_FLAT_MAJOR,
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
            KeyName.C_MAJOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name()),
                    PITCH_CLASSES.get(B.name()),
                    PITCH_CLASSES.get(C.name()),
                    PITCH_CLASSES.get(D.name()),
                    PITCH_CLASSES.get(E.name()),
                    PITCH_CLASSES.get(F.name()),
                    PITCH_CLASSES.get(G.name()))));
        put(
            KeyName.C_MINOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(B.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(C.name()),
                    PITCH_CLASSES.get(D.name()),
                    PITCH_CLASSES.get(E.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(F.name()),
                    PITCH_CLASSES.get(G.name()))));
        put(
            KeyName.C_SHARP_MAJOR,
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
            KeyName.C_SHARP_MINOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name()),
                    PITCH_CLASSES.get(B.name()),
                    PITCH_CLASSES.get(C.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(D.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(E.name()),
                    PITCH_CLASSES.get(F.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(G.name() + SHARP.getAccidental()))));
        put(
            KeyName.D_FLAT_MAJOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(B.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(C.name()),
                    PITCH_CLASSES.get(D.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(E.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(F.name()),
                    PITCH_CLASSES.get(G.name() + FLAT.getAccidental()))));
        put(
            KeyName.D_MAJOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name()),
                    PITCH_CLASSES.get(B.name()),
                    PITCH_CLASSES.get(C.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(D.name()),
                    PITCH_CLASSES.get(E.name()),
                    PITCH_CLASSES.get(F.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(G.name()))));
        put(
            KeyName.D_MINOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name()),
                    PITCH_CLASSES.get(B.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(C.name()),
                    PITCH_CLASSES.get(D.name()),
                    PITCH_CLASSES.get(E.name()),
                    PITCH_CLASSES.get(F.name()),
                    PITCH_CLASSES.get(G.name()))));
        put(
            KeyName.D_SHARP_MINOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(B.name()),
                    PITCH_CLASSES.get(C.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(D.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(E.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(F.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(G.name() + SHARP.getAccidental()))));
        put(
            KeyName.E_FLAT_MAJOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(B.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(C.name()),
                    PITCH_CLASSES.get(D.name()),
                    PITCH_CLASSES.get(E.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(F.name()),
                    PITCH_CLASSES.get(G.name()))));
        put(
            KeyName.E_FLAT_MINOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(B.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(C.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(D.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(E.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(F.name()),
                    PITCH_CLASSES.get(G.name() + FLAT.getAccidental()))));
        put(
            KeyName.E_MAJOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name()),
                    PITCH_CLASSES.get(B.name()),
                    PITCH_CLASSES.get(C.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(D.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(E.name()),
                    PITCH_CLASSES.get(F.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(G.name() + SHARP.getAccidental()))));
        put(
            KeyName.E_MINOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name()),
                    PITCH_CLASSES.get(B.name()),
                    PITCH_CLASSES.get(C.name()),
                    PITCH_CLASSES.get(D.name()),
                    PITCH_CLASSES.get(E.name()),
                    PITCH_CLASSES.get(F.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(G.name()))));
        put(
            KeyName.F_MAJOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name()),
                    PITCH_CLASSES.get(B.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(C.name()),
                    PITCH_CLASSES.get(D.name()),
                    PITCH_CLASSES.get(E.name()),
                    PITCH_CLASSES.get(F.name()),
                    PITCH_CLASSES.get(G.name()))));
        put(
            KeyName.F_MINOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(B.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(C.name()),
                    PITCH_CLASSES.get(D.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(E.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(F.name()),
                    PITCH_CLASSES.get(G.name()))));
        put(
            KeyName.F_SHARP_MAJOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(B.name()),
                    PITCH_CLASSES.get(C.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(D.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(E.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(F.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(G.name() + SHARP.getAccidental()))));
        put(
            KeyName.F_SHARP_MINOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name()),
                    PITCH_CLASSES.get(B.name()),
                    PITCH_CLASSES.get(C.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(D.name()),
                    PITCH_CLASSES.get(E.name()),
                    PITCH_CLASSES.get(F.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(G.name() + SHARP.getAccidental()))));
        put(
            KeyName.G_FLAT_MAJOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(B.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(C.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(D.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(E.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(F.name()),
                    PITCH_CLASSES.get(G.name() + FLAT.getAccidental()))));
        put(
            KeyName.G_MAJOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name()),
                    PITCH_CLASSES.get(B.name()),
                    PITCH_CLASSES.get(C.name()),
                    PITCH_CLASSES.get(D.name()),
                    PITCH_CLASSES.get(E.name()),
                    PITCH_CLASSES.get(F.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(G.name()))));
        put(
            KeyName.G_MINOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name()),
                    PITCH_CLASSES.get(B.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(C.name()),
                    PITCH_CLASSES.get(D.name()),
                    PITCH_CLASSES.get(E.name() + FLAT.getAccidental()),
                    PITCH_CLASSES.get(F.name()),
                    PITCH_CLASSES.get(G.name()))));
        put(
            KeyName.G_SHARP_MINOR,
            new KeyScale(
                List.of(
                    PITCH_CLASSES.get(A.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(B.name()),
                    PITCH_CLASSES.get(C.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(D.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(E.name()),
                    PITCH_CLASSES.get(F.name() + SHARP.getAccidental()),
                    PITCH_CLASSES.get(G.name() + SHARP.getAccidental()))));
      }
    };
  }
}

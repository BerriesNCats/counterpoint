package core.entity.key;

import static core.entity.pitch.Accidental.*;
import static core.entity.pitch.NoteLetter.*;
import static core.entity.pitch.PitchClass.PITCH_CLASSES;

import core.entity.pitch.PitchClass;
import java.util.HashMap;
import java.util.List;

public class KeyScale {

  private final List<PitchClass> scale;

  public List<PitchClass> getScale() {
    return scale;
  }

  public KeyScale(List<PitchClass> orderedNotesInScale) {
    this.scale = orderedNotesInScale;
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
}

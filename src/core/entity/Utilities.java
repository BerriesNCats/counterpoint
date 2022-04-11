package core.entity;

import static core.entity.interval.IntervalType.*;
import static core.entity.note.Accidental.*;
import static core.entity.note.NoteLetter.*;

import core.entity.interval.IntervalType;
import core.entity.key.KeyName;
import core.entity.key.KeyScale;
import core.entity.note.PitchClass;
import java.util.HashMap;
import java.util.List;

public class Utilities {

  public static final int DEFAULT_OCTAVE = 4;

  public static final List<IntervalType> VALID_CANTUS_INTERVALS = loadValidCantusIntervals();
  public static final List<IntervalType> CONSONANT_INTERVALS = loadConsonantIntervals();
  public static final List<IntervalType> DISSONANT_INTERVALS = loadDissonantIntervals();

  public static final HashMap<KeyName, KeyScale> SCALES = loadScales();

  public static final HashMap<String, PitchClass> PITCH_CLASSES = loadPitchClasses();

  private static List<IntervalType> loadConsonantIntervals() {
    return List.of(
        UNISON, MINOR_THIRD, MAJOR_THIRD, PERFECT_FIFTH, MAJOR_SIXTH, MAJOR_SIXTH, OCTAVE);
  }

  private static List<IntervalType> loadDissonantIntervals() {
    return List.of(
        MINOR_SECOND, MAJOR_SECOND, PERFECT_FOURTH, TRITONE, MINOR_SEVENTH, MAJOR_SEVENTH);
  }

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

  private static HashMap<String, PitchClass> loadPitchClasses() {
    return new HashMap<>() {
      {
        put(A.name(), new PitchClass(A, NATURAL));
        put(B.name(), new PitchClass(B, NATURAL));
        put(C.name(), new PitchClass(C, NATURAL));
        put(D.name(), new PitchClass(D, NATURAL));
        put(E.name(), new PitchClass(E, NATURAL));
        put(F.name(), new PitchClass(F, NATURAL));
        put(G.name(), new PitchClass(G, NATURAL));

        put(A.name() + FLAT.getAccidental(), new PitchClass(A, FLAT));
        put(B.name() + FLAT.getAccidental(), new PitchClass(B, FLAT));
        put(C.name() + FLAT.getAccidental(), new PitchClass(C, FLAT));
        put(D.name() + FLAT.getAccidental(), new PitchClass(D, FLAT));
        put(E.name() + FLAT.getAccidental(), new PitchClass(E, FLAT));
        put(F.name() + FLAT.getAccidental(), new PitchClass(F, FLAT));
        put(G.name() + FLAT.getAccidental(), new PitchClass(G, FLAT));

        put(A.name() + SHARP.getAccidental(), new PitchClass(A, SHARP));
        put(B.name() + SHARP.getAccidental(), new PitchClass(B, SHARP));
        put(C.name() + SHARP.getAccidental(), new PitchClass(C, SHARP));
        put(D.name() + SHARP.getAccidental(), new PitchClass(D, SHARP));
        put(E.name() + SHARP.getAccidental(), new PitchClass(E, SHARP));
        put(F.name() + SHARP.getAccidental(), new PitchClass(F, SHARP));
        put(G.name() + SHARP.getAccidental(), new PitchClass(G, SHARP));
      }
    };
  }

  private static List<IntervalType> loadValidCantusIntervals() {
    return List.of(
        MINOR_SECOND,
        MAJOR_SECOND,
        MINOR_THIRD,
        MAJOR_THIRD,
        PERFECT_FOURTH,
        PERFECT_FIFTH,
        MINOR_SIXTH,
        MAJOR_SIXTH,
        OCTAVE);
  }
}

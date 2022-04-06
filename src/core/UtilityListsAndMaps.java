package core;

import static core.entity.interval.IntervalQuality.*;
import static core.entity.interval.IntervalType.*;
import static core.entity.key.ScaleDegree.DOMINANT;
import static core.entity.key.ScaleDegree.LEADING_TONE;
import static core.entity.key.ScaleDegree.MEDIANT;
import static core.entity.key.ScaleDegree.SUB_DOMINANT;
import static core.entity.key.ScaleDegree.SUB_MEDIANT;
import static core.entity.key.ScaleDegree.SUPER_TONIC;
import static core.entity.key.ScaleDegree.TONIC;
import static core.entity.pitch.Accidental.FLAT;
import static core.entity.pitch.Accidental.NATURAL;
import static core.entity.pitch.Accidental.SHARP;
import static core.entity.pitch.NoteLetter.A;
import static core.entity.pitch.NoteLetter.B;
import static core.entity.pitch.NoteLetter.C;
import static core.entity.pitch.NoteLetter.D;
import static core.entity.pitch.NoteLetter.E;
import static core.entity.pitch.NoteLetter.F;
import static core.entity.pitch.NoteLetter.G;

import core.entity.interval.IntervalQuality;
import core.entity.interval.IntervalType;
import core.entity.key.Key;
import core.entity.key.KeyName;
import core.entity.key.KeyScale;
import core.entity.key.ScaleDegree;
import core.entity.pitch.PitchClass;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilityListsAndMaps {

  public static final Map<Integer, IntervalQuality> INTERVAL_QUALITIES = loadIntervalQualities();
  public static final Map<IntervalQuality, IntervalType> INTERVAL_TYPES = loadIntervalTypes();
  public static final HashMap<KeyName, KeyScale> SCALES = loadScales();
  public static final Map<String, Integer> PITCH_NUMBERS = loadPitchNumbers();
  public static final HashMap<String, PitchClass> PITCH_CLASSES = loadPitchClasses();
  public static final List<IntervalQuality> VALID_CANTUS_INTERVALS = loadValidCantusIntervals();

  private static HashMap<Integer, IntervalQuality> loadIntervalQualities() {
    return new HashMap<>() {
      {
        put(UNISON.getStepInSemitones(), UNISON);
        put(MINOR_SECOND.getStepInSemitones(), MINOR_SECOND);
        put(MAJOR_SECOND.getStepInSemitones(), MAJOR_SECOND);
        put(MINOR_THIRD.getStepInSemitones(), MINOR_THIRD);
        put(MAJOR_THIRD.getStepInSemitones(), MAJOR_THIRD);
        put(PERFECT_FOURTH.getStepInSemitones(), PERFECT_FOURTH);
        put(TRITONE.getStepInSemitones(), TRITONE);
        put(PERFECT_FIFTH.getStepInSemitones(), PERFECT_FIFTH);
        put(MINOR_SIXTH.getStepInSemitones(), MINOR_SIXTH);
        put(MAJOR_SIXTH.getStepInSemitones(), MAJOR_SIXTH);
        put(MINOR_SEVENTH.getStepInSemitones(), MINOR_SEVENTH);
        put(MAJOR_SEVENTH.getStepInSemitones(), MAJOR_SEVENTH);
        put(OCTAVE.getStepInSemitones(), OCTAVE);
      }
    };
  }

  private static HashMap<IntervalQuality, IntervalType> loadIntervalTypes() {
    return new HashMap<>() {
      {
        put(UNISON, PERFECT_CONSONANCE);
        put(MINOR_SECOND, DISSONANCE);
        put(MAJOR_SECOND, DISSONANCE);
        put(MINOR_THIRD, IMPERFECT_CONSONANCE);
        put(MAJOR_THIRD, IMPERFECT_CONSONANCE);
        put(PERFECT_FOURTH, DISSONANCE);
        put(TRITONE, DISSONANCE);
        put(PERFECT_FIFTH, PERFECT_CONSONANCE);
        put(MINOR_SIXTH, IMPERFECT_CONSONANCE);
        put(MAJOR_SIXTH, IMPERFECT_CONSONANCE);
        put(MINOR_SEVENTH, DISSONANCE);
        put(MAJOR_SEVENTH, DISSONANCE);
        put(OCTAVE, PERFECT_CONSONANCE);
      }
    };
  }

  private static List<IntervalQuality> loadConsonantIntervals() {
    return List.of(
        UNISON, MINOR_THIRD, MAJOR_THIRD, PERFECT_FIFTH, MAJOR_SIXTH, MAJOR_SIXTH, OCTAVE);
  }

  private static List<IntervalQuality> loadDissonantIntervals() {
    return List.of(
        MINOR_SECOND, MAJOR_SECOND, PERFECT_FOURTH, TRITONE, MINOR_SEVENTH, MAJOR_SEVENTH);
  }

  private static HashMap<KeyName, KeyScale> loadScales() {
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

  private static Map<String, Integer> loadPitchNumbers() {
    return new HashMap<>() {
      {
        put(C.name() + FLAT.getAccidental(), -1);
        put(C.name() + NATURAL.getAccidental(), 0);
        put(C.name() + SHARP.getAccidental(), 1);
        put(D.name() + FLAT.getAccidental(), 1);
        put(D.name() + NATURAL.getAccidental(), 2);
        put(D.name() + SHARP.getAccidental(), 3);
        put(E.name() + FLAT.getAccidental(), 3);
        put(E.name() + NATURAL.getAccidental(), 4);
        put(F.name() + FLAT.getAccidental(), 4);
        put(E.name() + SHARP.getAccidental(), 5);
        put(F.name() + NATURAL.getAccidental(), 5);
        put(F.name() + SHARP.getAccidental(), 6);
        put(G.name() + FLAT.getAccidental(), 6);
        put(G.name() + NATURAL.getAccidental(), 7);
        put(G.name() + SHARP.getAccidental(), 8);
        put(A.name() + FLAT.getAccidental(), 8);
        put(A.name() + NATURAL.getAccidental(), 9);
        put(A.name() + SHARP.getAccidental(), 10);
        put(B.name() + FLAT.getAccidental(), 10);
        put(B.name() + NATURAL.getAccidental(), 11);
        put(B.name() + SHARP.getAccidental(), 12);
      }
    };
  }

  private static List<IntervalQuality> loadValidCantusIntervals() {
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

package core.entity.motion;

import core.entity.note.Note;
import core.entity.interval.Interval;
import java.util.List;

public class Motion {

  private final List<Note> voice1;
  private final List<Note> voice2;
  private final MotionType motionType;

  public Motion(List<Note> voice1, List<Note> voice2) {
    this.voice1 = voice1;
    this.voice2 = voice2;
    this.motionType = findMotionType();
  }

  private MotionType findMotionType() {
    MotionDirection voice1Direction = findMotionDirection(voice1.get(0), voice1.get(1));
    MotionDirection voice2Direction = findMotionDirection(voice2.get(0), voice2.get(1));
    Interval voice1Interval = new Interval(voice1.get(0).getPitch(), voice1.get(1).getPitch());
    Interval voice2Interval = new Interval(voice2.get(0).getPitch(), voice2.get(1).getPitch());

    if ((voice1Direction == MotionDirection.UP && voice2Direction == MotionDirection.UP)
        || (voice1Direction == MotionDirection.DOWN && voice2Direction == MotionDirection.DOWN)) {
      if (voice1Interval.findIntervalQuality().getStepInKey() == voice2Interval.findIntervalQuality().getStepInKey()) {
        return MotionType.PARALLEL;
      } else {
        return MotionType.SIMILAR;
      }
    }

    if ((voice1Direction == MotionDirection.UP && voice2Direction == MotionDirection.DOWN)
        || (voice1Direction == MotionDirection.DOWN && voice2Direction == MotionDirection.UP)) {
      return MotionType.CONTRARY;
    }

    if ((voice1Direction == MotionDirection.NONE && voice2Direction != MotionDirection.NONE)
        || (voice1Direction != MotionDirection.NONE && voice2Direction == MotionDirection.NONE)) {
      return MotionType.OBLIQUE;
    }

    return null;
  }

  public MotionDistance findMotionDistance(Note note1, Note note2) {
    int distance = Math.abs(note1.getNoteNumber() - note2.getNoteNumber());

    return switch (distance) {
      case 0 -> MotionDistance.NONE;
      case 1, 2 -> MotionDistance.STEP;
      default -> MotionDistance.LEAP;
    };
  }

  public MotionDirection findMotionDirection(Note note1, Note note2) {
    if (note1.isLowerThan(note2)) {
      return MotionDirection.UP;
    } else if (note1.isHigherThan(note2)) {
      return MotionDirection.DOWN;
    }
    return MotionDirection.NONE;
  }

}

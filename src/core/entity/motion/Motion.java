package core.entity.motion;

import core.composition.Note;
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

  private MotionType findMotionType() {
    // TODO
    return null;
  }
}

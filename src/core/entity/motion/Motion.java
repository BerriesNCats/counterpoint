package core.entity.motion;

import core.entity.note.Note;
import java.util.List;

public class Motion {

  protected final List<Note> voice;

  public Motion(List<Note> voice) {
    this.voice = voice;
  }

  public MotionDistance findMotionDistance(Note note1, Note note2) {
    int distance = Math.abs(note1.getNoteNumber() - note2.getNoteNumber());

    return switch (distance) {
      case 0 -> MotionDistance.NONE;
      case 1, 2 -> MotionDistance.STEP;
      default -> MotionDistance.LEAP;
    };
  }

  public MotionDistance findMotionDistance() {
    return findMotionDistance(voice.get(0), voice.get(1));
  }

  public MotionDirection findMotionDirection(Note note1, Note note2) {
    if (note1.isLowerThan(note2)) {
      return MotionDirection.UP;
    } else if (note1.isHigherThan(note2)) {
      return MotionDirection.DOWN;
    }
    return MotionDirection.NONE;
  }

  public MotionDirection findMotionDirection() {
    return findMotionDirection(voice.get(0), voice.get(1));
  }

  public List<Note> getVoice() {
    return voice;
  }

}

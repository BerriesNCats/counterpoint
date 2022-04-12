package com.davidamateau.counterpoint.core.entity.motion;

import com.davidamateau.counterpoint.core.entity.note.Note;
import java.util.List;

public class Motion {

  protected final List<Note> voice;

  public Motion(List<Note> voice) {
    this.voice = voice;
  }

  public MotionDistance findMotionDistance(Note note1, Note note2) {
    int distance = Math.abs(note1.getNoteNumber() - note2.getNoteNumber());

    if (distance == 12) return MotionDistance.LEAP_OCTAVE;

    return switch (distance % 12) {
      case 0 -> MotionDistance.NONE;
      case 1, 2 -> MotionDistance.STEP;
      case 3, 4 -> MotionDistance.LEAP_THIRD;
      case 5, 6 -> MotionDistance.LEAP_FOURTH;
      case 7 -> MotionDistance.LEAP_FIFTH;
      case 8, 9 -> MotionDistance.LEAP_SIXTH;
      case 10, 11 -> MotionDistance.LEAP_SEVENTH;
      default -> MotionDistance.LEAP_OCTAVE;
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
    return MotionDirection.UP;
  }

  public MotionDirection findMotionDirection() {
    return findMotionDirection(voice.get(0), voice.get(1));
  }

  public List<Note> getVoice() {
    return voice;
  }

}

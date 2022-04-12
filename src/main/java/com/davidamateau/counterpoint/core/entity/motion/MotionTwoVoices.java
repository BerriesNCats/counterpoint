package com.davidamateau.counterpoint.core.entity.motion;

import com.davidamateau.counterpoint.core.entity.interval.Interval;
import com.davidamateau.counterpoint.core.entity.note.Note;
import java.util.List;

public class MotionTwoVoices extends Motion {

  private final List<Note> voice2;
  private final MotionType motionType;

  public MotionTwoVoices(List<Note> voice1, List<Note> voice2) {
    super(voice1);
    this.voice2 = voice2;
    this.motionType = findMotionType();
  }

  public MotionType findMotionType() {
    MotionDirection voice1Direction = findMotionDirection(voice.get(0), voice.get(1));
    MotionDirection voice2Direction = findMotionDirection(voice2.get(0), voice2.get(1));
    Interval voice1Interval = new Interval(voice.get(0).getPitch(), voice.get(1).getPitch());
    Interval voice2Interval = new Interval(voice2.get(0).getPitch(), voice2.get(1).getPitch());

    if ((voice1Direction == MotionDirection.UP && voice2Direction == MotionDirection.UP)
        || (voice1Direction == MotionDirection.DOWN && voice2Direction == MotionDirection.DOWN)) {
      if (voice1Interval.findIntervalType().getStepsInKey()
          == voice2Interval.findIntervalType().getStepsInKey()) {
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
}

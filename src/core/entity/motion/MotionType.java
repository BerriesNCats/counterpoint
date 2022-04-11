package core.entity.motion;

import java.util.Random;

public enum MotionType {
  PARALLEL,
  SIMILAR,
  CONTRARY,
  OBLIQUE;

  public static MotionType getRandomMotionType() {
    return switch (new Random().nextInt(4)) {
      case 0 -> PARALLEL;
      case 1 -> SIMILAR;
      case 2 -> CONTRARY;
      default -> OBLIQUE;
    };
  }
}

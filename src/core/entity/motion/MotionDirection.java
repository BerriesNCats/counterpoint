package core.entity.motion;

import java.util.Random;

public enum MotionDirection {
  UP,
  DOWN,
  NONE;

  public static MotionDirection getRandomDirection(boolean excludeNone) {
    Random random = new Random();

    if (excludeNone) {
      return random.nextBoolean()
          ? MotionDirection.UP
          : MotionDirection.DOWN;
    } else {
      return switch (random.nextInt(3)) {
        case 0 -> MotionDirection.UP;
        case 1 -> MotionDirection.DOWN;
        default -> MotionDirection.NONE;
      };
    }
  }
}

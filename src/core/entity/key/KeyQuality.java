package core.entity.key;

import java.util.Random;

public enum KeyQuality {
  MAJOR,
  MINOR;

  public static KeyQuality getRandomKeyQuality() {
    return new Random().nextBoolean() ? MAJOR : MINOR;
  }
}

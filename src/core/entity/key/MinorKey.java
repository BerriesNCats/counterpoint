package core.entity.key;

public class MinorKey extends Key{

  private final KeyScale melodicMinorScale;

  public MinorKey(KeyName keyName) {
    super(keyName);
    this.melodicMinorScale = findMelodicMinorScale();
  }

  private KeyScale findMelodicMinorScale() {
    //TODO
    return null;
  }
}

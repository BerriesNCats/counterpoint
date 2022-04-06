package core.species;

import static core.entity.key.ScaleDegree.*;
import core.entity.Note;

import core.entity.key.Key;
import core.entity.key.ScaleDegree;
import core.entity.pitch.PitchClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Voice {

  public HashMap<ScaleDegree, PitchClass> scaleDegrees;

  protected List<Note> notes;
  protected Key key;

  public Voice(Key key) {
    this.key = key;
    this.scaleDegrees = loadScaleDegrees();
  }

  public Voice() {}

  public Voice(List<Note> notes, Key key) {
    this.notes = notes;
    this.key = key;
  }

  private HashMap<ScaleDegree, PitchClass> loadScaleDegrees() {
    return new HashMap<ScaleDegree, PitchClass>() {
      {
        put(TONIC, key.getTonic());
        put(SUPER_TONIC, key.getSuperTonic());
        put(MEDIANT, key.getMediant());
        put(SUB_DOMINANT, key.getSubDominant());
        put(DOMINANT, key.getDominant());
        put(SUB_MEDIANT, key.getSubMediant());
        put(LEADING_TONE, key.getLeadingTone());
      }
    };
  }

  public List<Note> getNotes() {
    return this.notes;
  }

  protected void setVoiceLength(int cantusLength) {
    this.notes = new ArrayList<>(cantusLength);
  }
}

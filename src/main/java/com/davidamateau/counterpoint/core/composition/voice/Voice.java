package com.davidamateau.counterpoint.core.composition.voice;

import static com.davidamateau.counterpoint.core.entity.key.ScaleDegree.*;

import com.davidamateau.counterpoint.core.entity.motion.MotionDistance;
import com.davidamateau.counterpoint.core.entity.note.Note;

import com.davidamateau.counterpoint.core.entity.key.Key;
import com.davidamateau.counterpoint.core.entity.key.ScaleDegree;
import com.davidamateau.counterpoint.core.entity.note.PitchClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Voice {

  protected List<Note> notes;
  protected final Key key;
  protected final HashMap<ScaleDegree, PitchClass> pitchClassByScaleDegree;

  public Voice(Key key) {
    this(key, new ArrayList<>());
  }

  public Voice(Key key, List<Note> notes) {
    this.key = key;
    this.notes = notes;
    this.pitchClassByScaleDegree = loadScaleDegrees();
  }

  public PitchClass getScaleDegree(ScaleDegree scaleDegree) {
    return pitchClassByScaleDegree.get(scaleDegree);
  }

  private HashMap<ScaleDegree, PitchClass> loadScaleDegrees() {
    return new HashMap<>() {
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

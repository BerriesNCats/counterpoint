package com.davidamateau.counterpoint.core.composition.voice;

import com.davidamateau.counterpoint.core.entity.key.Key;
import com.davidamateau.counterpoint.core.entity.note.Note;

import java.util.List;

public class CounterPointVoiceFirstSpecies extends Voice {

  private final CantusFirmusVoice cantusFirmusVoice;

  public CounterPointVoiceFirstSpecies(CantusFirmusVoice cantusFirmusVoice, Key key) {
    super(key);
    this.cantusFirmusVoice = cantusFirmusVoice;
  }

  public static CounterPointVoiceFirstSpecies createNewCounterpoint(CantusFirmusVoice cantus, int octave) {
    // TODO implement create counterpoint || also refactor some add methods to VOICE
    CounterPointVoiceFirstSpecies counterPoint = new CounterPointVoiceFirstSpecies(cantus, cantus.key);
    counterPoint.setVoiceLength(cantus.notes.size() - 1);

    counterPoint.addNote(counterPoint.generateFirstNote(cantus.key, octave));
    for (int index = 1; index < counterPoint.getNotes().size() - 3; index++) {
      counterPoint.addNote(counterPoint.generateBodyNote(cantus.key, counterPoint.getNotes(), octave, index));
    }
    counterPoint.addPenUltimate(counterPoint.generatePenUltimate(octave), counterPoint.getNotes().size() - 2);
    counterPoint.addUltimate(counterPoint.generateUltimate(cantus.key, octave));


    return counterPoint;
  }

  public void addUltimate(Object generateUltimate) {

  }

  public void addNote(Object generateBodyNote) {
  }

  public Object generateUltimate(Key key, int octave) {
    return null;
  }

  public void addPenUltimate(Object generatePenUltimate, int i) {
  }

  public Object generatePenUltimate(int octave) {
    return null;
  }

  public Object generateBodyNote(Key key, List<Note> notes, int octave, int index) {
    return null;
  }

  public Object generateFirstNote(Key key, int octave) {
    return null;
  }
}

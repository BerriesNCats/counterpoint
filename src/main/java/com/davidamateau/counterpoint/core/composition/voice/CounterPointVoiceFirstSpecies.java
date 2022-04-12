package com.davidamateau.counterpoint.core.composition.voice;

import com.davidamateau.counterpoint.core.entity.key.Key;
import com.davidamateau.counterpoint.core.entity.note.Note;

import java.util.List;

/**
 * A first species contrapuntal voice to a given cantus.
 */
public class CounterPointVoiceFirstSpecies extends Voice {

  private final CantusFirmusVoice cantusFirmusVoice;

  public CounterPointVoiceFirstSpecies(CantusFirmusVoice cantusFirmusVoice, Key key) {
    super(key);
    this.cantusFirmusVoice = cantusFirmusVoice;
  }

  public static CounterPointVoiceFirstSpecies createNewCounterpoint(CantusFirmusVoice cantus, int octave) {
    // TODO implement create counterpoint || also refactor some add methods to VOICE
    int counterPointLength = cantus.notes.size() - 1;
    CounterPointVoiceFirstSpecies counterPoint = new CounterPointVoiceFirstSpecies(cantus, cantus.key);
    counterPoint.setVoiceLength(counterPointLength);

    counterPoint.addNote(counterPoint.generateFirstNote(cantus.key, octave));
    for (int index = 1; index < counterPointLength - 2; index++) {
      counterPoint.addNote(counterPoint.generateBodyNote(cantus.key, counterPoint.getNotes(), octave, index));
    }
    counterPoint.addPenUltimate(counterPoint.generatePenUltimate(octave), counterPointLength - 1);
    counterPoint.addUltimate(counterPoint.generateUltimate(cantus.key, octave), counterPointLength);

    return counterPoint;
  }

  public Note generateUltimate(Key key, int octave) {
    return null;
  }

  public Note generatePenUltimate(int octave) {
    if (this.cantusFirmusVoice.getUltimate().equals(this.key.getLeadingTone())) {
      return new Note(key.getSuperTonic(), octave);
    } else {
      return new Note(key.getLeadingTone(), octave);
    }
  }

  public Note generateBodyNote(Key key, List<Note> notes, int octave, int index) {
    return null;
  }

  public Note generateFirstNote(Key key, int octave) {
    // TODO return switch randomly on OCTAVE, FIFTH, UNISON & THIRD
    // COULD use PERFECT CONSONANCE HERE
    return null;
  }
}

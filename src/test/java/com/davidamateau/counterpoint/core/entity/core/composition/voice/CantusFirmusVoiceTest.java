package com.davidamateau.counterpoint.core.entity.core.composition.voice;

import static com.davidamateau.counterpoint.core.entity.Utilities.DEFAULT_OCTAVE;

import com.davidamateau.counterpoint.core.composition.voice.CantusFirmusVoice;
import com.davidamateau.counterpoint.core.entity.key.Key;
import com.davidamateau.counterpoint.core.entity.key.KeyName;
import org.junit.jupiter.api.Test;

class CantusFirmusVoiceTest {

  @Test
  public void createNewCantus() {
    CantusFirmusVoice cantus = CantusFirmusVoice.createNewCantus(new Key(KeyName.C_MAJOR), DEFAULT_OCTAVE);

  }

  @Test
  void generateSecondNote() {
  }

  @Test
  void generatePenUltimate() {
  }

  @Test
  void generateNote() {
  }

  @Test
  void addPenUltimate() {
  }

  @Test
  void addUltimate() {
  }

  @Test
  void addTonic() {
  }

  @Test
  void addNote() {
  }

  @Test
  void isRootPitch() {
  }

  @Test
  void isValidCantusInterval() {
  }
}
package core.species;

import core.entity.Note;

import java.util.ArrayList;
import java.util.List;

public class Voice {

  protected List<Note> notes;

  public Voice() {}

  public Voice(List<Note> notes) {
    this.notes = notes;
  }

  public List<Note> getNotes() {
    return this.notes;
  }


  protected void setVoiceLength(int cantusLength) {
    this.notes = new ArrayList<>(cantusLength);
  }
}

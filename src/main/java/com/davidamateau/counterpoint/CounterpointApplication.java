package com.davidamateau.counterpoint;

import static com.davidamateau.counterpoint.core.entity.Utilities.DEFAULT_OCTAVE;

import com.davidamateau.counterpoint.core.composition.voice.CantusFirmusVoice;
import com.davidamateau.counterpoint.core.entity.key.Key;
import com.davidamateau.counterpoint.core.entity.key.KeyName;
import com.davidamateau.counterpoint.core.entity.note.Note;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CounterpointApplication {

	public static void main(String[] args) {
		SpringApplication.run(CounterpointApplication.class, args);

		CantusFirmusVoice cantusInC = CantusFirmusVoice.createNewCantus(new Key(KeyName.C_MAJOR), DEFAULT_OCTAVE);
		CantusFirmusVoice cantusInEFlat = CantusFirmusVoice.createNewCantus(new Key(KeyName.E_FLAT_MAJOR), DEFAULT_OCTAVE);

    System.out.println(cantusInC.toString());
    System.out.println(cantusInEFlat.toString());
	}

}

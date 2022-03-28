package core.entity.interval;

import core.entity.Note;
import core.entity.key.Key;


public class Interval {

    private final Note noteVoice1;
    private final Note noteVoice2;
    private final Key key;
    private final IntervalQuality quality;

    public Interval(Note noteVoice1, Note noteVoice2, Key key) {
        this.noteVoice1 = noteVoice1;
        this.noteVoice2 = noteVoice2;
        this.key = key;
        this.quality = findQuality();
    }

    private IntervalQuality findQuality() {
        int distanceInKey = 0;
        int distanceInSemitones = Math.abs(
                this.noteVoice1.getPitch().getNoteNumber() - this.noteVoice2.getPitch().getNoteNumber());

        // TODO
        return null;
    }
}


import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class MusicPlayer {
    

    private Sequence sequence;
    private Sequencer sequencer;
    private File file;

    public MusicPlayer() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();

        } catch (MidiUnavailableException ex) {
        }
    }

    public void loadMusic(String fileName) {
//         file = new File(fileName);
        try {
            sequence = MidiSystem.getSequence(getClass().getResource(fileName));
        } catch (InvalidMidiDataException ex) {
        } catch (IOException ex) {
        }
        try {
            sequencer.setSequence(sequence);
        } catch (InvalidMidiDataException ex) {
        }

    }

    public void playMusic() {
//         try {
//             sequencer.setSequence(sequence);
//         } catch (InvalidMidiDataException ex) {
//         }
        sequencer.start();
    }

    public void stopPlaying(){
        sequencer.stop();
    }

    public boolean isStopped() {
        return !sequencer.isRunning();
    }
    public void repeating(){
        if (sequencer.getTickPosition() == sequencer.getTickLength()) //check if reached end
        {
                sequencer.setTickPosition(0);
                sequencer.start();
         }
    }
    public void replay(){
        sequencer.setTickPosition(0);
    }
}

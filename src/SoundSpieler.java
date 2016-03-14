import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundSpieler {
	private Clip clip;

	public void play(String fileName) {
		try {
			clip = AudioSystem.getClip(); // <---
			File file = new File(fileName);
			AudioInputStream ais = AudioSystem.getAudioInputStream(file);
			clip.open(ais);
			clip.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean isPlaying() {
		if (clip == null) {
			return false;
		}
		return clip.isRunning();
	}

	public void stop() {
		if (clip != null) {
			clip.stop();
			clip.close();
		}

	}

}

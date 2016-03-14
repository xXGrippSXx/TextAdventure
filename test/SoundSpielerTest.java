import org.junit.Test;

public class SoundSpielerTest {
	@Test
	public void musikAbspielen() throws Exception {
		new SoundSpieler().play(".\\CaveSound.wav");
	}
}

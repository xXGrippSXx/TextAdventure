import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.Color;

import org.junit.Test;

public class GelaendeTest {
	@Test
	public void korrekterToolTipTextWirdZurueckgegebenHoehle() throws Exception {
		Gelaende gelaende = new Gelaende(GelaendeTyp.Hoehle);

		assertEquals(GelaendeTyp.Hoehle.name(), gelaende.getToolTipText());
	}

	@Test
	public void korrekterToolTipTextWirdZurueckgegebenBerg() throws Exception {
		Gelaende gelaende = new Gelaende(GelaendeTyp.Berg);

		assertEquals(GelaendeTyp.Berg.name(), gelaende.getToolTipText());
	}

	@Test
	public void gelaendeIstSchwarzVorBetreten() throws Exception {
		Gelaende gelaende = new Gelaende(GelaendeTyp.Berg);
		assertEquals(Color.BLACK, gelaende.getBackground());
		assertEquals("", gelaende.getText());
	}

	@Test
	public void gelaendeIstNichtSchwarzNachBetreten() throws Exception {
		Gelaende gelaende = new Gelaende(GelaendeTyp.Berg);
		gelaende.betreten();
		assertNotEquals(Color.BLACK, gelaende.getBackground());
		assertNotNull(gelaende.getBackground());
		assertEquals("X", gelaende.getText());
	}

	@Test
	public void gelaendeIstNichtWiederSchwarzNachBetretenUndVerlassen() throws Exception {
		Gelaende gelaende = new Gelaende(GelaendeTyp.Berg);
		gelaende.betreten();
		gelaende.verlassen();
		assertNotEquals(Color.BLACK, gelaende.getBackground());
		assertNotNull(gelaende.getBackground());
		assertEquals("", gelaende.getText());
	}
}

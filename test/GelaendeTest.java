import static org.junit.Assert.assertEquals;

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
}

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Parkhaus_test {

	Parkhaus p1;
	Parkhaus p2;
	Auto a1;
	Auto a2;
	Auto a3;
	@Before
	public void setUp() throws Exception {
		p1 = new Parkhaus("P1", 1000, 0.01);
		p2 = new Parkhaus("P2", 10, 0.1);
		a1 = new Auto();
		a2 = new Auto();
		a3 = new Auto();
	}

	@Test
	public void test() {
		p1.einfahren(a1);
		wait(1000);
		p1.einfahren(a2);
		wait(1000);
		p1.ausfahren(a1);
		System.out.print(a1.dauer() + " ");
		System.out.println(a1.getGebuehr());
		p1.einfahren(a3);
		wait(500);
		p1.ausfahren(a3);
		System.out.print(a3.dauer() + " ");
		System.out.println(a3.getGebuehr());
		p1.saveParkhaus();
		p2 = Parkhaus.einlesen(p1.name);
		assertEquals(p1.getAnzahlParkplaetzeFrei(), p2.getAnzahlParkplaetzeFrei());
		assertEquals(p1.name, p2.name);
	}
	@Test
	public void test2() {
		p1.einfahren(a1);
		wait(1000);
		p1.einfahren(a2);
		wait(1000);
		p1.ausfahren(a1);
		System.out.print(a1.dauer() + " ");
		System.out.println(a1.getGebuehr());
		p1.einfahren(a3);
		wait(500);
		p1.ausfahren(a3);
		System.out.print(a3.dauer() + " ");
		System.out.println(a3.getGebuehr());
		p1.saveParkhaus();
		assertEquals(p1.getAnzahlParkplaetzeFrei(), p1.getAnzahlParkplaetze()-1);
	}
	@Test
	public void test3() {
		p2.einfahren(a1);
		wait(100);
		p2.einfahren(a2);
		wait(1000);
		p2.ausfahren(a1);
		System.out.print(a1.dauer() + " ");
		System.out.println(a1.getGebuehr());
		p2.einfahren(a3);
		wait(500);
		p2.ausfahren(a3);
		System.out.print(a3.dauer() + " ");
		System.out.println(a3.getGebuehr());
		assertEquals(p2.getAnzahlParkplaetzeFrei(), p2.getAnzahlParkplaetze()-1);
	}
	public void wait(int time) {
		try {
		    Thread.sleep(time);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}

}

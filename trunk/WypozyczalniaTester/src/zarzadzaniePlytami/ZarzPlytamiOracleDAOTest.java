package zarzadzaniePlytami;

import junit.framework.TestCase;

import org.junit.Test;

import wypozyczalnia.dao.fabryki.zarzadzanieplytami.ZarzadzaniePlytamiOracleDAOMock;

public class ZarzPlytamiOracleDAOTest extends TestCase {

	private ZarzadzaniePlytamiOracleDAOMock zarz = new ZarzadzaniePlytamiOracleDAOMock();
	@Test
	public void test1() {
		zarz.zwrocPlyte(0);
		zarz.pobierzWszystkieFilmy();
	}
}

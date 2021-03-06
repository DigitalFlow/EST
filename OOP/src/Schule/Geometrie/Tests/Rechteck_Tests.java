package Schule.Geometrie.Tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import Schule.Geometrie.Rechteck;

public class Rechteck_Tests {

	@Test
	public void TestIfDoubleSettersWork()
	{
		Rechteck rechteck = new Rechteck();
		rechteck.setSeiteAB(1.0, 2.0);
		
		assertEquals(1.0, rechteck.getSeiteA(), 0);
		assertEquals(2.0, rechteck.getSeiteB(), 0);
	}
	
	@Test
	public void TestIfStringSettersWork()
	{
		Rechteck rechteck = new Rechteck();
		rechteck.setSeiteAB("1.0", "2.0");
		
		assertEquals(1.0, rechteck.getSeiteA(), 0);
		assertEquals(2.0, rechteck.getSeiteB(), 0);
	}
	
	@Test
	public void TestIfGetFlaecheWorks()
	{
		Rechteck rechteck = new Rechteck();
		rechteck.setSeiteAB(1.0, 2.0);
		
		assertEquals(2.0, rechteck.getFlaeche(), 0);
	}
	
	@Test
	public void TestIfGetUmfangWorks()
	{
		Rechteck rechteck = new Rechteck();
		rechteck.setSeiteAB(1.0, 2.0);
	
		assertEquals(6.0, rechteck.getUmfang(), 0);
	}
	
	@Test
	public void TestIfIsQuadratWorks()
	{
		Rechteck rechteck = new Rechteck();
		rechteck.setSeiteAB(1.0, 1.0);
		
		assertEquals(true, rechteck.isQuadrat());
	}
	
	@Test
	public void TestIfToStringWorks()
	{
		Rechteck rechteck = new Rechteck();
		rechteck.setSeiteAB(1.0, 2.0);
		
		assertEquals("Seite A: " + 1.0 + ", SeiteB: " + 2.0, rechteck.toString());
	}
	
	@Test
	public void TestIfGetAnzahlRechteckeWorks()
	{
		new Rechteck();
		new Rechteck(1.0, 1.0);
		new Rechteck("1.0", "2.0");
		
		assertEquals(3.0, Rechteck.getAnzahlRechteck(), 0);
	}
}

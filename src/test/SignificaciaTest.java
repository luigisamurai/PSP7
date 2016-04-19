package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import core.math.Arithmetic;
import core.math.statistics.Significancia;

public class SignificaciaTest {
	
	private final Significancia significancia = new Significancia();
	
	private final Arithmetic arithmetic = new Arithmetic();
	
	private double correlacion;
	
	private int cantidadDatos;
	
	private int redondeo;
	
	@Before 
	 public void initialize() throws Exception {
	
    }
	
	@Test
	public void hallarIntervalo() throws Exception {
		double expected = 9.052736146;
		double actual;
		correlacion = 0.954496574;
		cantidadDatos = 10; 
		redondeo = 9;
		actual = arithmetic.redondear(significancia.hallarIntervalo(correlacion, cantidadDatos), redondeo);
		Assert.assertTrue( expected ==  actual );
	}
	
	@Test
	public void hallarTDistribuccion() throws Exception {
		double expected = 0.49999112;
		double interval = 9.052736146;
		double actual;
		correlacion = 0.954496574;
		cantidadDatos = 10;		
		redondeo = 8;
		actual = arithmetic.redondear(significancia.hallarTDistribuccion(interval, cantidadDatos), redondeo);
		Assert.assertTrue( expected ==  actual );
	}
	
	@Test
	public void obtenerSignificancia() throws Exception {
		double expected = 0.0000177517;
		double actual;
		redondeo = 10;
		actual = arithmetic.redondear(significancia.obtenerSignificancia(correlacion, cantidadDatos), redondeo);
		Assert.assertTrue( expected ==  actual );
	}

}

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
		 correlacion = 0.954496574;
		 cantidadDatos = 10;
		 redondeo = 10;
    }
	
	@Test
	public void test() throws Exception {
		double expected = 0.0000177517;
		double actual = arithmetic.redondear(significancia.obtenerSignificancia(correlacion, cantidadDatos), redondeo);
		Assert.assertTrue( expected ==  actual );
	}

}

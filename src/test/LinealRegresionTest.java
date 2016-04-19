package test;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import core.io.Files;
import core.math.Arithmetic;
import core.math.statistics.LinealRegresion;
import structures.Lista;

public class LinealRegresionTest {
	
	private final LinealRegresion linealRegresion = new LinealRegresion();
	
	private final String pathFileCsv = new File("bin/PSP_PGM07.csv").getAbsolutePath();
	
	private final String separatorFileCsv = ";";
	
	private final Files files = new Files();
	
	private final Arithmetic arithmetic = new Arithmetic();
	
	private int indexX;
	
	private int indexY;
	
	private double estimate;
	
	private Lista lista;
	
	 @Before 
	 public void initialize() throws Exception {
		 estimate = 386;
		 indexX = 0;
		 indexY = 2;
		 lista = files.readColumns(pathFileCsv, indexX, indexY, separatorFileCsv);
     }
	
	@Test
	public void getCorrelation() {
		double expected = 0.954496574;
		int redondeo = 9;
		linealRegresion.obtenerProxy(lista,estimate);
		double actual = arithmetic.redondear( linealRegresion.getCorrelacion1(), redondeo);
		Assert.assertTrue( expected ==  actual );
	}
	
	@Test
	public void getCorrelationCuadrada() {
		double expected = 0.91106371;
		int redondeo = 8;
		linealRegresion.obtenerProxy(lista,estimate);
		double actual = arithmetic.redondear(linealRegresion.getCorrelacion2(), redondeo);
		Assert.assertTrue( expected ==  actual );
		
	}

}

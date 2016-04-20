package test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import core.io.Files;
import core.math.Arithmetic;
import core.math.statistics.LinealRegresion;
import core.math.statistics.PredictionInterval;
import core.math.statistics.TDistrubution;
import structures.Lista;

public class PredictionIntervalTest {
	
	private final String pathFileCsv = new File("bin/PSP_PGM07.csv").getAbsolutePath();
	private PredictionInterval predictionInterval = new PredictionInterval();

	
	@Test
	public void hallarIntervalo() throws Exception {
		int n = 10;
		double expected = 1.108154296875;
		TDistrubution tDist = new TDistrubution();
		double interval = tDist.hallarSegmento(0.5, 0.35, n-2);
		
		Assert.assertTrue( expected ==  interval );
	}
	
	@Test
	public void getOmega() throws Exception {
		
		 int indexX = 0;
		 int indexY = 2;
		 double estimate = 386;
		 double expected = 197.46296667661423;
		 Arithmetic arit = new Arithmetic();

		 String separatorFileCsv = ";";
		 Lista lista = new Files().readColumns(pathFileCsv, indexX, indexY, separatorFileCsv);
		 LinealRegresion linealRegresion = new LinealRegresion();
		 linealRegresion.obtenerProxy(lista,estimate);
		 double omega = predictionInterval.getOmega(lista, arit.redondear(linealRegresion.getBetaSub0(),5), arit.redondear(linealRegresion.getBetaSub1(),9) );
		 
		Assert.assertTrue( expected ==  omega );
	}

}


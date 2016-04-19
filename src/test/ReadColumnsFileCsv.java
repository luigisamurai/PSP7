package test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import core.io.Files;
import structures.Lista;


public class ReadColumnsFileCsv {
	
	private final String pathFileCsv = new File("bin/PSP_PGM07.csv").getAbsolutePath();
	
	private final String separatorFileCsv = ";";
	
	private final Files files = new Files();
	
	private Lista valuesExpected;
	
	private int indexX;
	
	private int indexY;

	 @Before 
	 public void initialize() {
		 indexX = 0;
		 indexY = 2;
		 
		 valuesExpected = new Lista();
		 valuesExpected.add(130,186);
		 valuesExpected.add(650,699);
		 valuesExpected.add(99,132);
		 valuesExpected.add(150,272);
		 valuesExpected.add(128,291);
		 valuesExpected.add(302,331);
		 valuesExpected.add(95,199);
		 valuesExpected.add(945,1890);
		 valuesExpected.add(368,788);
		 valuesExpected.add(961,1601);
     }
	
	@Test
	public void getColumXAndY() {
		Lista lista;
		try {
			lista = files.readColumns(pathFileCsv, indexX, indexY, separatorFileCsv);
			for(int index = 0; index <valuesExpected.count(); index++){
				Assert.assertEquals(valuesExpected.getAt(index).getValue().toString(), lista.getAt(index).getValue().toString());
				Assert.assertEquals(valuesExpected.getAt(index).getSecondValue().toString(), lista.getAt(index).getSecondValue().toString());
			}
	
		} catch (Exception e) {
			fail();
		}
	}

}


import java.io.File;

import core.io.Files;
import core.math.Arithmetic;
import core.math.statistics.LinealRegresion;
import core.math.statistics.PredictionInterval;
import core.math.statistics.Significancia;
import structures.Lista;

/*
 * @ClassName : Main 
 * Responsibility : Clase de acceso al programaa
 * Auhor: Luis ALberto Bolaños
 * Created: 28-ene-2016
 * Modified by:
 * Modified:
 */
public class Main {
	
	/*
	* @Method: main
	* Description: Metdo de acceso inicial del programa
	* Params: path: {string[]} lista de parametros para acceso desde consola 
	* Return: Objecto Lista
	* Recomendaciones: Ajuste los parametros ruta, separador para leer otro archivo o ajuster el separador de datos en el mismo archivo 
	*/
	public static void main(String[] args) throws Exception {
		String ruta = null;
		String separator = null;
		Lista lista = null;
		PredictionInterval predInterval = null;
		double E = 0;
		int[][] columns = null;
		int digito = 9;
		double significancia;
		Files files = null;
		try{
			
			ruta = new File("bin/PSP_PGM07.csv").getAbsolutePath();
			separator = ";";
			E  = Double.parseDouble(args[0]);
			columns = new int[][]{{0,2},{0,3}};
			
			predInterval = new PredictionInterval();
			
			files = new Files();
			
			System.out.println( 
					"r" +  "\t\t\t" +
					"r*r" +  "\t\t\t" +
					"Significance" +  "\t\t" +	
					"B0" +  "\t\t\t" +
					"B1" +  "\t\t\t" +
					"P" +  "\t\t\t" +
					"Range" +  "\t\t\t" +
					"UPI" +  "\t\t\t" +
					"LPI" +  "\t\t"
		    );
			
			
			for (int i = 0; i < columns.length; i++) {
				
				lista = files.readColumns(ruta, columns[i][0], columns[i][1], separator);
				
				predInterval.obtenerInterval(lista, E);
				significancia = new Significancia().obtenerSignificancia(predInterval.getCorrelacion1(), lista.count());
				
				
				System.out.println( 
						Arithmetic.redondear(predInterval.getCorrelacion1(),digito) +  "\t\t" +
						Arithmetic.redondear(predInterval.getCorrelacion2(),digito) +  "\t\t" +
						Arithmetic.redondear(significancia,digito) +  "\t\t" +	
						Arithmetic.redondear(predInterval.getBetaSub0(), digito) +  "\t\t" +
						Arithmetic.redondear(predInterval.getBetaSub1(), digito) +  "\t\t" +
						Arithmetic.redondear(predInterval.getProxy(), digito) +  "\t\t" +
						Arithmetic.redondear(predInterval.getRange(), digito) +  "\t\t" +
						Arithmetic.redondear(predInterval.getUpi(), digito) +  "\t\t" +
						Arithmetic.redondear(predInterval.getLpi(), digito) +  "\t\t"
			    );
			}
			
		}
		catch(Exception e){
			throw e;
		}
		
		
		
	}

}

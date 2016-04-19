package core.math.statistics;

import core.math.Arithmetic;
import structures.Lista;

/*
 * @ClassName : LinealRegresion
 * Responsibility : realiza calculos para calcular la regresion lineal
 * Auhor: Luis Alberto Bolaños
 * Created:  28-ene-2016
 *
*/
public class LinealRegresion {
	
	/*
	 * Parametro beta 1: para calcular regresion lineal
	*/
	private double betaSub1; 
	
	/*
	 * Parametro beta 0: para calcular regresion lineal
	 */
	private double betaSub0;
	
	/*
	 * Coeficiente de correlacion
	 */
	private double correlacion1;
	
	/*
	 * Coeficiente de correlacion cuadrado
	 */
	private double correlacion2;
	
	
	/*
	 * Promedio de los datos en x
	 */
	private double avgX;
	
	
	/*
	 * Especifica el valor del proxy calculado
	 */
	private double proxy;
	
	/*
	* @Method: getProxy
	* Description: Calcula los parametros de l regresion lineal y el proxy
	* Params: lista{Lista}: conjunto de datos a calcular
	* Return: El proxy de  estimacion
	*/
	public void obtenerProxy(Lista lista, double E){
		double sumProduct = 0;
		double sumSquareX = 0;
		double avgY = 0;
		double sumX = 0;
		double sumY = 0;
		double numerador;
		double denominador;
		double sumSquareY = 0;
		int n = 0;
		Arithmetic arithmetic = null;
		
		try{
			
			arithmetic = new Arithmetic();
			n = lista.count();
			sumX = arithmetic.sum(lista, 1);
			sumY = arithmetic.sum(lista, 2);
			sumProduct = arithmetic.sumProduct(lista);
			sumSquareX = arithmetic.sumSquare(lista, 1);
			sumSquareY = arithmetic.sumSquare(lista, 2);
			avgX = sumX / n;
			avgY = sumY / n;
			
			// Calculando beta sub 1
			numerador =  sumProduct - ( n * avgX * avgY );
			denominador =  sumSquareX - (n * Math.pow(avgX, 2));
			betaSub1 = numerador / denominador;
			
			// Calculando beta sub 0
			betaSub0 = avgY - ( betaSub1 * avgX );
			
			//Calculando coeficianete de correlacion
			numerador = (n * sumProduct) - ( sumX * sumY );
			
			denominador =  (n *  sumSquareX) - Math.pow(sumX, 2);
			denominador = denominador * ( ( n * sumSquareY ) - Math.pow(sumY, 2));
			
			correlacion1 =  numerador / Math.sqrt(denominador) ;
			
			//Calculando coeficianete de correlacion cuadrado
			correlacion2 = Math.pow(correlacion1, 2);
			
			//Calculo de proxy
			proxy = betaSub0 + (betaSub1 * E);
			
			
		}
		catch(NumberFormatException e){
			System.out.println("Los datos ingresados deben ser numeros");
			throw e;
		}
		catch(Exception e){
			throw e;
		}
		
		
	}
	

	public double getBetaSub1() {
		return betaSub1;
	}

	public void setBetaSub1(double betaSub1) {
		this.betaSub1 = betaSub1;
	}

	public double getBetaSub0() {
		return betaSub0;
	}

	public void setBetaSub0(double betaSub0) {
		this.betaSub0 = betaSub0;
	}

	public double getCorrelacion1() {
		return correlacion1;
	}

	public void setCorrelacion1(double correlacion1) {
		this.correlacion1 = correlacion1;
	}

	public double getCorrelacion2() {
		return correlacion2;
	}

	public void setCorrelacion2(double correlacion2) {
		this.correlacion2 = correlacion2;
	}


	public double getAvgX() {
		return avgX;
	}


	public double getProxy() {
		return proxy;
	}		

}

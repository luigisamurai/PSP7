package core.math.statistics;

import core.math.Arithmetic;
import structures.Lista;
import structures.Nodo;

public class PredictionInterval extends LinealRegresion {
	
	/*
	 *  Almacena el rango del intervalo
	 */
	private double range;
	
	/*
	 * Almacena el intervalo superior
	 */
	private double upi;
	
	
	public PredictionInterval(){
	
		
	}
	
	/*
	 * Almacena el intervalo inferior
	 */
	private double lpi;
	
	
	/*
	* @Method: Calcula el rango, el LPI y el UPI
	* Description: Obtiene el valor de la significancia de un par de datos.
	* Params: 
	* 	r : valor de correlacion de los datos
	* 	n  : numero de datos
	* Return:  double: valor redondeado
	*/
	public void obtenerInterval (Lista lista, double E ) throws Exception{
		double interval;
		double omega;
		double n;
		double sumDifDatisAvg;
		double proxy;
		double avg;
		Arithmetic arit = new Arithmetic();
		TDistrubution tDist = new TDistrubution();
		
		try{
			obtenerProxy(lista, E);
			proxy  = getProxy();
			n  = Double.parseDouble(String.valueOf(lista.count()));
			interval  = tDist.hallarSegmento(0.5, 0.35, n-2);
			omega = getOmega(lista, getBetaSub0(), getBetaSub1());
			avg = getAvgX();
			sumDifDatisAvg = arit.sumDifDatosAvg(lista, avg, 1);
			range =  interval * omega * Math.sqrt( ( 1 + (1.0 / n) ) +  ( (Math.pow(E - avg, 2)) / sumDifDatisAvg ) );
			upi = proxy + range;
			lpi = proxy - range;
			
		}
		catch(Exception e){
			throw e;
		}
	}
	
	
	public double getOmega(Lista lista, double bo, double b1){
		Nodo nodo = null;
		Double sum = 0D;
		Double value = 0D;
		Double omega;
		try{
			

			if(lista.count() > 0){
				nodo = lista.getPrimerNodo();
				do{
					value = Math.pow( ( Double.parseDouble(nodo.getSecondValue().toString()) - bo ) - ( b1 * Double.parseDouble(nodo.getValue().toString()) ), 2); 
					sum+=  value;
					nodo = nodo.getNodoDerecho();
				} while( nodo!= null && nodo.getValue()!=null );
				
				
			}
			
			omega = Math.sqrt(  (1.0 / ( lista.count() - 2 ))   * sum );
			return omega;
		}
		catch(NumberFormatException e){
			throw e;
		}
		catch(Exception e){
			throw e;
		}
	}
	
	public double getRange() {
		return range;
	}

	public double getUpi() {
		return upi;
	}

	public double getLpi() {
		return lpi;
	}
}

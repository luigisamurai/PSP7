package core.math.statistics;

import core.math.Arithmetic;

/*
 * @ClassName : TDistrubution
 * Responsibility : Calcula la distribucion T Fx
 * Auhor: Luis Alberto Bolaños
 * Created:  07-feb-2016
 *
*/
public class TDistrubution {
	
	/*
	 * Variable de tolerancia de error
	 */
	private final Double ACCEPT_ERROR = 0.0000001;
	
	
	/*
	* @Method: fxGama
	* Description: formula fx aplicada a la distribucion
	* Params: 
	* 	x  :  valor a evaluar
	*   dof:  grados de tolerancia
	* Return: 
	* Valor real
	*/
	public Double fxGama(Double x,  Double dof) throws Exception{
		Double num;
		Double den;
		Double fact;
		GammaFunction  gammaFx = new GammaFunction();
		try{
			num = gammaFx.gamma( (dof + 1) / 2 ); 
			
			den = Math.pow( dof * Math.PI, 0.5);
			den = den * gammaFx.gamma( dof / 2);
			
			fact = (1 +  (Math.pow(x, 2) / dof) );
			fact = Math.pow( fact,  -1 * (dof + 1) / 2 );
		
			return num / den * fact;

		}
		catch(Exception e){
			throw e;
		}
	}
	
	
	/*
	* @Method: SumIntervals
	* Description: Suma los intervalos de la ecuacion y lo divide w/3
	* Params: 
	* 	total   :  valor total de intervalos
	* intervals :  numero de intervalo a evaluar 
	*   dof:  grados de tolerancia
	* Return: 
	* Valor real
	*/
	public Double sumIntervals(Double total, int intervals, Double dof) throws Exception{
		double width = 0;
		double x;
		double mult;
		int index = 0;
		double result = 0;
		try{
			width = total / intervals;
			
			do{
				
				x = width * index;
				
				if( x == 0 || x == total )
					mult = 1;
				else if( index % 2 == 0 )
					mult = 2;
				else
					mult = 4;
				
				index = index + 1;
				result+= mult * fxGama(x, dof);
				
			}
			while(x  <  total);
			
			return result;

		}
		catch(Exception e){
			throw e;
		}
	}
	
	/*
	* @Method: distributionPgf
	* Description: Obtiene la distribucion de fx
	* Params: 
	* 	total   :  valor total de intervalos
	* 	intervals :  numero de intervalo a evaluar 
	*   dof:  grados de tolerancia
	* Return: 
	* Valor real
	*/
	public Double distributionPgf(Double total, int intervals, Double dof) throws Exception{
		Integer index = 0;
		Integer mult = 0;
		Double p = 0D;
		Double p0 = 0D;
		Double factor = 0D;
		Arithmetic arit = new Arithmetic();
		Double width = 0D;
		try{
			width = total / intervals;
			
			do{

				mult   = (int)(Math.pow(2, index));
				factor = (total / (intervals * mult)) / 3;
				p0 =  factor * sumIntervals(total, (intervals * mult),  dof);
				
				mult   = (int)(Math.pow(2, index+ 1));
				factor = (total / (intervals * mult)) / 3;
				p =   factor * sumIntervals(total, (intervals * mult) , dof);
					
				//System.out.println(  p0 + "\t"+ p   );
				
				index = index + 1;
				
			} while( Math.abs( p0 - p ) > ACCEPT_ERROR );
			
			return p;
				
		}
		catch(Exception e){
			throw e;
		}
	}
	
	

	/*
	* @Method: hallarSegmento
	* Description: Encuentra el segmento total a partor de los pDistribucion y dof
	* Params: 
	* 	total   : valor inicial del segmento a evaluar
	* 	pDistEsperado :  valor de la distrubucion a la que le encontrara el segmento
	*   dof:  grados de tolerancia
	* Return: 
	* Valor real
	*/
	public double hallarSegmento(double total, double pDistEsperado, double dof) throws Exception{
		Double pDistEspeculado;
		Double diferencia;
		int estado = 0;
		Double acum = 0.5;
		int estadoAnterior = 1;
		int intervalos = 10;
		Arithmetic arithmetic = new Arithmetic();
		
		try{
			do{
				
				if( total == 0)
					total =  0.0000001;
				
				pDistEspeculado = distributionPgf(total, intervalos, dof);
				diferencia = pDistEspeculado -  pDistEsperado;
				
				
			
				/*
				 * Se dectermina si se hallo el segmento o si se esta por encima o por debajo
				 */
				if( diferencia == 0){
					estado = 0;
					break;
				}
				else if(diferencia > 0){
					estado = 1;
					acum = -1 * Math.abs(acum);
				}
				else{
					estado = -1;
					acum =  Math.abs(acum);
				}
				
				// en caso de cambio de signo se divide a la mitad el acumulador
				if( estadoAnterior != estado )
					acum = acum / 2;
				
				estadoAnterior = estado;
				total = total + acum;
				
				//System.out.println( total   + "\t" + arithmetic.redondear(diferencia, 5));
				
				
			} while (true);
			
			
			return total;

		}
		catch(Exception e){
			throw e;
		}
	}
	
}

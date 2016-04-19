package core.math.statistics;

public class Significancia {
	
	/*
	 * Almacena el valor para comparar las significancia altas 
	*/
	private final double  RELACION = 0.05; 
	
	/*
	 * Almacena el rango para identificar las relaciones  bajas o por casualidad 
	*/
	private final double  CASUALIDAD = 0.2;	
	
	/*
	* @Method: hallarIntervalo
	* Description: halla el intervalo para el calculo de la significacia.
	* Params: 
	* 	r : valor de correlacion de los datos
	* 	numeroDatos  : numero de datos
	*/
	public double hallarIntervalo(double correlacion, int numeroDatos){
		double intervalo = ( Math.abs(correlacion) * Math.sqrt( numeroDatos - 2 )) / ( Math.sqrt( 1 - ( Math.pow( correlacion, 2) ) ) );
		return intervalo;
	}
	
	/*
	* @Method: hallarTDistribuccion
	* Description: halla la distribucion para el intervalo y numero de datos.
	* Params: 
	* 	intervalo :    Intervalo total a considerar para la distribucion
	* 	numeroDatos  : numero de datos
	*/
	public double hallarTDistribuccion(double intervalo, int numeroDatos) throws Exception{
		double probDist = new TDistrubution().distributionPgf(intervalo, 10, (double) numeroDatos-2 );
		return probDist;
	}
	
	/*
	* @Method: obtenerSignificancia
	* Description: Obtiene el valor de la significancia de un par de datos.
	* Params: 
	* 	correlacion : valor de correlacion de los datos
	* 	numeroDatos  : numero de datos
	*/
	public double obtenerSignificancia ( double correlacion, int numeroDatos) throws Exception{
		double intervalo = hallarIntervalo(correlacion, numeroDatos);
		double tdistribuccion = hallarTDistribuccion(intervalo, numeroDatos);
		double significancia = 1 - (2 * tdistribuccion);
		return significancia;
	}
	
	
	/*
	* @Method: obtenerSignificancia
	* Description: Valida si el numero especificado como significancia es una relación..
	* Params: 
	* significancia: valor de la significancia
	*/
	public Boolean EsRelacion( double significancia){
		return significancia <= RELACION;
	}
}

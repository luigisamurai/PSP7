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
	* @Method: obtenerSignificancia
	* Description: Obtiene el valor de la significancia de un par de datos.
	* Params: 
	* 	r : valor de correlacion de los datos
	* 	n  : numero de datos
	* Return:  double: valor redondeado
	*/
	public double obtenerSignificancia ( double r, int n) throws Exception{
		double t = 0;
		double probDist = 0;
		double significancia = 0;
		TDistrubution tDistrubution = new TDistrubution();
		try{
			t = Math.abs(r) * Math.sqrt(n -1) / Math.sqrt( 1 - (r * r) );
			probDist = tDistrubution.distributionPgf(t, 10, (double) n-2 );
			significancia = 1 - 2 * probDist;
			return significancia;

		}
		catch(Exception e){
			throw e;
		}
		
	}
	
	/*
	* @Method: obtenerSignificancia
	* Description: Valida si el numero especificado como significancia es una relación..
	* Params: 
	* significancia: valor de la significancia
	* Return:  double
	*/
	public Boolean EsRelacion( double significancia){
		return significancia <= RELACION;
	}
}

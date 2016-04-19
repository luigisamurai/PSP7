package core.math.statistics;

import core.math.Arithmetic;


/*
 * @ClassName : GammaFunction
 * Responsibility : Calcula la funcion gamma
 * Auhor: Luis Alberto Bolaños
 * Created:  07-feb-2016
 *
*/
public class GammaFunction {
	
	
	/*
	* @Method: gamma
	* Description: calcula el valor gamma para valores positivos
	* Params: 
	* 	x  :  valor a evaluar
	*   dof:  grados de tolerancia
	* Return: 
	* Valor real
	* Flujo alterno: en caso de llegar a evaluar un valor negativo o cero se retorna la excepcion
	*/
	public Double gamma(Double x) throws Exception{
		Arithmetic arit = new Arithmetic();
		try{
			
			if( arit.IsInteger(x) )
				return new Double(arit.factorial( x.longValue() - 1 ));
			else if( x == 1 )
				return  1D;
			else if( x ==  0.5 )
				return Math.sqrt(Math.PI);
			else if( x <= 0 )
				throw new Exception("Esta funcion gama no soporta valores negativos");
			
			//x = arit.redondear(x, 5);
			return  (x - 1) * gamma( (x - 1));
		}
		catch(Exception e){
			throw e;
		}
	}
	
}

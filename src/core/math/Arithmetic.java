package core.math;

import java.text.DecimalFormat;

import structures.Lista;
import structures.Nodo;


/*
 * @ClassName : Arithmetic
 * Responsibility : realiza calculos matematicos o estadisticos
 * Auhor: Luis Alberto Bolaños
 * Created:  08-dic-2015
 *
*/
public class Arithmetic {
	
	
	/*
	* @Method: sum
	* Description: Realiza la suma de un conjunto de datos de una Lista
	* Params: Lista[] lista : lista enlazada (Clase del programa)
	* Return: double: numero decimal
	*/
	public Double sum(Lista lista, int idx){
		Nodo nodo = null;
		Double sum = 0D;
		try{
			
			if(lista.count() > 0){
				nodo = lista.getPrimerNodo();
				while( nodo.getNodoDerecho() != null ){
					sum+=  Double.parseDouble(nodo.getValue(idx).toString());
					nodo = nodo.getNodoDerecho();
				}
				sum+= Double.parseDouble(nodo.getValue(idx).toString());
			}
			
			return sum;
		}
		catch(NumberFormatException e){
			throw e;
		}
		catch(Exception e){
			throw e;
		}
		
	}
	
	
	/*
	* @Method: sumSquare
	* Description: Realiza la suma de un conjunto de datos al cuadrado de una Lista
	* Params: Lista[] lista : lista enlazada (Clase del programa)
	* Return: double: numero decimal
	*/
	public Double sumSquare(Lista lista, int idx){
		Nodo nodo = null;
		Double sum = 0D;
		try{
			
			if(lista.count() > 0){
				nodo = lista.getPrimerNodo();
				while( nodo.getNodoDerecho() != null ){
					sum+=  Math.pow( Double.parseDouble(nodo.getValue(idx).toString()), 2);
					nodo = nodo.getNodoDerecho();
				}
				sum+= Math.pow( Double.parseDouble(nodo.getValue(idx).toString()), 2);
			}
			
			return sum;
		}
		catch(NumberFormatException e){
			throw e;
		}
		catch(Exception e){
			throw e;
		}
		
	}
	
	/*
	* @Method: sumProduct
	* Description: Realiza la suma del producto de un conjunto de datos
	* Params: Lista[] lista : lista enlazada (Clase del programa)
	* Return: double: numero decimal
	*/
	public double sumProduct(Lista lista){
		Nodo nodo = null;
		Double sum = 0D;
		try{
			
			if(lista.count() > 0){
				nodo = lista.getPrimerNodo();
				while( nodo.getNodoDerecho() != null ){
					sum+= Double.parseDouble(nodo.getValue().toString()) * Double.parseDouble(nodo.getSecondValue().toString());
					nodo = nodo.getNodoDerecho();
				}
				sum+= Double.parseDouble(nodo.getValue().toString()) * Double.parseDouble(nodo.getSecondValue().toString());
			}
			
			return sum;
		}
		catch(NumberFormatException e){
			throw e;
		}
		catch(Exception e){
			throw e;
		}
		
	}
	 
	
	
	/*
	* @Method: avg
	* Description: Calcula el promedio de una lista de datos
	* Params: Lista[] lista : lista enlazada (Clase del programa)
	* Return: float: numero de coma flotante pequeño
	*/
	public Double avg(Lista lista, int idx){
		Double sum = 0D;
		Double avg = 0D;
		try{
			sum = sum(lista, idx);
			avg = sum / lista.count();
			return avg;
		}
		catch(NumberFormatException e){
			throw e;
		}
		catch(Exception e){
			throw e;
		}
	}
	
	
	/*
	* @Method: deviation
	* Description: Calcula la desviacion de una lista de datos
	* Params: 
	* 	Lista[] lista : lista enlazada (Clase del programa)
	* 	avg  : promedio de los datos
	* Return: 
	* float: numero de coma flotante pequeño
	*/
	public Double sumDifDatosAvg(Lista lista, Double avg, int idxValue){
		
		Nodo nodo = null;
		Double sum = 0D;
		Double dato = null;
		try{
			
			if(lista.count() > 0){
				nodo = lista.getPrimerNodo();
				
				while( nodo.getNodoDerecho() != null ){
					dato =  Double.parseDouble(nodo.getValue(idxValue).toString());
					sum+= Math.pow( dato - avg, 2);
					nodo = nodo.getNodoDerecho();
				}
				dato =  Double.parseDouble(nodo.getValue(idxValue).toString());
				sum+= Math.pow(dato - avg, 2);
			}

			return sum;
			
		}
		catch(NumberFormatException e){
			throw e;
		}
		catch(Exception e){
			throw e;
		}
		
	}
	
	/*
	* @Method: deviation
	* Description: Calcula la desviacion de una lista de datos
	* Params: 
	* 	Lista[] lista : lista enlazada (Clase del programa)
	* 	avg  : promedio de los datos
	* Return: 
	* float: numero de coma flotante pequeño
	*/
	public Double deviation(Lista lista, Double avg, int idxValue){
		
		Double sum = 0D;
		Double deviation = 0D;
		try{
			
			sum = sumDifDatosAvg(lista, avg, idxValue);
			deviation = sum / (lista.count() - 1);
			deviation = Math.sqrt(deviation);

			return deviation;
			
		}
		catch(NumberFormatException e){
			throw e;
		}
		catch(Exception e){
			throw e;
		}
		
	}
	
	/*
	* @Method: redondear
	* Description: redondea un valor double a numero de decimas especificadas
	* Params: 
	* 	numero : valor a redondear
	* 	digitos  :numero de decimas que se redondean
	* Return: 
	* double: valor redondeado
	*/
	public static Double redondear(Double numero, int digitos)
	{
		/*
	      int cifras=(int) Math.pow(10,digitos);
	      return Math.rint(numero*cifras)/cifras;
	    */
		
		Double cifras = Math.pow(10,digitos);
		return (double) ( Math.rint( numero * cifras ) / cifras);
		
	}
	
	/*
	* @Method: factorial
	* Description: Halla el factorial de un numero entero
	* Params: 
	* 	value (valor que se calcula el factorial)
	* Return: 
	* Valor entero
	* flujo alterno: En caso de recibir un numero negativo se retorna la excepcion
	*/
	public Long factorial(Long value) throws Exception{
		try{
			
			if(value < 0)
				throw new Exception("No se permite el calculo de factorial a un valor negativo");
			
			if( value == 0 )
				return 1L;
			
			
			return value * factorial(value -1);
		}
		catch(Exception e){
			throw e;
		}
	}
	
	
	/*
	* @Method: IsInteger
	* Description: verifica si un numero real es entero (1.0, 2.5)
	* Params: 
	* 	value (valor que se verifica)
	* Return: 
	* Valor entero
	*/
	public boolean IsInteger(Double value){
		return value % 1 == 0;
	}
	
}

package structures;

/*
 * @ClassName : Nodo 
 * Responsibility : Objecto que representa un nodo de la lista
 * Auhor: Luis ALberto Bolaños
 * Created: 11-dic-2015
 * Modified by:
 * Modified:
 */
public class Nodo {
	
	/*
	 * Almacena el valor o dato
	 */
	private Object value;
	
	
	/*
	 * Almacena el valor o dato
	 */
	private Object secondValue;

	/*
	 * Almacena el nodo derecho o siguiente
	 */
	private Nodo nodoDerecho;
	
	// Constructor
	public Nodo(Object value){
		this.value = value;
		this.nodoDerecho = null;
	}
	
	/*
	 * Constryctor del para almacenar dos elementos
	 */
	public Nodo(Object value, Object secondValue){
		this.value = value;
		this.secondValue = secondValue;
		this.nodoDerecho = null;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Nodo getNodoDerecho() {
		return nodoDerecho;
	}

	public void setNodoDerecho(Nodo nodoDerecho) {
		this.nodoDerecho = nodoDerecho;
	}

	public Object getSecondValue() {
		return secondValue;
	}

	public void setSecondValue(Object secondValue) {
		this.secondValue = secondValue;
	}
	
	/*
	* @Method: getValue
	* Description: retorna un elemento del nodo deacuerso al indice numerico recibido
	* Params: idxValue{int}: indice que especifica que valor enviar
	* Return: int
	*/ 
	public Object getValue(int idxValue) {
		Object value = null;
		switch(idxValue){
			case 1: {
				value = this.value;
			}break;
			
			case 2: {
				value = secondValue;
			}break;
		}
		return value;
	}
	
}

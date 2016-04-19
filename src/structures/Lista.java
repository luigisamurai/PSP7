package structures;


/*
 * @ClassName : Lista 
 * Responsibility : Estructura de lista enlazada
 * Auhor: Luis ALberto Bolaños
 * Created: 11-dic-2015
 * Modified by:
 * Modified:
 */
public class Lista {
	
	/*
	 *  Almacena el primer nodo de la lista
	 */
	Nodo primerNodo;
	
	

	/*
	 * Almacena el ultimo nodo de la lista
	 */
	Nodo ultimoNodo;
	
	/*
	 * Almacena el tamaño de la lista
	 */
	int size = 0;

	/*
	* @Method: add
	* Description: adiciona un elemento a la lista
	* Params: value{string}: valor que se adiciona
	* Return: void
	*/
	public void add(Object value){
		Nodo nodo = new Nodo(value);
		
		if(size == 0)
			primerNodo = nodo;
		else
			ultimoNodo.setNodoDerecho(nodo);
		
		ultimoNodo =  nodo;
		size++;
	}
	
	
	/*
	* @Method: add
	* Description: adiciona dos elementos a la lista
	* Params: value{string}: valor que se adiciona al primer elemento
	* secondValue{string}: valor que se adiciona al segundo elemento
	* Return: void
	*/
	public void add(Object value, Object secondValue){
		Nodo nodo = new Nodo(value, secondValue);
		
		if(size == 0)
			primerNodo = nodo;
		else
			ultimoNodo.setNodoDerecho(nodo);
		
		ultimoNodo =  nodo;
		size++;
	}
	
	/*
	* @Method: count
	* Description: retorna el total items de la lista
	* Params: value{string}: valor que se adiciona
	* Return: int
	*/
	public int count(){
		return size;
	}
	
	/*
	* @Method: getAt
	* Description: retorna el nodo en la posicion indicada
	* Params: index{int}: posicion del elemento
	* Return: int
	*/
	public Nodo getAt(int index){
		
		if(index >= size)
			return null;
		
		Nodo nodo = primerNodo;
		for(int i=1; i<=index; i++){
			nodo = nodo.getNodoDerecho();
		}
		
		return nodo;
	}
	
	public Nodo getPrimerNodo() {
		return primerNodo;
	}

	public void setPrimerNodo(Nodo primerNodo) {
		this.primerNodo = primerNodo;
	}

	public Nodo getUltimoNodo() {
		return ultimoNodo;
	}

	public void setUltimoNodo(Nodo ultimoNodo) {
		this.ultimoNodo = ultimoNodo;
	}
	
}

 
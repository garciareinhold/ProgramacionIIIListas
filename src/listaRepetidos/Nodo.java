package listaRepetidos;


public class Nodo {

	private Object info;
	private Nodo siguiente;

	public Nodo() {
		siguiente = null;
	}

	public Nodo(Object info, Nodo siguiente) {
		setInfo(info);
		setSiguiente(siguiente);
	}
	
	public void setSiguiente(Nodo n) {
		siguiente = n;
	}

	public void setInfo(Object info) {
		this.info = info;
	}

	public Object getInfo() {
		return this.info;
	}

	public Nodo getSiguiente() {
		return this.siguiente;
	}
}


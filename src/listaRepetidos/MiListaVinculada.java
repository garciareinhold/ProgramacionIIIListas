package listaRepetidos;

import java.util.Iterator;

public class MiListaVinculada implements Iterable<Object>{
	
	private Nodo primero;
	private int tamanio;
	
	public MiListaVinculada() {
		primero=null;
		tamanio=0;
	}
	
	//Creo un iterador para recorrer las listas, junto con un cursor.
	public class MiIterador implements Iterator<Object>{
		
		private Nodo cursor;
		
		private MiIterador(Nodo primero){
			cursor=primero;
		}
		//Redefino los métodos de Iterator para que me informen si el cursor apunta a "null" y para que me devuelvan el Nodo al que apunta
		@Override
		public boolean hasNext() {
			return cursor!=null;
		}

		@Override
		public Nodo next() {
			Nodo temp=cursor;
			cursor=cursor.getSiguiente();
			return temp;
		}
		//Reestablezco el cursor para seguir iterando en iteradores anidados
		public void resetCursor() {
			cursor=primero;
		}
	}
	
	public int getTamanio() {
		return this.tamanio;
	}
	
	public boolean vacia() {
		return (primero==null);
	}
	
	public void insertarPrincipio(Object i) {
		Nodo aux= new Nodo(i, null);
		aux.setSiguiente(primero);
		primero=aux;
		tamanio++;
	}
	
	//Método para insertar un elemento al final, recorriendo los demás elementos hasta llegar al último y cambiar su puntero de "null" al elemento en cuestión
	public void insertarFinal(Object o) {

		if(this.vacia()) this.insertarPrincipio(o);
		
		else {
			
			Nodo aux= primero;
			
			for(int i=0; i<tamanio-1; i++) {
				aux=aux.getSiguiente();
			}
			aux.setSiguiente(new Nodo(o, null));
			tamanio++;
		}
		
	}
	
	public Object verPrimero() {
		if (primero==null) return -1;
		else return primero.getInfo();	
	}
	
	public void imprimir(int n) {
		
		Nodo aux= primero;
		int contador=0;
		
		if (getTamanio()>=n) {
			while (contador!=n) {
				contador++;
				if (contador==n) {
					System.out.println(aux.getInfo());
				}
				aux=aux.getSiguiente();
			}
			System.out.println(aux.getInfo());
		}
		else System.out.println("La lista no contiene tantos elementos");
	}
	
	public Object extraer() {
		Nodo aux= primero;
		primero= aux.getSiguiente();
		tamanio--;
		return aux.getInfo();
	}

	//Método para insertar un elemento ordenadamente. Se fija si la lista esta vacia o si es menor al primer elemento, de ser asi se inserta al principio,
	//Si no recorre los demás elementos fijándose en el valor del elemento que lo sigue para hacer la comparación, una vez encontrado o no un numero menor, realiza la inserción
	public void insertarOrdenado(Object o) {

		int elem1= (int) o;
		
		if ((this.vacia())||elem1<=(int)primero.getInfo()){
			insertarPrincipio(o);
		}

		else {
			
			MiIterador it= this.iterator();
			boolean corte=false;
			
			while((it.hasNext())&&(!corte)){
				
				Nodo inicio= it.next();
				Nodo aux=inicio;
				
				if(inicio.getSiguiente()!=null) {
					aux= aux.getSiguiente();
				}				
				
				if(elem1<(int)aux.getInfo()){
					corte=true;
					inicio.setSiguiente(new Nodo (o,aux));
					tamanio++;
				}
			}
			if(!corte) {
				this.insertarFinal(o);
			}
		}
	}
	
	@Override
	public MiIterador iterator() {
		return new MiIterador(primero);
	}


	


}


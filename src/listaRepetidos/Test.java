package listaRepetidos;

import listaRepetidos.MiListaVinculada.MiIterador;

public class Test {
	
	
	//Método para armar una lista con los elementos repetidos de dos listas, ordenadas de menor a mayor.
	//Se usan dos iteradores para recorrer ambas listas, al encontrarse dos elementos iguales en dos listas se agregan al final de la lista resultante.
	//Si el primer elemento resulta ser menor que el elemento en iteración de la segunda lista, deja de buscar.
	public static void ListaRepetidosOrdenados(MiListaVinculada l3, MiListaVinculada l1, MiListaVinculada l2) {
		
		MiIterador itl1= l1.iterator();
		MiIterador itl2= l2.iterator();
		
		while(itl1.hasNext()) {
			
			boolean corte=false;
			int eleml1= (int) itl1.next().getInfo();
			
			while(itl2.hasNext()&&(!corte)) {
				
				int eleml2=(int) itl2.next().getInfo();
				
				if(eleml1<=eleml2) {
					corte=true;
					if(eleml1==eleml2) l3.insertarFinal(eleml1);
					itl2.resetCursor();
				}
			}
			itl2.resetCursor();

		}
	}
	
	//Método para armar una lista de los repetidos de dos listas desordenadas.
	//Se usan dos iteradores para recorrer las listas, si los elementos son iguales se insertan ordenadamente.
	//Este método nos toma más tiempo, al tener un recorrido extra tal como el que implica el método "insertarOrdenado(Object o)"
	public static void ListaRepetidosDesordenados(MiListaVinculada l3, MiListaVinculada l1, MiListaVinculada l2) {
		
		MiIterador iteradorl1= l1.iterator();
		MiIterador iteradorl2=l2.iterator();
	
		while(iteradorl1.hasNext()) {
			
			boolean corte= false;			
			int elemL1= (int)iteradorl1.next().getInfo();
			
			while(iteradorl2.hasNext()&& (!corte)) {
				
				int elemL2=(int)iteradorl2.next().getInfo();
				if(elemL1==elemL2) {
					corte=true;
					l3.insertarOrdenado(elemL1);
				}
			}
			iteradorl2.resetCursor();
		}
	}

	public static void main(String[] args) {

		//Armo dos listas desordenadas
		
		MiListaVinculada ld1= new MiListaVinculada();
		MiListaVinculada ld2= new MiListaVinculada();
		
		ld1.insertarPrincipio(6);
		ld1.insertarPrincipio(5);
		ld1.insertarPrincipio(3);
		ld1.insertarPrincipio(8);
		ld1.insertarPrincipio(100);

		ld2.insertarPrincipio(2);
		ld2.insertarPrincipio(99);
		ld2.insertarPrincipio(11);
		ld2.insertarPrincipio(8);
		ld2.insertarPrincipio(6);
		ld2.insertarPrincipio(5);
		ld2.insertarOrdenado(1);
		ld2.insertarOrdenado(100);
		
		//Armo la lista resultante y la imprimo	
		
		MiListaVinculada l3= new MiListaVinculada();
		ListaRepetidosDesordenados(l3, ld1,ld2);

		MiIterador itl3= l3.iterator();
		while(itl3.hasNext()) {
			System.out.println(itl3.next().getInfo());
		}
		
		
		
		//Armo dos listas ordenadas
		MiListaVinculada lo4= new MiListaVinculada();
		MiListaVinculada lo5= new MiListaVinculada();

		lo4.insertarFinal(5);
		lo4.insertarFinal(6);
		lo4.insertarFinal(7);
		lo4.insertarFinal(8);
		lo4.insertarFinal(10);

		lo5.insertarFinal(1);
		lo5.insertarFinal(3);
		lo5.insertarFinal(5);
		lo5.insertarFinal(7);
		lo5.insertarFinal(8);
		
		//Armo la lista resultante de los elementos repetidos y la imprimo 
		MiListaVinculada l6= new MiListaVinculada();
		ListaRepetidosOrdenados(l6, lo4,lo5);

		MiIterador itl6= l6.iterator();
		while(itl6.hasNext()) {
			System.out.println(itl6.next().getInfo());
		}
		
	}
	

	

}

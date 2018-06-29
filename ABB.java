
	
public class ABB {
		Nodo raiz ;	
		private int cantidad ;
		public ABB(){
			raiz = null;
		}
		
		
		
//*********************************************************************************************************************************************************	
		
		public void insertar (Integer nodo){
			Nodo nuevo = new Nodo(nodo);
			if (this.raiz == null){
				raiz = nuevo;
				cantidad++;
				
			}
			else{
				insertar (raiz,nuevo);
				
			}		
		}
		private void insertar (Nodo nodo , Nodo nuevo){
			if(nuevo.getDato()<nodo.getDato()){//me voy para la izq
				
				if (nodo.izq == null){//pego aca
					nodo.izq = nuevo;
					cantidad++;
				}
				else{
					insertar(nodo.izq, nuevo);
				}
					
			}
			else{ //me voy derecha
				
			if(nuevo.getDato() > nodo.getDato()){	
				if (nodo.der == null){
					nodo.der=nuevo;
					cantidad++;
				}
				else{
					insertar(nodo.der,nuevo);
				}
				
			}
			}
			
				}
		
		
		
//********************************************************************************************************************************************************
		
		public int cantNodos(){
			return (raiz == null) ? 0 : cantNodos(raiz);
			
		}
		
		
		private int cantNodos (Nodo n){
			int cantIzq = (n.izq == null) ? 0 : cantNodos(n.izq); 

			int cantDer = (n.der == null) ? 0 : cantNodos(n.der);
			
			return 1 + cantIzq + cantDer;
			
		}
				
		
//*********************************************************************************************************************************************************	

		
		public int altura(){
				
			if (raiz == null){
				return 0;
			}
			else{
				 return altura (raiz);
			}			
			}			
		private int altura(Nodo nodo){
			int altIzq = (nodo.izq == null) ? 0 : altura(nodo.izq) ;
			int altDer = (nodo.der == null) ? 0 : altura(nodo.der) ;
			return 1 + Math.max(altIzq, altDer);
			}		
		
//*********************************************************************************************************************************************************		
		public boolean balanceado(){
		
			if (raiz == null){
				return true;
			}
			else{
				 return balanceado(raiz);
			}
		}
		
		private boolean balanceado(Nodo nodo) {
			boolean acum = true; 
			int alturaSubDerecho = 0;
			int alturaSubIzquierdo = 0;			
			
			if (nodo.izq != null){
				alturaSubIzquierdo = altura(nodo.izq);
				acum = acum && balanceado(nodo.izq);
			}
			if (nodo.der != null){
				alturaSubDerecho = altura (nodo.der);
				acum = acum && balanceado(nodo.der);
			}			
			return acum = acum && ((alturaSubIzquierdo - alturaSubDerecho) <= 1); 		
		}
		
//*********************************************************************************************************************************************************	
		
		
		public boolean irep(){
			
			
			if (raiz == null){
				return true;
			}
			else{	
				return irep(raiz);
				
			}
				
			}
			
			private boolean irep(Nodo n){	
			
			if( (n.izq != null && n.izq.getDato() > n.getDato() ) || ( n.der != null && n.der.getDato() < n.getDato() )){
				return false;
			}
			
			if(cantNodos(n) != this.cantidad){
				return false;
			}
			
			return true;
			
			
			//return  retorno && ( (n.izq != null && n.izq.getDato() < n.getDato() ) || ( n.der != null && n.der.getDato() > n.getDato() ) ) && (cantNodos(n) == this.cantidad);		
			}		
			public void romperIrep(){		
				cantidad = 0; //Modificacion de la variable interna 		
			}		
		
			
	
		
		
		
		
	//*********************************************************************************************************************************************************	
		
		
		public Integer iesimo (int i){
				if (raiz == null){
					return 0;
				}
				else{
				return iesimo(raiz,i);
				}
				}
					
		private Integer iesimo(Nodo nodo, int i) {		
			int cantNodosIzq = 0;
			if (nodo.izq != null){
				cantNodosIzq = cantNodos(nodo.izq);
			}
			
			if(nodo.izq == null && nodo.der == null && i > 0){
				throw new RuntimeException("El indice ingresado no existe"); 
			}
			
			if(i == cantNodosIzq){
				return nodo.getDato();
			}
			
			if(i < cantNodosIzq){
				return iesimo(nodo.izq,i);
			}
			
			else{
				return iesimo(nodo.der,i-(cantNodosIzq+1));
			}
			
		}


				
			
		
	
		
		@Override
		public String toString(){
			return toString(raiz);
			
		}
		private String toString(Nodo nodo){
			String info = "";
			if (nodo == null){
				return info;
			}
			else{
			
				info = toString(nodo.izq);
				 
				
				
				info = info + "(" + nodo.getDato() + ")";
				
				
				
				info = info + toString(nodo.der);
				
				
				
				
			}
		
			return info
					;
		}
		
		
		
		
		
	
	public static void main(String[] args) {
		ABB ar = new ABB ();
		ar.insertar(8);
		ar.insertar(3);
		ar.insertar(10);
		ar.insertar(1);
		ar.insertar(6);
		ar.insertar(4);
		ar.insertar(7);
		ar.insertar(14);
		ar.insertar(9);
		
		//ar.inorden(ar.raiz);
		
		System.out.println(ar.toString());
		
		
	}

}

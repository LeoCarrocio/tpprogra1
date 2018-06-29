import java.util.ArrayList;

public class Torre 
{
	private ArrayList<Nivel> ListaTorree;
	
	public Torre(int tamaño )
	{
		this.ListaTorree= new ArrayList<Nivel>();
		for (int i = 0; i < tamaño ; i++) 
		{
			Nivel nivel = new Nivel(1,2,3);
			ListaTorree.add(nivel);
			
		}
		
		
		
	}

	public int primerNivelPosible()     //devuelve el primer nivel q puede sacar una pieza de la torre
	{
		int n=-1;
		for(int i=0; i<this.ListaTorree.size()-2; i++) 
		{
			if(this.ListaTorree.get(i).nivelLleno()) 
				return n=i;
			else if(this.ListaTorree.get(i).hayDosPiezas()) 
				return n=i;
		}
		return n;
	}

	

	public int piezaRecomendada(int ni)                           // recomeinda una pieza a sacar
	{
		if(this.ListaTorree.get(ni).nivelLleno())
			return 2;
		else if(this.ListaTorree.get(ni).getPieza1()==1 && 
				this.ListaTorree.get(ni).getPieza2()==2 &&
				this.ListaTorree.get(ni).getPieza3()==0)
			return 1;
		else if (this.ListaTorree.get(ni).getPieza1()==0 &&
				this.ListaTorree.get(ni).getPieza2()==2 &&
				this.ListaTorree.get(ni).getPieza3()==3)
			return 3;
		else if (this.ListaTorree.get(ni).getPieza1()==1 &&
				this.ListaTorree.get(ni).getPieza2()==0 &&
				this.ListaTorree.get(ni).getPieza3()==3)
			return 1;
		return 0;
	}

	public void quitar(int ni, int pieza)                 // pone en 0 a la columana seleccionada 
	{
		if(this.ListaTorree.get(ni).getPieza1()==pieza)  // pregunta a al nivel por la pieza x si es igual a pieza le modifica en 0
			this.ListaTorree.get(ni).setPieza1(0);
		else 
			if(this.ListaTorree.get(ni).getPieza2()==pieza)
			this.ListaTorree.get(ni).setPieza2(0);
		else 
			if(this.ListaTorree.get(ni).getPieza3()==pieza)
			this.ListaTorree.get(ni).setPieza3(0);
	}

	
	public boolean cayo(int nivel, int p)  // devuelve si cayo y se le pasa nivel y la pieza
	{
		int prov=0;
		if(p==2 && this.ListaTorree.get(nivel).getPieza1()==1 &&         // caso 2
				this.ListaTorree.get(nivel).getPieza3()==3)
			prov=50;
		else 
			if((p==1 || p==3) && this.ListaTorree.get(nivel).getPieza2()==2 &&   //caso 1 
				(this.ListaTorree.get(nivel).getPieza3()==3 || this.ListaTorree.get(nivel).getPieza1()==1))
			prov=1*(nivel-this.ListaTorree.size()-2);
		else 
			if( p==2 && (this.ListaTorree.get(nivel).getPieza1()==0 ||  // caso 4
				this.ListaTorree.get(nivel).getPieza3()==0) && ( this.ListaTorree.get(nivel).getPieza1()==1 ||
				this.ListaTorree.get(nivel).getPieza3()==3))
			prov=100;
		else 
			if((p==1 || p==3) && this.ListaTorree.get(nivel).getPieza2()==2 &&   //caso 3 
				(this.ListaTorree.get(nivel).getPieza3()==0 || this.ListaTorree.get(nivel).getPieza1()==0))
			prov=5*(nivel-this.ListaTorree.size()-2);
		
		if(prov>=100)	
			return true;
		else 
			return false;
		
	}
	
	
	
	
	
	
	public void agregarPieza()       // agrega una pieza en la sima o creu una nueva si es necesaria 
	{
		
		int max=this.ListaTorree.size()-1;
		if(this.ListaTorree.get(max).nivelLleno()) 				// pregunto si nivel esta lleno
			{
			Nivel nivelsup= new Nivel(1,0,0);							// creo un nuevo nivel siesta lleno y coloco la pieza en 1
			this.ListaTorree.add(nivelsup);								// cargo el nuevo nivel a la torre
			}
		else 
			if(this.ListaTorree.get(max).getPieza1()==1 && 
				this.ListaTorree.get(max).getPieza2()==0 && 
				this.ListaTorree.get(max).getPieza3()==0)                 // pregunto si la coluna esta vacia 
			{																		  // modifico la colunmna
			this.ListaTorree.get(max).setPieza2(2);
			}
		else 
			if(this.ListaTorree.get(max).getPieza1()==1 && 
				this.ListaTorree.get(max).getPieza2()==2 && 
				this.ListaTorree.get(max).getPieza3()==0) 
			{
			this.ListaTorree.get(max).setPieza3(3);
			}
	}
	
	
	@Override
	public String toString()
	{
		
		StringBuilder impresion = new StringBuilder ();
	
		impresion.append(ListaTorree);
		for (int j = 0; j < impresion.capacity(); j++) 
			{	
			if(impresion.charAt(j) == ',' || impresion.charAt(j) == '[' || impresion.charAt(j) == ']')
				impresion.setCharAt(j,' ');
			}
		
		return " " + impresion.toString();
		
	}
	
	
}

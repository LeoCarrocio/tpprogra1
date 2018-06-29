
public class Jenga 
{

	Torre torre;
	String jug1;
	String jug2;
	int cantidadNiveles;
	String turno;
    boolean ganador;
	
	public Jenga(int nivel , String j1 , String j2 )
	{	
		this.cantidadNiveles=nivel;
		this.jug1=j1;
		this.jug2=j2;	
		torre=new Torre(nivel);
		this.turno="a";
		this.ganador=true;
	}
	
	public void jugar() 
	{
	this.turno=this.jug1;                         // a turno le asigno un jugador uno
	int ni=this.torre.primerNivelPosible();       // obtengo el primer nivel posible
	int pieza= this.torre.piezaRecomendada(ni);   // obtengo una pieza recomendada
	if (ni!=-1)                                    // si el nivel existe 
		{
		this.torre.quitar(ni, pieza);            // quito el nivel y la pieza recomendada
		if (this.torre.cayo(ni, pieza))          // pregunto si cayo
		    {
			this.ganador=false;                                 // si cae hay un ganador 
			System.out.print("el ganador es "+ this.jug2);
		    }
		else 
			{
			this.torre.agregarPieza();           // si no se cae coloco la pieza arriva
			this.turno=this.jug2;                // juga jugador dos
			ni=this.torre.primerNivelPosible();
			pieza= this.torre.piezaRecomendada(ni);
			
			if (ni!=-1)                          
				{
				this.torre.quitar(ni, pieza);
				if (this.torre.cayo(ni, pieza))
				    {
					this.ganador=false;
					System.out.print("el ganador es "+ this.jug1);
				    }
				else 
				    {
					this.torre.agregarPieza();
				    }
				}
			else
				System.out.println("no hay nivel para jugar");
			}
		}
	 else
		System.out.println("no hay nivel para jugar");
	
	}


	public int altura() {
		
		int altura= this.cantidadNiveles;
		
		return  altura;
	}


	
	@Override
	public String toString()
	{
		
		StringBuilder impresion = new StringBuilder ();
	
		impresion.append(torre);
		for (int j = 0; j < impresion.capacity(); j++) 
			{	
			if(impresion.charAt(j) == ',' || impresion.charAt(j) == '[' || impresion.charAt(j) == ']')
				impresion.setCharAt(j,' ');
			}
		
		return  impresion.toString();
		
	}


	
	

	public static void main(String[] args) 
	{
		Jenga unJenga= new Jenga(5,"leo","santy");
		
		while(unJenga.ganador) 
		{
			unJenga.jugar();
			System.out.println(unJenga);
		}
		
		System.out.println(unJenga.ganador);
		
	}

	
}

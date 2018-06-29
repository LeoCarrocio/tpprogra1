
public class Nivel 
{
	private Integer pieza1;
	private Integer pieza2;
	private Integer pieza3;
	

	
	 public Nivel(Integer primerPilar , Integer segundoPilar , Integer tercerPilar)
	 {
		 this.pieza1=primerPilar;
		 this.pieza2=segundoPilar;
		 this.pieza3=tercerPilar;
		 
	 }
	
	 public Nivel() 
	 {
		 this.pieza1=null;
		 this.pieza2=null;
		 this.pieza3=null;
		 
	 }

	public Integer getPieza1() {
		return pieza1;
	}

	public void setPieza1(Integer pieza1) {
		this.pieza1 = pieza1;
	}

	public Integer getPieza2() {
		return pieza2;
	}

	public void setPieza2(Integer pieza2) {
		this.pieza2 = pieza2;
	}

	public Integer getPieza3() {
		return pieza3;
	}

	public void setPieza3(Integer pieza3) {
		this.pieza3 = pieza3;
	}

	
	
	public boolean nivelLleno()   // verifica si esta lleno el nivel
	{
		if (this.getPieza1()==1 && this.getPieza2()==2 && this.getPieza3()==3)
			return true;
		else
		   return false;
	}

	public boolean hayDosPiezas()          //devuelde una de las tres combinaciones posibles
	{
		if (this.getPieza1()!=0 && this.getPieza2()!=0 ||  
			this.getPieza3()!=0 && this.getPieza2()!=0 ||
			this.getPieza1()!=0 && this.getPieza3()!=0)
			return true;
		return false;
	}

	@Override
	public String toString()
	{
	return this.pieza1.toString() + " " + this.pieza2.toString() + " " + this.pieza3.toString() + "\n"  ;
	}

	 





}

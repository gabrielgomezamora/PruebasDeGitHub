
class Beca{
	private int sueldo;
	private int mes1;
	private int mes2;
	
	public Beca(int sueldo,int mes1,int mes2){
		this.mes1=mes1;
		this.mes2=mes2;
		this.sueldo=sueldo;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	public int getMes1() {
		return mes1;
	}

	public void setMes1(int mes1) {
		this.mes1 = mes1;
	}

	public int getMes2() {
		return mes2;
	}

	public void setMes2(int mes2) {
		this.mes2 = mes2;
	}
	
}

class Examen{
	public static void main(String [] args){
		Beca [] becas={new Beca(200,1,10),new Beca(100,8,12),new Beca(150,5,6),new Beca(300,1,4)};
		int [] estado=new int [becas.length];
		for(int i=0;i<estado.length;i++)
			estado[i]=-1;
		int [] mejorSolucion=new int [becas.length];	
		calcular(becas,estado,0,mejorSolucion);
		mostrar(mejorSolucion);
	
	}
	
	public static  void calcular(Beca [] becas,int [] estado,int etapa,int [] mejorSolucion){
		if(etapa==estado.length){
			if(esMejor(becas,estado,mejorSolucion)){
				System.arraycopy(estado,0, mejorSolucion, 0, estado.length);
				
			}
			mostrar(mejorSolucion);
		}
		else{
			estado[etapa]=0;
			calcular(becas,estado,etapa+1,mejorSolucion);
			Beca candidato=becas[etapa];
			if(esSolucion(becas,estado,candidato)){
				estado[etapa]=1;
				calcular(becas,estado,etapa+1,mejorSolucion);
			}
		}
	}
	public static boolean esSolucion(Beca [] becas,int [] estado,Beca candidato){
		boolean sol=true;
		int mes1=candidato.getMes1();
		int mes2=candidato.getMes2();
		for(int i=0;i<estado.length;i++){
			if(estado[i]==1){
				if(becas[i].getMes2()>=mes1 && becas[i].getMes1()<=mes2){
					sol=false;
				}
			}
		}
		return sol;
	}
	public static  int beneficio(Beca [] becas,int [] estado){
		int suma=0;
		for(int i=0;i<estado.length;i++){
			if(estado[i]==1){
				suma+=(becas[i].getSueldo()*(becas[i].getMes2()-becas[i].getMes1()));
			}
		}
		return suma;
	}
	public static boolean esMejor(Beca [] becas,int [] estado,int [] mejorSolucion){
		return beneficio(becas,estado) > beneficio(becas,mejorSolucion);
	}
	public static void mostrar(int [] sol){
		for(int i=0;i<sol.length;i++){
			System.out.print(sol[i]);
		}
		System.out.println();
	}
}
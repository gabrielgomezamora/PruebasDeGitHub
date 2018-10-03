
public class mochila {
	public int[] back1(){
		int[] sol=new int[dim()];
		back1(0,new int[dim()],sol);
		System.out.println("sol back1..\n"+mostrarBack(sol));
		return sol;
	}
	private void back1(int etapa,int[] actual,int[] sol){
		if(etapa==actual.length){
			if(mejor(actual,sol)) System.arraycopy(actual, 0, sol, 0, actual.length);
		}
		else{
			for(ints=0;s<=1;s++){
				if(factible(actual,etapa,s)){//si se puede
					actual[etapa]=s;
					back1(etapa+1,actual,sol);
				}
		//actual[etapa] no hace falta borrar
			}
		}
	}
	
	private boolean mejor(int[] a,int[] s ){
		return valor(a)>valor(s);
	}
	private int valor(int[] m,int[] estado){
		int v=0;
		for(int n=0;n<estado.length.;n++) v=v+mochila[1][n]*m[n];
		return v;
	}
		privatebooleanfactible(int[] actual,intetapa,ints){
		intcap=0;
		for(intn=0;n<etapa;n++) cap=cap+mochila[0][n]*actual[n];
		cap=cap+s*mochila[0][etapa];
		returncap<=capacidad;
		}
}

import java.util.Random;

class P {
	public static void main(String [] args){
		int [] elementos={1,3,5,2};
		int [] mejor=daMejorSolucion(elementos,8);
		
		for(int i=0;i<mejor.length;i++)
			System.out.print(mejor[i]);
	}
	static int[] daMejorSolucion(int[] elementos, int M){
		int[] solucion=new int[elementos.length];
		int[] mejor=new int[elementos.length];
		for (int m=0; m<elementos.length; m++)
			mejor[m]=1;
		return calcularMejorSumas(elementos, solucion, 0, M, 0,mejor);
	}
	private static int numElementos(int[] estado){
		int n=0;
		for (int i=0; i<estado.length; i++)
			if (estado[i]==1)
				n++;
		return n;
	}
	
	static int [] calcularMejorSumas(int[] elementos, int[] estado, int etapa, int M, int suma, int[] mejor){
		if(etapa==estado.length){
			
			if(suma==M){
				if(numElementos(estado)<numElementos(mejor)){
					System.out.println("solucion");
					for (int m=0; m<estado.length; m++){
						mejor[m]=estado[m];
						System.out.print(mejor[m]);
					}
					System.out.println();
				}
			}
		}
		else{//incluimos elementos[etapa] en la solución
			if(suma+elementos[etapa]<=M){
				estado[etapa]=1;
				calcularMejorSumas(elementos, estado, etapa+1, M,suma+elementos[etapa], mejor);
			}
		// no incluimos elementos[etapa] en la solución
			estado[etapa]=0;
			calcularMejorSumas(elementos, estado, etapa+1, M, suma,	mejor);
		}
		return mejor;
	}
}

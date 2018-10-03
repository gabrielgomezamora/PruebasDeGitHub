import java.util.Arrays;
class Principal {
	public static void main(String[] args) {
		int[] a = { 14, 27, 23, 5 , 12};
		mergeSort(a,0,a.length-1);
		for(int i=0;i<a.length;i++){
		System.out.print(a[i]+" ");
		}
	}

	public static int divide(int[] v, int li, int ls) {
		int pivote = v[li];
		int izq = li + 1;
		int der = ls;
		int aux = 0;
		do {
			while (v[izq] <= pivote && izq < ls)
				izq++;
			while (v[der] > pivote && der > li)
				der--;
			if (izq < der) {

				aux = v[izq];
				v[izq] = v[der];
				v[der] = aux;

				izq++;
				der--;
			}
		} while (izq < der);
		// intercambiamosel pivoteporx[der]
		if (der <= izq) {
			aux = v[izq];
			v[izq] = v[der];
			v[der] = aux;
		}
		return der;
	}

	public static int[] quickSort(int[] vector, int izquierda, int derecha) {
		int pivote = vector[izquierda];
		int i = izquierda;
		int j = derecha;
		int auxIntercambio;
		while (i < j) {
			while (vector[i] <= pivote && i < j) {
				i++;
			}
			while (vector[j] > pivote) {
				j--;
			}
			if (i < j) {
				auxIntercambio = vector[i];
				vector[i] = vector[j];
				vector[j] = auxIntercambio;
			}
		}
		vector[izquierda] = vector[j];
		vector[j] = pivote;
		if (izquierda < j - 1) {
			vector = quickSort(vector, izquierda, j - 1);
		}
		if (j + 1 < derecha) {
			vector = quickSort(vector, j + 1, derecha);
		}
		return vector;
	}

	public static int encontrarElemento(int elemento, int[] vector) {
		int posicion = -1;
		int i = 0, j = vector.length - 1, encontrado = 0;
		while ((i < j) && (encontrado == 0)) {
			int k = (i + j) / 2;
			if (elemento == vector[k]) {
				encontrado = 1;
				posicion = k;
			} else if (elemento < vector[k])
				j = k - 1;
			else
				i = k + 1;

		}
		return encontrado;
	}

	public static int busqueda(int[] a, int x, int inicio, int fin) {
		int encontrado = 0;

		if (inicio == fin) {
			if (x == a[inicio]) {
				encontrado = 1;

			}
			System.out.println("La posicion del elemento encontrado es: " + inicio);

		} else {
			int k = (inicio + fin) / 2;
			if (x == a[k]) {
				encontrado = 1;
				System.out.println("La posicion del elemento encontrado es: " + k);
			} else if (x < a[k]) {
				encontrado = busqueda(a, x, inicio, k - 1);
			} else {
				encontrado = busqueda(a, x, k + 1, fin);
			}
		}
		return encontrado;

	}
	public static void  mergeSort(int[]v,int li,int ls){
		if(li<ls){
			int med= (li+ls)/2;
			mergeSort(v,li,med);
			mergeSort(v,med+1,ls);
			merge(v,li,med,ls);
		}
	}
	public static void merge(int A[],int izq, int m, int der){
		   int i, j, k;
		   int [] B = new int[A.length]; //array auxiliar
		   for (i=izq; i<=der; i++) //copia ambas mitades en el array auxiliar
		             B[i]=A[i];

		             i=izq; j=m+1; k=izq;
		             while (i<=m && j<=der) //copia el siguiente elemento más grande
		             if (B[i]<=B[j])
		                     A[k++]=B[i++];
		             else
		                     A[k++]=B[j++];
		             while (i<=m) //copia los elementos que quedan de la
		                           A[k++]=B[i++]; //primera mitad (si los hay)
		 }
 
}

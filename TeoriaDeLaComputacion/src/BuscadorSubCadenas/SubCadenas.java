package BuscadorSubCadenas;

import java.util.Scanner;

public class SubCadenas {

	public static void main(String[] args) {
		
		char caracter=' ';	
		
		String subCadena="", texto= "El analizador lexico es la primera fase de "
				+ "un compilador. Su principal funcion consiste en leer los"
				+ "caracteres de entrada y elaborar como salida una secuencia de"
				+ "componentes lexicos que utiliza el analizador sintactico para"
				+ "hacer el analisis. Esta interaccion suele aplicarse convirtiendo"
				+ "el analizador lexico en una subrutina del analizador sintactico."
				+ "como el analizador lexico es la parte del compilador que lee"
				+ "el programa fuente, tambien puede analizar ciertas funciones"
				+ "secundarias en la interfaz del usuario." ;
		int posicion =0, coincidencias=0;
		Scanner lector = new Scanner(System.in);		
		
		System.out.println("Capture la cadena a analizar");
		subCadena=lector.nextLine();	
		
		char[] arreglo = new char[subCadena.length()];
		
		for(int i=0; i<subCadena.length(); i++){
			caracter=subCadena.charAt(i);			
			arreglo[i]=caracter;
		}
		
		for(int i=0; i<texto.length(); i++){
			caracter=texto.charAt(i);			
			if(caracter == arreglo[posicion]){
				posicion++;
				if(posicion==subCadena.length()){
					coincidencias++;
					posicion=0;
				}
			}
			else{
				posicion=0;
			}
		}
		System.out.println("Las coincidencias encontradas con la subcadena: "
				+ subCadena + " fueron: "+coincidencias);
	}	
}

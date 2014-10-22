package MatrizPractica;

import java.util.Scanner;

public class Practica {

	public static void main(String[] args) {	
		
		char caracter=' ';
		String palabra="";
		int estado =0;
		Scanner lector = new Scanner(System.in);		
		
		System.out.println("Capture la cadena a analizar");
		palabra=lector.nextLine();		
		
		for(int i=0; i<palabra.length(); i++){
				caracter=palabra.charAt(i);
				
			if(caracter !=' '){
				switch(estado){
				case 0:
					if(caracter =='0')
						estado = 1;
					else
						estado = 2;
					break;
				case 1:
					if(caracter =='0')
						estado = 0;
					else
						estado = 3;
					break;
				case 2:
					if(caracter =='0')
						estado = 3;
					else
						estado = 0;
					break;
				case 3:
					if(caracter =='0')
						estado = 2;
					else
						estado = 1;
					break;
				}
			}
			else{
				if(estado==1)
					System.out.println("Cadena Valida");
				else
					System.out.println("Cadena no valida");
				
				estado=0;
			}
		}
		
		if(estado==1)
			System.out.println("Cadena Valida");
		else
			System.out.println("Cadena no valida");
	}

}

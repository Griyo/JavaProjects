package Matriz;

public class Matriz1 {

	public static void main(String[] args) {
		
		int matriz[][] = new int [4][3];
		char caracter;
		int posicion =0,contador=0;
		
		matriz[0][0]=0;	matriz[0][1]=1;		matriz[0][2]=0;
		matriz[1][0]=1;	matriz[1][1]=1;		matriz[1][2]=2;
		matriz[2][0]=2;	matriz[2][1]=3;		matriz[2][2]=0;
		matriz[3][0]=3;	matriz[3][1]=1;		matriz[3][2]=2;		
		
		String palabra = "aaaaaaab";
		int longi = palabra.length();
		
		for(int i = 0;i<longi;i++){
		caracter=palabra.charAt(i);
		

		
		if(caracter=='a'){
			posicion = matriz[posicion][1];					
				do{			// Pa buscar la posicion
					if(matriz[0][contador]==posicion)
						posicion = matriz[0][contador];		//Encontro la posicion				
					contador++;					
				}while(posicion==matriz[0][contador]);
				contador=0;					
		}		
		else{			//Pa cuando sea B
				posicion = matriz[posicion][2];					
					do{		// Pa buscar la posicion			
						if(matriz[0][contador]==posicion)
							posicion = matriz[0][contador];	 //Encontro la posicion				
						contador++;					
					}while(posicion==matriz[0][contador]);
					contador=0;				
			}		
		} 		
		// Checando si es valida o no
		if(matriz[posicion][0]==3) 
			System.out.println("Cadena Valida");
		else
			System.out.println("Cadena no valida");		
	}
}

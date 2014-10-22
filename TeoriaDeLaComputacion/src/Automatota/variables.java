package Automatota;

public class variables {

	public static void main(String[] args) {

		char caracter;
		String palabra="cade9nita";
		int estado=0;
		int contador=0;
		
		
			
			do{
				caracter=palabra.charAt(contador);
				switch(estado){
					case 0:
						if(Character.isLetter(caracter))
							estado=1;
						if(Character.isDigit(caracter))
							estado=2;
						if(Character.isLetter(caracter)==false)
							estado=2;
						if(Character.isLetter(caracter)==false && Character.isDigit(caracter)==false)
							estado=2;
						
						break;
					case 1:
						if(Character.isLetter(caracter))
							estado=1;
						if(Character.isDigit(caracter))
							estado=1;
						if(Character.isLetter(caracter)==false && Character.isDigit(caracter)==false)
							estado=2;
						break;
					case 2:
						if(Character.isLetter(caracter))
							estado=2;
						if(Character.isDigit(caracter))
							estado=2;
						if(Character.isLetter(caracter)==false)
							estado=2;
						if(Character.isLetter(caracter)==false && Character.isDigit(caracter)==false)
							estado=2;
					break;
					
				}
				contador++;
				if(estado==2){
					contador=palabra.length();
				}
				
			}while(contador != palabra.length() );
			if(estado==1){
				System.out.println("cadena valida");
			}else{
				System.out.println("cadena no valida");
			}
				
	}
	
	

}

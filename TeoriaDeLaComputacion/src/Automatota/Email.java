package Automatota;

public class Email {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char caracter;
		String palabra="a_1@f.g";
		int estado=0;
		int contador=0;
		
		do{
			caracter=palabra.charAt(contador);

			switch(estado){
			case 0:
				if(Character.isLetter(caracter))
					estado=14;
				else
					estado=2;
				break;
			case 14:
				if(Character.isLetter(caracter)||Character.isDigit(caracter))
					estado=14;
				if(caracter=='.'||caracter=='_')
					estado=15;
				if(caracter=='@')
					estado=16;
				if(Character.isLetter(caracter)==false && caracter !='@'
						&& Character.isDigit(caracter)==false && caracter!='.' 
						&& caracter !='_')
					estado=2;
				
				
				break;
			case 15:
				if(Character.isLetter(caracter) || Character.isDigit(caracter))
					estado=14;
				else
					estado=2;
				break;
			case 16:
				if(Character.isLetter(caracter))
					estado=17;
				else
					estado=2;
				
				break;
			case 17:
				if(Character.isLetter(caracter))
					estado=17;
				if(caracter=='.')
					estado=18;
				if(Character.isLetter(caracter)==false && caracter!='.')
					estado=2;
				
				break;
			case 18:
				if(Character.isLetter(caracter))
					estado=19;
				else
					estado=2;
				
				break;
			case 19:
				if(Character.isLetter(caracter))
					estado=19;
				else
					estado=2;
				
				break;
				
			
			}
			
			
			contador++;
			if(estado==2){
				contador=palabra.length();
			}
			
		}while(contador != palabra.length() );
		
		if(estado==19){
			System.out.println("cadena valida");
		}else{
			System.out.println("cadena no valida");
		}
	}

}

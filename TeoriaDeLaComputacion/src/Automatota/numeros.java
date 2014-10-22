package Automatota;

public class numeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char caracter;
		String palabra="-8.5EE";
		int estado=0;
		int contador=0;
		
		do{
			caracter=palabra.charAt(contador);
			
			switch(estado){
			case 0:
				if(caracter=='+' || caracter =='-')
					estado=3;
				if(Character.isDigit(caracter))
					estado=4;
				if(caracter=='.')
					estado=2;
				if(caracter=='E')
					estado=2;
				if(caracter!='E' && Character.isLetter(caracter)==false && 
						Character.isDigit(caracter)==false && caracter!='.' &&
						caracter!='+' && caracter!='-')
					estado=2;
				break;
			case 3:
				if(caracter=='+' || caracter =='-')
					estado=2;
				if(Character.isDigit(caracter))
					estado=4;
				if(caracter=='.')
					estado=2;
				if(caracter=='E')
					estado=2;
				if(caracter!='E' && Character.isLetter(caracter)==false && 
						Character.isDigit(caracter)==false && caracter!='.' &&
						caracter!='+' && caracter!='-')
					estado=2;
				break;
			case 4:
				if(caracter=='+' || caracter =='-')
					estado=2;
				if(Character.isDigit(caracter))
					estado=4;
				if(caracter=='.')
					estado=5;
				if(caracter=='E')
					estado=7;
				if(caracter!='E' && Character.isLetter(caracter)==false && 
						Character.isDigit(caracter)==false && caracter!='.' &&
						caracter!='+' && caracter!='-')
					estado=2;
				break;
			case 5:
				if(caracter=='+' || caracter =='-')
					estado=2;
				if(Character.isDigit(caracter))
					estado=6;
				if(caracter=='.')
					estado=2;
				if(caracter=='E')
					estado=2;
				if(caracter!='E' && Character.isLetter(caracter)==false && 
						Character.isDigit(caracter)==false && caracter!='.' &&
						caracter!='+' && caracter!='-')
					estado=2;
				break;
			case 6:
				if(caracter=='+' || caracter =='-')
					estado=2;
				if(Character.isDigit(caracter))
					estado=6;
				if(caracter=='.')
					estado=2;
				if(caracter=='E')
					estado=7;
				if(caracter!='E' && Character.isLetter(caracter)==false && 
						Character.isDigit(caracter)==false && caracter!='.' &&
						caracter!='+' && caracter!='-')
					estado=2;
				break;
			case 7:
				if(caracter=='+' || caracter =='-')
					estado=8;
				if(Character.isDigit(caracter))
					estado=9;
				if(caracter=='.')
					estado=2;
				if(caracter=='E')
					estado=2;
				if(caracter!='E' && Character.isLetter(caracter)==false && 
						Character.isDigit(caracter)==false && caracter!='.' &&
						caracter!='+' && caracter!='-')
					estado=2;
				break;
			case 8:
				if(caracter=='+' || caracter =='-')
					estado=2;
				if(Character.isDigit(caracter))
					estado=9;
				if(caracter=='.')
					estado=2;
				if(caracter=='E')
					estado=2;
				if(caracter!='E' && Character.isLetter(caracter)==false && 
						Character.isDigit(caracter)==false && caracter!='.' &&
						caracter!='+' && caracter!='-')
					estado=2;
				break;
			case 9:
				if(caracter=='+' || caracter =='-')
					estado=2;
				if(Character.isDigit(caracter))
					estado=9;
				if(caracter=='.')
					estado=2;
				if(caracter=='E')
					estado=2;
				if(caracter!='E' && Character.isLetter(caracter)==false && 
						Character.isDigit(caracter)==false && caracter!='.' &&
						caracter!='+' && caracter!='-')
					estado=2;
				break;
			}
			
			
			
			contador++;
			if(estado==2){
				contador=palabra.length();
			}
			
		}while(contador != palabra.length() );
		
		if(estado==4 || estado ==6 || estado ==9){
			System.out.println("cadena valida");
		}else{
			System.out.println("cadena no valida");
		}
		
	}

}

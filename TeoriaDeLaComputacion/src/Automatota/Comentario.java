package Automatota;

public class Comentario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char caracter;
		String palabra="/*wer*/";
		int estado=0;
		int contador=0;
		
		do{
			caracter=palabra.charAt(contador);
		
			switch(estado){
			case 0:
				if(caracter=='/')
					estado=10;
				else
					estado=2;
				break;
			case 10:
				if(caracter=='*')
					estado=11;
				else
					estado=2;
				break;
			case 11:
				if(caracter!='*')
					estado=11;
				else
					estado=12;
				break;
			case 12:
				if(caracter!='*')
					estado=11;
				if(caracter=='/')
					estado=13;
				if(estado=='*')
					estado=12;
				break;	
			case 13:
				estado=2;
				break;
			}
			contador++;
			if(estado==2){
				contador=palabra.length();
			}
			
		}while(contador != palabra.length() || estado==2 );
		
		if(estado==13){
			System.out.println("cadena valida");
		}else{
			System.out.println("cadena no valida");
		}
	}

}

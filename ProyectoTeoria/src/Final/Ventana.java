package Final;

import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class Ventana extends JFrame {
	
	JLabel labelSQL,labelExit;
	JTextArea inputSQL,inputExit;
	JButton boton;
	ArrayList numToken = new ArrayList();
	ArrayList numLinea = new ArrayList();
	ArrayList resArrayList = new ArrayList();
	ArrayList delArrayList = new ArrayList();
	ArrayList opeArrayList = new ArrayList();
	ArrayList ideArrayList = new ArrayList();
	ArrayList conArrayList = new ArrayList();
	boolean encontrar = false;
	JTable tabla;
	JTableHeader header;
	ImagePanel panel;
	JScrollPane jscroll;
	DefaultTableModel modelo;
	
	
	public Ventana(){
		
		inputSQL = new JTextArea();
		boton = new JButton("Analizar");
		tabla = new JTable();
		panel = new ImagePanel();
		header=tabla.getTableHeader();
		header.setBackground(Color.YELLOW);
		jscroll =new JScrollPane(tabla);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        modelo= new DefaultTableModel(null,getColumnas());

		setLayout(null);
		
		inputSQL.setBounds(10, 50, 300, 250);
		tabla.setBounds(470, 50, 400, 700);
		panel.setBounds(0, 0, 900, 600);
		boton.setBounds(50, 350, 150, 20);
		jscroll.setBounds(10, 10, 50, 50);
		
	
		add(inputSQL);
		add(boton);
		add(panel);
		add(tabla);
		add(jscroll);
		
		

		
		
		setArrays();
		
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String cadena=inputSQL.getText();
				while (cadena.charAt(cadena.length()-1)==' '){
					cadena=cadena.substring(0,cadena.length()-1);
				}
				ArrayList tks = new ArrayList();
				tks=analizarCadena(cadena);
				
				tks=analizarLista(tks);
				modelo.setColumnCount(0);
				modelo.setRowCount(0);
				modelo.addColumn("Numero");
				modelo.addColumn("Linea");
				modelo.addColumn("Token");
				modelo.addColumn("Codigo");
				modelo.addColumn("Tipo");
				
				for(int k=0;k<tks.size();k++){
					Token t = new Token();
					t=(Token) tks.get(k);
					Object[] row = new Object[5];
					row[0]=t.getNum();
					row[1]=t.getLinea();
					row[2]=t.getCadena();
					row[3]=t.getCodigo();
					row[4]=t.getTipo();
					modelo.addRow(row);
				}

				tabla.setModel(modelo);
				
			}

		});
		setSize(900,600);
		setLocation(200,40);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		this.setResizable(true);
	}
	
	public ArrayList analizarLista(ArrayList lista){
		
		for(int i=0; i<lista.size(); i++){
			Token token = (Token) lista.get(i);
			Renglon renglon = new Renglon();
			int r=0;
			
			if(token.getCadena().length()>1){
				if(Character.isLetter(token.getCadena().charAt(0))){
					while(resArrayList.size()>r && encontrar==false){
						renglon=(Renglon) resArrayList.get(r);
						if(renglon.getCadena().toLowerCase().equalsIgnoreCase(token.getCadena())){
							token.setTipo(1);
							token.setCodigo(renglon.getId());
							encontrar=true;
						}			
						r++;
					}
					if(encontrar==false){
						token.setTipo(4);
						token.setCodigo(ideArrayList.size()+61);
						ideArrayList.add(new Renglon(token.getCodigo(),token.getCadena()));
					}
					encontrar=false;
				}
				else{
					token.setTipo(9);
					token.setCodigo(9);
				}

			}
			else{
				if(!token.getCadena().equals("'")){
					for(int j=0;j<opeArrayList.size();j++){
						renglon=(Renglon) opeArrayList.get(j);

						if(token.getCadena().equals(renglon.getCadena())){
							token.setCodigo(renglon.getId());
							token.setTipo(3);
						}
					}
					for(r=0;r<delArrayList.size();r++){
						renglon=(Renglon) delArrayList.get(r);

						if(token.getCadena().equals(renglon.getCadena())){
							token.setCodigo(renglon.getId());
							token.setTipo(2);							
						}
						
					}					
				}
				else{
					token.setCodigo(24);
					token.setTipo(2);
					i++;
					token = (Token) lista.get(i);
					token.setTipo(5);
					token.setCodigo(conArrayList.size()+71);
					renglon.setCadena(token.getCadena());
					renglon.setId(conArrayList.size()+71);
					conArrayList.add(renglon);
					i++;
					token = (Token) lista.get(i);
					token.setCodigo(24);
					token.setTipo(2);
					}				
			}
		}
		return lista;

	}
	
	public ArrayList analizarCadena(String cadena){
		String palabra="";
		int linea=1,num=0;
		ArrayList token = new ArrayList();
		int contador=0;

		
		for( int i=0; i< cadena.length();i++){			
			char c = cadena.charAt(i);	

				while((Character.isLetterOrDigit(c) || c=='#') && i!=cadena.length()){
					c = cadena.charAt(i);
					if((Character.isLetter(c) || Character.isDigit(c)) && i!=cadena.length()|| c=='#'){
					palabra+=c;
					i++;
					}
				}
				if(palabra!="" && c!='\t' && c!='\r'){
					num++;
					token.add(new Token (palabra,linea,num));
				}
				
				if(c!='\n' && c!=' ' && c!='\t'&& c!='\r'){
					num++;
					token.add(new Token(Character.toString(c),linea,num));
				}
				
				if( c==' ' || c=='\n'){
					switch (c){
					case ' ':

						break;
					case '\n':
						linea++;
						break;
					}
				}
				
				palabra="";
			}		
		return token;	
	}
	
	public class Token{
		String cadena;
		int linea;
		int num;
		int tipo;
		int codigo;
		
		public Token(String cadena, int linea,int num,int tipo, int codigo){
			this.cadena=cadena;
			this.linea=linea;
			this.num=num;
			this.tipo=tipo;
			this.codigo=codigo;
			
		}
		
		public Token(String cadena, int linea,int num){
			this.cadena=cadena;
			this.linea=linea;
			this.num=num;			
		}
		
		public Token(){

		}
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}

		public String getCadena() {
			return cadena;
		}

		public void setCadena(String cadena) {
			this.cadena = cadena;
		}

		public int getLinea() {
			return linea;
		}

		public void setLinea(int linea) {
			this.linea = linea;
		}

		public int getTipo() {
			return tipo;
		}

		public void setTipo(int tipo) {
			this.tipo = tipo;
		}

		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}		
		
		
	}
	
	public class Renglon {
		
		int id;
		String cadena;
		
		public Renglon(int id, String cadena){
			this.id=id;
			this.cadena=cadena;
		}
		
		public Renglon(){
			
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCadena() {
			return cadena;
		}

		public void setCadena(String cadena) {
			this.cadena = cadena;
		}
		
		

	}
	
	private String[] getColumnas()
    {
		  
        String columna[]=new String[]{"Numero","Linea","Token","Tipo","Codigo"};
		  return columna;
    }
	
	public void setArrays(){
		resArrayList.add(new Renglon(1,"select"));
		resArrayList.add(new Renglon(2,"from"));
		resArrayList.add(new Renglon(3,"where"));
		resArrayList.add(new Renglon(4,"distinct"));
		resArrayList.add(new Renglon(5,"order"));
		resArrayList.add(new Renglon(6,"by"));
		resArrayList.add(new Renglon(7,"and"));
		resArrayList.add(new Renglon(8,"in"));
		resArrayList.add(new Renglon(9,"or"));
		resArrayList.add(new Renglon(10,"qwertyuiop"));
		
		delArrayList.add(new Renglon(21,","));
		delArrayList.add(new Renglon(22,"#"));
		delArrayList.add(new Renglon(23,"."));
		delArrayList.add(new Renglon(24,"'"));
		delArrayList.add(new Renglon(25,"("));
		delArrayList.add(new Renglon(26,")"));
		delArrayList.add(new Renglon(27,";"));
		delArrayList.add(new Renglon(28,"_"));


		opeArrayList.add(new Renglon(41,"+"));
		opeArrayList.add(new Renglon(42,"-"));
		opeArrayList.add(new Renglon(43,"*"));
		opeArrayList.add(new Renglon(44,"/"));
		opeArrayList.add(new Renglon(45,"="));
		opeArrayList.add(new Renglon(46,">"));
		opeArrayList.add(new Renglon(46,"<"));
	}
}


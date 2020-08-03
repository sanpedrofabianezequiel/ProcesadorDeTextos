package graficos;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.StyledEditorKit.FontFamilyAction;
import javax.swing.text.StyledEditorKit.ItalicAction;

public class ProcesadorDeTextosOptimizado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoProcesador miMarco=new MarcoProcesador();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
	}

}

class MarcoProcesador extends JFrame{
	public MarcoProcesador() {	//Constructor
		setTitle("Procesador de Textos San Pedro Ezequiel");
		setBounds(500, 300, 550, 400);
		add(new LaminaProcesador());
	
	}
}
class LaminaProcesador extends JPanel{ //Constructor
	
		private JTextPane areaDeTexto;	//Propiedades: Texto de escritura
		private JMenu fuentes,estilos,tamaños; //barra Principal con sub-menus
		private Font  letras;					//Objeto letra que vamos a obtener en un momento Determinado!!					
	

	public LaminaProcesador() {	//Constructor
			//1 Determinamos la distribucion de la Lamina Principal
			setLayout(new BorderLayout());
			//2 Agregamos una lamina secundaria en la Parte norte de la lamina Principal
			JPanel laminaNorte=new JPanel();
			//3 Agregamos un MenuBar  a la lamina secundaria + los JMenu
			fuentes=new JMenu("Fuente");
				estilos=new JMenu("Estilo");
					tamaños=new JMenu("Tamaño");
			JMenuBar barraMenuBar=new JMenuBar();
					
			
			//------------------------------
			//Metodo Creador de subMenues+escuchadores+editores
			//Fuentes:
					MenusDinamicos("Arial", "Fuente", "Arial", Font.PLAIN, 10);
						MenusDinamicos("Courier", "Fuente", "Courier", Font.PLAIN, 10);
							MenusDinamicos("Verdana", "Fuente", "Verdana", Font.PLAIN, 10);
			//Estilos:
					MenusDinamicos("Negrita", "Estilo", "", Font.BOLD, 10);
						MenusDinamicos("Cursiva", "Estilo", "", Font.ITALIC, 10);
			//Tamaño:
					MenusDinamicos("12", "Tamaño", "", Font.PLAIN, 12);
						MenusDinamicos("16", "Tamaño", "", Font.PLAIN, 16);
							MenusDinamicos("20", "Tamaño", "", Font.PLAIN, 20);
								MenusDinamicos("24", "Tamaño", "", Font.PLAIN, 24);
			//------------------------------
			barraMenuBar.add(fuentes);
				barraMenuBar.add(estilos);
					barraMenuBar.add(tamaños);
				laminaNorte.add(barraMenuBar);
					add(laminaNorte,BorderLayout.NORTH);
			//------------------------------Agregamos una zona de textArea o are para escribir
			areaDeTexto=new JTextPane();
			add(areaDeTexto,BorderLayout.CENTER);
	}
	
	//--------------------------------
	//Metodo Creador de subMenues+escuchadores+editores
	public void MenusDinamicos(String rotuloAInsertar,String rotuloDisparador,String letraRecibida,int estiloRecibido,int tamañoRecibido) {
		//Declaramos un JMenuItem para crearlo en base a los parametros recibidos
			//Parametros del Nuevo Item va el Nombre o el ROTULO que quiero ver
		JMenuItem  nuevoItem=new JMenuItem(rotuloAInsertar);
		
			if (rotuloDisparador=="Fuente") {
				fuentes.add(nuevoItem);	//Al rotuloDisparador le asignamos un nuevo ITEM
						//Setiamos la funcionalidad de este Nuevo Item
						// el segundo paramatro DEBE COINCIDIR CON LA letraRecibida que puede o no coincidir
						//con el Rotulo
						if (letraRecibida=="Arial") {
							nuevoItem.addActionListener(new StyledEditorKit.FontFamilyAction("Cambiar Fuente","Arial"));
						}else if(letraRecibida=="Courier") {
							nuevoItem.addActionListener(new StyledEditorKit.FontFamilyAction("Cambiar Fuente","Courier"));
						}else if(letraRecibida=="Verdana"){
							nuevoItem.addActionListener(new StyledEditorKit.FontFamilyAction("Cambiar Fuente","Verdana"));
						}				 
			}else if (rotuloDisparador=="Estilo") {
				estilos.add(nuevoItem);
						if (estiloRecibido==Font.BOLD) {
							nuevoItem.addActionListener(new StyledEditorKit.BoldAction());
						}else if(estiloRecibido==Font.ITALIC){
							nuevoItem.addActionListener(new StyledEditorKit.ItalicAction());
						}
			}else if (rotuloDisparador=="Tamaño") {
				tamaños.add(nuevoItem);
						//Directamente setiamos el tamaño recibido en el Area de texto
						nuevoItem.addActionListener(new StyledEditorKit.FontSizeAction("Cambiar Tamaño", tamañoRecibido));
			}
			
			
			
	}
	
}
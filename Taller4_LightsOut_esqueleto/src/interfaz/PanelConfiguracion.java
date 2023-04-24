package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;

import uniandes.dpoo.taller4.modelo.Tablero;



public class PanelConfiguracion extends JPanel implements ActionListener{
	
	private ButtonGroup grupo;
	private JComboBox comboBox;
	private PanelTablero cuadricula;
	private VentanaLights ventanadef;
	public String eleccion;
	public int tamaño_eleccion;
	
	
	private static final String BOTON_FACIL = "BOTON_FACIL";
	private static final String BOTON_MEDIO = "BOTON_MEDIO";
	private static final String BOTON_DIFICIL = "BOTON_DIFICIL";
	
	
	public PanelConfiguracion(VentanaLights ventana) {
		
		this.ventanadef=ventana;
		setBackground(new Color(173, 200, 250));
		setLayout(new GridLayout());
		JLabel tamaño= new JLabel("Tamaño:");
		tamaño.setForeground(Color.WHITE);
		add(tamaño);
		
		String[] gridSize= {"5x5", "6x6", "7x7", "8x8", "9x9", "10x10"};
		comboBox=new JComboBox(gridSize);
		comboBox.addActionListener(this);
		comboBox.setActionCommand("comando_JComboBox");
		add(comboBox); 
		
		JLabel dificultad= new JLabel("Dificultad:");
		dificultad.setForeground(Color.WHITE);
		setBackground(new Color(173, 200, 250));
		add(dificultad);
		
		JRadioButton facil = new JRadioButton("Facil");
		facil.setForeground(Color.WHITE);
		facil.setBackground(new Color(173, 200, 250));
		facil.addActionListener(this);
		facil.setActionCommand(BOTON_FACIL);
		
		
		JRadioButton medio = new JRadioButton("Medio");
		medio.setForeground(Color.WHITE);
		medio.setBackground(new Color(173, 200, 250));
		medio.addActionListener(this);
		medio.setActionCommand(BOTON_MEDIO);
		
		
		
		JRadioButton dificil = new JRadioButton("Dificil");
		dificil.setForeground(Color.WHITE);
		dificil.setBackground(new Color(173, 200, 250));
		dificil.addActionListener(this);
		dificil.setActionCommand(BOTON_DIFICIL);
	
		
		ButtonGroup grupo=new ButtonGroup();
		grupo.add(dificil);
		grupo.add(medio);
		grupo.add(facil);
		
		add(facil);	
		add(medio);
		add(dificil);
	}


public void actionPerformed(ActionEvent e)
{
	String action=e.getActionCommand();
	if (action.equals("comando_JComboBox"))
	{
		eleccion=(String) comboBox.getSelectedItem();
		if(eleccion=="5x5")
		{
			tamaño_eleccion=5;
			
		}
		if(eleccion=="6x6")
		{
			tamaño_eleccion=6;
	
		}
		if(eleccion=="7x7")
		{
			tamaño_eleccion=7;

		}
		if(eleccion=="8x8")
		{
			tamaño_eleccion=8;
		}
		if(eleccion=="9x9")
		{
			tamaño_eleccion=9;
			
		}
		if(eleccion=="10x10")
		{
			tamaño_eleccion=10;
		
		}	
		
	}


}

public int getTamaño()
{
	return tamaño_eleccion;
}
public void setcomboBox()
{
	comboBox.setSelectedItem("5x5");
}


		
	
	
	
	
	
}
	
	



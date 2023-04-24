package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelOpcionesBotones extends JPanel implements ActionListener {
	private VentanaLights ventanadef;
	
	private final static String BOTON_1 = "NUEVO";
	private final static String BOTON_2 = "REINICIAR";
	private final static String BOTON_3 = "TOP 10";
	private final static String BOTON_4 = "CAMBIAR USUARIO";
	
	private JButton nuevo;
	private JButton reiniciar;
	private JButton top10;
	private JButton cambiar;
	private JLabel extra;
	
	
	public PanelOpcionesBotones(VentanaLights ventana) {
		ventanadef=ventana;
		setBackground(new Color(231, 242, 208));
		
		setLayout(new GridLayout(15,1));
		
		extra=new JLabel();
		add(extra);
		extra=new JLabel();
		add(extra);
		extra=new JLabel();
		add(extra);
		extra=new JLabel();
		add(extra);
		extra=new JLabel();
		add(extra);
		

		nuevo = new JButton(BOTON_1);
		nuevo.addActionListener(this);
		nuevo.setActionCommand(BOTON_1);
		add(nuevo);
		
		reiniciar = new JButton(BOTON_2);
		reiniciar.addActionListener(this);
		reiniciar.setActionCommand(BOTON_2);
		add(reiniciar);
		
		top10 = new JButton(BOTON_3);
		top10.addActionListener(this);
		top10.setActionCommand(BOTON_3);
		add(top10);

		cambiar = new JButton(BOTON_4);
		cambiar.addActionListener(this);
		cambiar.setActionCommand(BOTON_4);
		add(cambiar);
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		String action=e.getActionCommand();
		if(action.equals(BOTON_1))
		{
			ventanadef.nuevoTablero();
			
		}
		else if(action.equals(BOTON_2))
		{
			ventanadef.jugadas();
		}
		else if(action.equals(BOTON_3))
		{
			ventanadef.top10();
		}
		else if(action.equals(BOTON_4))
		{
			ventanadef.jugadorCambio();
		}
	}
}

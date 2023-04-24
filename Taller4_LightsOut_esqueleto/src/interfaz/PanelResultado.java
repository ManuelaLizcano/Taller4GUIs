package interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelResultado extends JPanel {
	
	private VentanaLights ventanadef;
	private JLabel jugadas1;
	private JTextField jugadasResultado;
	private JLabel jugador;
	private JTextField jugadorNombre;
	private PanelTablero cuadricula;
	public Map<String, Integer> Top10=new HashMap<>();
	
	public PanelResultado(VentanaLights ventana) {
		ventanadef=ventana;
		String jugador1 =JOptionPane.showInputDialog(this, "Ingrese su nombre: ");
		
		cuadricula=new PanelTablero(ventanadef, 5);
		setBackground(new Color(193, 221, 230));
		setLayout(new GridLayout(1,4));
		
		jugadas1= new JLabel("Jugadas:");
		add(jugadas1);
		
		jugadasResultado = new JTextField();
		jugadasResultado.setEditable(false);
		add(jugadasResultado);
		
		jugador= new JLabel("Jugador:");
		add(jugador);
		
		jugadorNombre = new JTextField();
		jugadorNombre.setEditable(false);
		add(jugadorNombre);
		jugadorNombre.setText(jugador1);
	}

	public String cambioJugador()
	{
		
		String nombre = jugadorNombre.getText();
		int puntos= ventanadef.getPuntosTotalesVentana();
		Top10.put(nombre, puntos);
		
		
		String jugador =JOptionPane.showInputDialog(this, "Ingrese su nombre: ");
		
		jugadorNombre.setText(jugador);
		
		return jugador;
	}
	public void cambiojugadas(int jugadas) {
		String Sjugadas=String.valueOf(jugadas);
		jugadasResultado.setText(Sjugadas);
	}
	
	public Map<String, Integer> listaTop()
	{
		return Top10;
	}
	
	
	

}

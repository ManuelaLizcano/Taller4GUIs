package interfaz;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;



public class VentanaLights extends JFrame{
	
	public Tablero modelo;
	public PanelConfiguracion panelNorth;
	public PanelOpcionesBotones panelEast;
	public PanelTablero panelWest;
	public PanelResultado panelSouth;
	private Top10 top;
	private JFrame topFrame;
	
	
	public VentanaLights()
	{
		setTitle("LightsOut");
		setSize(1000,800);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setVisible(true);
		
		panelNorth = new PanelConfiguracion(this);
		add(panelNorth, BorderLayout.NORTH);
		setVisible(true);
		
		panelEast = new PanelOpcionesBotones(this);
		add(panelEast, BorderLayout.EAST);
		
		setVisible(true);
		
		panelWest = new PanelTablero(this, 5);
		add(panelWest, BorderLayout.CENTER);
		setVisible(true);
		
		panelSouth = new PanelResultado(this);
		add(panelSouth, BorderLayout.SOUTH);
		setVisible(true);
		
		
		
		
		
	}
	public static void main(String[] args)
	{
		new VentanaLights();
	}
	
	
	public PanelTablero darTamañoCuadricula() {
		
		return panelWest;
	}
	
	public void nuevoTablero() {
		getPuntosTotalesVentana();
		JOptionPane.showMessageDialog(this, "Se inicio un juego");
		panelWest=darTamañoCuadricula();
		remove(panelWest);
		panelWest=new PanelTablero(this, panelNorth.getTamaño());
		revalidate();
		repaint();
		add(panelWest, BorderLayout.CENTER);
		revalidate();
		repaint();
	}
	public void jugadas() {
		
		
		panelWest=darTamañoCuadricula();
		remove(panelWest);
		panelWest=new PanelTablero(this, 5);
		panelNorth.setcomboBox();
		add(panelWest, BorderLayout.CENTER);
		revalidate();
		repaint();
		JOptionPane.showMessageDialog(this, "Se inicio un juego");
		
	}
	public void top10() {
		topFrame=new JFrame();
		topFrame.setTitle("Top 10");
		topFrame.setSize(100, 450);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		
		Map<String, Integer> listaTop10 = panelSouth.listaTop();
		
		Set<String> keys = listaTop10.keySet();
		Collection<Integer> values = listaTop10.values();
		values.toArray();
		
		DefaultListModel<String> listkeys=new DefaultListModel<>();
		for(String elemento:keys)
		{
			listkeys.addElement(elemento);
		}
		
		DefaultListModel<Integer> listvalues=new DefaultListModel<>();
		for (Integer elemento:values)
		{
			listvalues.addElement(elemento);
		}
		JList<String> listak= new JList(listkeys);
		JList<String> listav=new JList(listvalues);
		
		JPanel panel=new JPanel();
		panel.add(listak);
		panel.add(listav);
		panel.setSize(100,100);
		topFrame.add(panel);
		
	
		topFrame.setVisible(true);
		
		
	}
	public void jugadorCambio() {
		panelSouth.cambioJugador();
		jugadas();
		
	}
	public void cambioJugadas(int jugadas) {
		panelSouth.cambiojugadas(jugadas);
		
	}
	public int getPuntosTotalesVentana()
	{
		int numero = panelWest.getPuntosTotales();
		return numero;
	}
	

}

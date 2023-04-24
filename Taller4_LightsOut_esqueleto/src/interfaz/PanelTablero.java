package interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.Tablero;

public class PanelTablero extends JPanel implements MouseListener{
	
	private VentanaLights ventanadef;
	public Tablero tablero;
	private int len;
	private int largo;
	public int jugadas;
	private int fila;
	private int columna;
	private int cuadritos;
	private int puntosTotales;
	
	public PanelTablero(VentanaLights ventana, int tamaño)
	{
		ventanadef=ventana;
		
		setBackground(new Color(224, 187, 228));
		jugadas=0;
		cuadritos=tamaño*tamaño;
		this.addMouseListener(new MouseAdapter() 
		{
			public void mousePressed(MouseEvent e) 
			{
				int x=e.getX()/len;
				int y=e.getY()/len;
				tablero.jugar(x, y);
				tableroNuevo(tamaño);
				jugadas=jugadas+1;
				System.out.print(jugadas);
				ventana.cambioJugadas(jugadas);
			}

		
		} );
		addMouseListener(this);
		tablero=new Tablero(tamaño);
		
	}
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2d=(Graphics2D) g;
		g.clearRect(0, 0, getWidth(), getHeight());
		boolean[][] cuadricula = this.tablero.darTablero();
		largo = cuadricula.length;
		int tamaño = this.getSize().height;
		len=tamaño/largo;
		for (int i=0; i<largo; i++)
		{
			for (int j=0; j<largo;j++)
			{
				g2d.setColor(new Color(100,100,100));
				Rectangle2D cuadrado=new Rectangle2D.Double(i*len, j*len, len, len);
				g2d.draw(cuadrado);
				Image img = null;
				try {
					img = ImageIO.read(new File("imagenes\\bombillo.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			
				if(tablero.darTablero()[i][j])
				{
					g2d.setColor(Color.YELLOW);
					g2d.fill(cuadrado);
					
				}
				else
				{
					g2d.setColor(Color.WHITE);
					g2d.fill(cuadrado);
				}
				g2d.drawImage(img, (int)cuadrado.getX(), (int)cuadrado.getY(), (int)(cuadrado.getWidth()), (int)(cuadrado.getHeight()), null);
				cuadrado=new Rectangle2D.Double(i*len-1, j*len-1, len-1, len-1);
			}
			 
		}
		puntosTotales=tablero.calcularPuntaje();
			
		
	}
	
	

	private int[] convertirCoordenadasACasilla(int cx, int cy) {
		boolean[][] cuadricula = this.tablero.darTablero();
		int ladoTablero = cuadricula.length;
		int altoPanelTablero=getHeight();
		int anchoPanelTablero=getWidth();
		
		int altoCasilla=altoPanelTablero/ladoTablero;
		int anchoCasilla=anchoPanelTablero/ladoTablero;
		int fila=(int) (cy/altoCasilla);
		int columna=(int)(cx/anchoCasilla);
		
		return new int[] {fila, columna};
		

}
	public void tableroNuevo(int tamaño) {
		len=this.getSize().height;
		len=len/tamaño;
		invalidate();
		repaint();
		
		
	}
	public void reiniciar(int tamaño)
	{
		
		tableroNuevo(tamaño);
		jugadas=0;
	}
	public int cantidad()
	{
		return cuadritos;
	}
	public int getPuntosTotales()
	{
		return puntosTotales;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

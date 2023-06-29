import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

/** 
 * Basis-Panel stellt Grundfunktionen fuer den Aufbau interaktiver Anwendungen zur
 * Verfuegung.
 *  
 * Alle Mausereignisse koennen in einzelnen Methoden verarbeitet werden. 
 *  
 * @author Joerg Berdux
 * @version 1.0
 */
public class Hogsmeade extends JPanel implements MouseListener {	
	
	private static final long serialVersionUID = 1L;

	/**
	 * Initialisierung des Panels und setzen des MouseListerns
	 * fuer die Verwendung von Maus-Ereignissen
	 */
	private Haus[] houses = new Haus[10];

	/** Anzahl der Baume-10
	 *  Anzahl der Leute - 3
	 *  Anzahl der Sonne - 1
	 */
	private Tree[] trees= new Tree[7];;
	private Person[] people = new Person[40];
	private Sun sun;
	private Turm turm;
	
	private Color sky;
	
	
	public Hogsmeade(){
			
		/* registriert Panel als MouseListener, so dass die jeweilige spezialisierte 
		 * Methode aufgerufen wird, wenn ein Mausereignis innerhalb des Panels ausgeloest 
		 * wird
		 */	
		addMouseListener(this);
		
		/* Initialisation von Haeuser, Baeume, Sonne ...
		 * Erstellung von 10 Häuse
		 * Erstellung von 7 Baume
		 * Erstellung von 40 Leute
		 * Erstellung von 1 Turm
		 */
		
		this.sun = new Sun(550, 60);
		this.sky = new Color(135,206,235);
		this.houses[0] = new Haus(0, 220, 100, 100, new Color(238, 197, 145));
		this.houses[1] = new Haus(100, 200, 100, 120, new Color(233, 150, 122));
		this.houses[2] = new Haus(200, 220, 100, 100, new Color (86, 139, 87));
		this.houses[3] = new Haus(330, 220, 100, 100, new Color(139, 87, 86));
		this.houses[4] = new Haus(430, 240, 100, 80, new Color(121, 205, 205));
		this.houses[5] = new Haus(660, 250, 100, 100, new Color(159, 125,167));
		this.houses[6] = new Haus(760, 270, 100, 80, new Color(225, 225, 174));
		this.houses[7] = new Haus(860, 250, 100, 100, new Color(255, 161, 170));
		this.houses[8] = new Haus(1020, 250, 100, 100, new Color(160, 210, 150));
		this.houses[9] = new Haus(1120, 230, 100, 120, new Color(255, 178, 102));
		
		
		for (int i = 0; i < 7; i++) {
			this.trees[i] = new Tree((int) ((i)*150 +(20 + Math.random()*80)), 275);
		}
		for (int i = 0; i < 40; i++) {
			this.people[i] = new Person((int) (30+(i*(20+(Math.random()*10)))), 340);
		}
		this.turm = new Turm(610, 150);
		
		
				
				
	}
	
	/** 
	 * Zeichnen der Strasse.
	 * 
	 * Umsetzung der Methode
	 * @see java.awt.Component#paint(java.awt.Graphics)
	 * 
	 * @param g Graphik-Kontext, auf dem die Landschaft gezeichnet wird
	 */
		public void paint(Graphics g){
			super.paint(g);
			
			
			//hier wird alles gezeichnet ...
			
			g.setColor(sky);
			g.fillRect(0, 0, getWidth(), getHeight());
					
			// Zeichne den Strasse
			g.setColor(Color.GRAY);
			g.fillRect(0, 250, getWidth(), getHeight());
					
			// Zeichne die Haeuser, Baeume, Sonne und Leute
			turm.draw(g);
			for (int i = 0; i < 10; i++) {
				houses[i].draw(g);
			}
			
			for (int i = 0; i < 7; i++) {
				trees[i].draw(g);
			}
			for (int i = 0; i < 40; i++) {
				people[i].draw(g);
			}
			
			sun.draw(g);
		}


		/** 
		 * Aufloesung der x, y-Position, an der Mausbutton betaetigt wurde.
		 * 
		 * Umsetzung der Methode
		 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
		 * 
		 * @param e Maus-Ereignis, das ausgeloest wurde 
		 */
        public void mouseClicked(MouseEvent e) { 
        	int x = e.getX();			// x-Koordinate, an der Mausereignis stattgefunden hat
    		int y = e.getY(); 			// y-Koordinate, an der Mausereignis stattgefunden hat
    					
    		
    		
    		// Schauen ob die Maus auf die Sonne zeigt
        	
    		if (this.sun.contains(x, y)) {
    			if(this.sky == Color.BLACK) {
    				this.sky = new Color(135,206,235);
    			} else {
    				this.sky = Color.BLACK;
    			}
    				sun.changeColor();
		
					for (int i = 0; i < 10; i++) {
						houses[i].changeColorWindow();
						houses[i].changeColor();
					}
    				
    				for (int i = 0; i < 7; i++) {
	    				trees[i].changeColor();
	    			}
	    			for (int i = 0; i < 40; i++) {
	    				
	    				people[i].changeVisible();
	    			}
   			
	    			turm.changeColor();
				
	    			repaint();
    			
			
    		}			
    		
    		
    		// Schauen ob die Maus auf ein Haus zeigt
    		
    		for (int i = 0; i < 10; i++) {
				if (houses[i].contains(x, y)) {
					houses[i].changeColorWindow();
					repaint();
					return;
				}
			}
			
			if (turm.contains(x, y)) {
				turm.changeColorWindow();
				repaint();
				return;
			}
	    		
    	}
    
	
	/** Faengt Mouse-Event ab, ohne ihn weiter zu verarbeiten
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	public void mouseEntered(MouseEvent e){
		// diese Methode bleibt einfach leer
	}
	
	/** Faengt Mouse-Event ab, ohne ihn weiter zu verarbeiten
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	public void mouseExited(MouseEvent e){
		// diese Methode bleibt einfach leer
	}
	
	/** Faengt Mouse-Event ab, ohne ihn weiter zu verarbeiten
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent e){
		// diese Methode bleibt einfach leer
	}

	/** Faengt Mouse-Event ab, ohne ihn weiter zu verarbeiten
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	public void mouseReleased(MouseEvent e){
		// diese Methode bleibt einfach leer
	}
}

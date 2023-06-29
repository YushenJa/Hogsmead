import java.awt.Color;
import java.awt.Graphics;

/**
 * Turm Klasse
 * Erzeugt ein "Turm" - Objekt
 */
public class Turm {

	private int x, y;  
	private Color color;  
	private Color windowColor;  
	private Color roofColor;
	private Color turmWand;
	private boolean licht;
  
	// Konstruktor
    public Turm(int x, int y) {  
        this.x = x;  
        this.y = y;  
        this.color = new Color(205,150,205);  
        this.windowColor = new Color(255,130,71); 
        this.roofColor = new Color(139,102,139); 
        this.turmWand = new Color (139,71,137);
        this.licht = false;  

        
    }  
//  Methode fuer das Zeichnen des Turmes
    public void draw(Graphics g) {  
        // Draw the walls of the Turm  
        g.setColor(color);  
        g.fillRect(x, y, 50, 200);  
        
        
        g.setColor(turmWand);
        int[] xPointsTurmWand = {x+50, x + 50, x + 80, x + 80};  
        int[] yPointsTurmWand = {y+200, y, y-10, y+190};  
        g.fillPolygon(xPointsTurmWand, yPointsTurmWand, 4);
        
        
        // Draw the windows of the Turm  
        g.setColor(windowColor);  
        g.fillRect(x + 15, y + 10, 20, 30);  
        g.fillRect(x + 15, y + 60, 20, 30);  
        g.fillRect(x + 15, y + 110, 20, 30);  
        g.fillRect(x + 15, y + 160, 20, 30);  
        
   
        
        // Draw the roof of the Turm
        g.setColor(roofColor);  
	    int[] xPointsDach2= {x, x+30, x + 80, x +50};  
	    int[] yPointsDach2 = {y, y-10, y-10, y}; 
	    g.fillPolygon(xPointsDach2, yPointsDach2, 4); 
    }
	/**
	 * Methode, die bestimmt ob die Maus auf dieses Haus zeigt oder nicht
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean contains(int x, int y) {
		return (x >= this.x && x <= this.x + 50 &&
				y >= this.y && y <= this.y + 200);
	}
	
	/**
	 * Methode, die die Farbe von dem Haus ändert
	 * Tag/Nacht
	 */
	public void changeColorWindow() {  
        if (licht) {  
            windowColor = new Color(255,130,71);  
            licht = false;  
        } else {  
            windowColor = Color.WHITE;  
            licht = true;  
        }  
    }  
	
	/**
     * Methode, die die Farbe von den Fenstern ändert
     * Tag/Nacht && Licht an/Licht aus
     */ 
	public void changeColor() {  
        if (licht) {  
            turmWand = new Color (139,71,137);
            color = new Color(205,150,205);  
            roofColor = new Color(139,102,139); 
            windowColor = new Color(255,130,71);  
            licht = false;  
        } else {  
        	turmWand = new Color (turmWand.getRed()-70, turmWand.getGreen()-70, turmWand.getBlue()-70);
        	color = new Color (color.getRed()-70, color.getGreen()-70, color.getBlue()-70);
        	roofColor = new Color (roofColor.getRed()-70, roofColor.getGreen()-70, roofColor.getBlue()-70);
        	windowColor = Color.WHITE; 
            licht = true;  
        }  
    }  
}

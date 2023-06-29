import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
/**
 * Person Klasse
 * Erzeugt ein "Person" - Objekt
 */
public class Person {  
    private int x, y;  
    private boolean visible;
    private boolean hut;
  
 // Konstruktor
    public Person(int x, int y) {  
        this.x = x;  
        this.y = y;  
        this.visible = true;
        this.hut = Math.random()<0.5;
    }  
  
//    
   
//  Methode fuer das Zeichnen der Personen
    public void draw(Graphics g) {  
    	if (this.visible) {
	    	// Draw the body  
	        g.setColor(Color.black);  
	        g.fillRect(x, y + 10, 10, 20);  
	  
	        // Draw the head  
	        g.setColor(Color.DARK_GRAY);
	        g.fillOval(x, y, 10, 10);  
	        
	       
	        if(hut) {
		        g.setColor(Color.BLACK);  
		        int[] xPointsDach = {x, x + 5, x + 10};  
		        int[] yPointsDach = {y+2, y - 15, y+2};  
		        g.fillPolygon(xPointsDach, yPointsDach, 3); 
	        }
    	}
    }  
    
    /**
     * Methode, die die Sichtbarkeit der Menschen verändert
     * Tag/Nacht
     */
    public void changeVisible() {  
        if (visible) {   
            visible = false;  
        } else {    
            visible = true;  
        }  
    }
}

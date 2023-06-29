import java.awt.Color;
import java.awt.Graphics;

/**
 * Sun Klasse
 * Erzeugt ein "Sonne" - Objekt
 */
public class Sun {
	 private int x, y;
	 private Color color;
	 private boolean licht;
	 private int circleR = 35;
	 
	// Konstruktor   
	 public Sun(int x, int y){
		 this.x = x;
		 this.y = y;
		 this.color = Color.YELLOW;
	 }

	 //  Methode fuer das Zeichnen der Sonne
	 public void draw(Graphics g){
		
		g.setColor(color);
		g.fillOval(x-circleR, y-circleR, 2*circleR, 2*circleR);
	 }
	 

	 /**
		 * Methode, die bestimmt ob die Maus auf dieses Haus zeigt oder nicht
		 * @param x
		 * @param y
		 * @return
		 */
	 public boolean contains(int x, int y) {
		return (Math.pow(this.x - x,2) + Math.pow(this.y - y,2)<= Math.pow(circleR, 2));
		}
	 
	 
	 
	 /**
	 * Methode, die die Farbe von den Fenstern ändert
	 * Tag/Nacht
	 */ 
	 
	 public void changeColor() {  
		 if (this.licht) {
			 this.color = Color.YELLOW;  
			 this.licht = false; 
	     } else {    
	         this.color = Color.LIGHT_GRAY; 
	         this.licht = true;  
	     }  
	 }

}
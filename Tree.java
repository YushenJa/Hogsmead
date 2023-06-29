import java.awt.Color;
import java.awt.Graphics;

/**
 * Tree Klasse
 * Erzeugt ein "Baum" - Objekt
 */
public class Tree  {  
    private int xPos, yPos;  
    private Color color;  
    private boolean licht;
  
 // Konstruktor
    public Tree(int x, int y) {  
        this.xPos = x;  
        this.yPos = y;  
        this.color = new Color(105, 139, 34);
        this.licht = false;
    }  
  
    //  Methode fuer das Zeichnen des Baumes
    public void draw(Graphics g) {  
    	g.setColor(new Color(139, 69,19));  
        g.fillRect(xPos+20, yPos + 45, 10, 30);  
        
        g.setColor(color);  
        g.fillOval(xPos, yPos, 50, 50);
        
    }  
    
    
    /**
     * Methode, die die Farbe von dem Baum ändert
     * Tag/Nacht
     */
    public void changeColor() {  
        if (this.licht) {  
            this.color = new Color(105, 139, 34);  
            this.licht = false;  
        } else {  
            this.color = new Color (25, 39, 0);  
            this.licht = true;  
        }  
    }  
  
}  
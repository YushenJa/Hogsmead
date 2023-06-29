import java.awt.Color;
import java.awt.Graphics;

/**
 * Haus Klasse
 * Erzeugt ein "Haus" - Objekt
 */
class Haus {  
    private int x, y, width, height; 
    private Color color;  
    private Color colorDark; 
    private Color colorLight; 
    private Color windowColor;  
    private Color roofColor;
    private Color roofColor2;
    private boolean licht;
    
  
 // Konstruktor
    public Haus(int x, int y, int width, int height, Color c) {  
        this.x = x;  
        this.y = y;  
        this.width = width;
        this.height = height;
        this.color = c;
        this.colorDark = new Color(color.getRed()-70, color.getGreen()-70, color.getBlue()-70); 
        this.colorLight = c;
        this.roofColor = new Color(139, 119, 101);  
        this.roofColor2 = new Color(129,109,90); 
        this.windowColor = Color.DARK_GRAY;  
        this.licht = false;  
        
    }  
    // Methode fuer das Zeichnen des Haus
    public void draw(Graphics g) {  
        // Draw the walls of the house  
        g.setColor(color);  
        g.fillRect(x, y, width, height);  
        
        g.setColor(color); 
        int[] xPointsWand = {x+width, x + 100, x + 170, x +170};  
        int[] yPointsWand = {y+height, y, y-30, y+(height-30)};  
        g.fillPolygon(xPointsWand, yPointsWand, 4);  
  
        // Draw the roof of the house  
        g.setColor(roofColor);  
        int[] xPointsDach = {x, x + 50, x + 100};  
        int[] yPointsDach = {y, y - 50, y};  
        g.fillPolygon(xPointsDach, yPointsDach, 3);  
        //
        g.setColor(roofColor2);  
	    int[] xPointsDach2= {x+100, x + 50, x + 120, x +170};  
	    int[] yPointsDach2 = {y, y - 50, y-70, y-30}; 
	    g.fillPolygon(xPointsDach2, yPointsDach2, 4); 
	    
       
        // Draw the windows of the house  
        g.setColor(windowColor);  
        g.fillRect(x + 20, y + 15, 20, height/3);  
        g.fillRect(x + 60, y + 15, 20, height/3);  
        g.fillRect(x + 20, y + (height/2)+10, 20, height/3);  
        g.fillRect(x + 60, y + (height/2)+10, 20, height/3);  
    }  
    
 /** Methode, die bestimmt ob die Maus auf dieses Haus zeigt oder nicht
  * 
  * @param x
  * @param y
  * @return
  */
    public boolean contains(int x, int y) {
		return (x >= this.x && x <= this.x + width &&
				y >= this.y && y <= this.y + height);
	}
/**
 * Methode, die die Farbe von dem Haus ändert
 * Tag/Nacht
 */
    public void changeColor() {    
    	 if (this.licht) {  
             this.color = colorDark;  
             this.roofColor = Color.GRAY; 
             this.roofColor2 = Color.DARK_GRAY;  
             this.licht = true;  
         } else {
        	 this.color = colorLight;  
             this.roofColor = new Color(139, 119, 101); 
        	 this.roofColor2 = new Color(129,109,90);   
        	 this.licht = false;  
         }
            
    }    
    
    /**
     * Methode, die die Farbe von den Fenstern ändert
     * Tag/Nacht && Licht an/Licht aus
     */ 
     public void changeColorWindow() {  
        if (this.licht) {  
            this.windowColor = Color.DARK_GRAY;  
            this.licht = false;  
        } else {  
            this.windowColor = Color.YELLOW;  
            this.licht = true;  
        }  
    }  

}  
package pkg2dsnake;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Gameplay extends JPanel
{
    private ImageIcon titleImage;
    
    // Constructor.
    Gameplay()
    {
        
    }
    
    // Other Methods. 
    @Override
    public void paint(Graphics g)
    {
        g.setColor(Color.white);
        g.drawRect(24, 10, 851, 55);
        
        titleImage = new ImageIcon("snaketitle.jpg");
        titleImage.paintIcon(this, g, 25, 11);
        
        g.setColor(Color.white);
        g.drawRect(24, 74, 851, 577);
        
        g.setColor(Color.black);
        g.fillRect(25, 75, 850, 575);
        
        
    }
}

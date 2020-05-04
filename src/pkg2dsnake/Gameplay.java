package pkg2dsnake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
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
        // Draw title image border
        g.setColor(Color.white);
        g.drawRect(24, 10, 851, 55);
        
        // Draw title image.
        titleImage = new ImageIcon("images/snaketitle.jpg");
        titleImage.paintIcon(this, g, 25, 11);
        
        // Draw border for gameplay
        g.setColor(Color.white);
        g.drawRect(24, 74, 851, 577);
        
        // Draw background for gameplay
        g.setColor(Color.black);
        g.fillRect(25, 75, 850, 575);
        
    }
}

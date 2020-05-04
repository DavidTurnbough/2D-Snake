package pkg2dsnake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener
{

    private final int INITIAL_SNAKE_LENGTH = 3;
    private final int INITIAL_MOVES_MADE = 0;
    private final int DELAY = 100;

    private int snakeLength;
    private int movesMade;
    private int[] snakeXLength;
    private int[] snakeYLength;
    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;
    private ImageIcon titleImage;
    private ImageIcon rightMouth;
    private ImageIcon leftMouth;
    private ImageIcon upMouth;
    private ImageIcon downMouth;
    private ImageIcon snakeBody;
    private Timer timer;

    // Constructor.
    Gameplay()
    {
        this.snakeLength = INITIAL_SNAKE_LENGTH;
        this.movesMade = INITIAL_MOVES_MADE;

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        this.timer = new Timer(DELAY, this);
        timer.start();

        this.snakeXLength = new int[750];
        this.snakeYLength = new int[750];

        this.left = false;
        this.right = false;
        this.up = false;
        this.down = false;

        this.titleImage = new ImageIcon("images/snaketitle.jpg");
        this.rightMouth = new ImageIcon("images/rightmouth.png");
        this.leftMouth = new ImageIcon("images/leftmouth.png");
        this.upMouth = new ImageIcon("images/upmouth.png");
        this.downMouth = new ImageIcon("images/downmouth.png");
        this.snakeBody = new ImageIcon("images/snakeimage.png");
    }

// Other Methods. 
    @Override
    public void paint(Graphics g)
    {
        if (movesMade == 0)
        {
            snakeXLength[0] = 100;
            snakeXLength[1] = 75;
            snakeXLength[2] = 50;

            snakeYLength[0] = 100;
            snakeYLength[1] = 100;
            snakeYLength[2] = 100;
        }

        // Draw title image border
        g.setColor(Color.white);
        g.drawRect(24, 10, 851, 55);

        // Draw title image.
        titleImage.paintIcon(this, g, 25, 11);

        // Draw border for gameplay
        g.setColor(Color.white);
        g.drawRect(24, 74, 851, 577);

        // Draw background for gameplay
        g.setColor(Color.black);
        g.fillRect(25, 75, 850, 575);

        rightMouth = new ImageIcon("images/rightmouth.png");
        rightMouth.paintIcon(this, g, snakeXLength[0], snakeYLength[0]);

        for (int i = 0; i < snakeLength; ++i)
        {
            if (i == 0 && right)
            {
                rightMouth = new ImageIcon("images/rightmouth.png");
                rightMouth.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
            }
            if (i == 0 && left)
            {
                leftMouth = new ImageIcon("images/leftmouth.png");
                leftMouth.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
            }
            if (i == 0 && up)
            {
                upMouth = new ImageIcon("images/upmouth.png");
                upMouth.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
            }
            if (i == 0 && down)
            {
                downMouth = new ImageIcon("images/downMouth.png");
                downMouth.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
            }
            if (i != 0)
            {
                snakeBody = new ImageIcon("images/snakeimage.png");
                snakeBody.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
            }

        }

        g.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

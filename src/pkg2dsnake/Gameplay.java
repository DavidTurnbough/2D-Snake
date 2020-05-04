//******************************************************************************
// Name: David Turnbough
// Date: May 03, 2020 Sunday
// YouTube: Java Tutorial How to Develop Game in Java (Snake Game)
//https://www.youtube.com/watch?v=_SqnzvJuKiA
//******************************************************************************
package pkg2dsnake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener
{

    // Final Variable Declarations.
    private final int INITIAL_SNAKE_LENGTH = 3;
    private final int INITIAL_MOVES_MADE = 0;
    private final int INITIAL_SCORE = 0;
    private int DELAY = 100;
    private final int MAX_ENEMY_X_POSITIONS = 32;
    private final int MAX_ENEMY_Y_POSITIONS = 23;

    // Variable Declarations.
    private int snakeLength;
    private int movesMade;
    private int enemyXPosition;
    private int enemyYPosition;
    private int score;
    private int[] snakeXLength;
    private int[] snakeYLength;
    private int[] possibleEnemyXPosition;
    private int[] possibleEnemyYPosition;
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
    private ImageIcon enemyImage;
    private Timer timer;
    private Random random;

    // Constructors.
    Gameplay()
    {
        this.snakeLength = INITIAL_SNAKE_LENGTH;
        this.movesMade = INITIAL_MOVES_MADE;
        this.score = INITIAL_SCORE;

        random = new Random();
        this.enemyXPosition = random.nextInt(MAX_ENEMY_X_POSITIONS);
        this.enemyYPosition = random.nextInt(MAX_ENEMY_Y_POSITIONS);

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
        this.enemyImage = new ImageIcon("images/enemy.png");

        this.possibleEnemyXPosition = new int[]
        {
            25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400,
            425, 450, 475, 500, 525, 550, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800
        };

        this.possibleEnemyYPosition = new int[]
        {
            75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350,
            375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625
        };
    }

    // Other Methods. 
    private int setEnemyPosition(int snakePosition, int enemyPosition, int maxValue)
    {
        if (snakePosition != enemyPosition)
        {
            return enemyPosition;
        }

        return setEnemyPosition(snakePosition, random.nextInt(maxValue), maxValue);
    }

    // Overridden Methods.
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

        // Score
        g.setColor(Color.white);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Scores: " + score, 780, 30);

        // Length
        g.setColor(Color.white);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Length: " + snakeLength, 780, 50);

        // Head Icon.
        rightMouth = new ImageIcon("images/rightmouth.png");
        rightMouth.paintIcon(this, g, snakeXLength[0], snakeYLength[0]);

        // Change head icon based on input.
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

        // Enemy Icon.
        enemyImage = new ImageIcon("images/enemy.png");
        enemyImage.paintIcon(this, g, possibleEnemyXPosition[enemyXPosition], possibleEnemyYPosition[enemyYPosition]);

        // Check for head and enemy collision.
        if ((possibleEnemyXPosition[enemyXPosition] == snakeXLength[0])
                && possibleEnemyYPosition[enemyYPosition] == snakeYLength[0])
        {
            snakeLength++;
            score++;
            DELAY--;

            random = new Random();
            enemyXPosition = random.nextInt(MAX_ENEMY_X_POSITIONS);
            this.enemyXPosition = setEnemyPosition(snakeXLength[0], enemyXPosition, MAX_ENEMY_X_POSITIONS);

            enemyYPosition = random.nextInt(MAX_ENEMY_Y_POSITIONS);
            this.enemyYPosition = setEnemyPosition(snakeYLength[0], enemyYPosition, MAX_ENEMY_Y_POSITIONS);
        }
        
        for(int i = 1; i < snakeLength; ++i)
        {
            if(snakeXLength[i] == snakeXLength[0] && snakeYLength[i] == snakeYLength[0])
            {
                this.right = false;
                this.left = false;
                this.up = false;
                this.down = false;
                
                g.setColor(Color.white);
                g.setFont(new Font("arial", Font.BOLD, 50));
                g.drawString("Game Over", 300, 300);
                
                g.setFont(new Font("arial", Font.BOLD, 20));
                g.drawString("Press spacebar to restart", 310, 340);
            }
        }

        g.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        // Check for input.
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            movesMade = INITIAL_MOVES_MADE;
            score = INITIAL_SCORE;
            snakeLength = INITIAL_SNAKE_LENGTH;
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            movesMade++;
            this.right = true;

            if (!left)
            {
                this.right = true;
            }
            else
            {
                this.right = false;
                this.left = true;
            }
            this.up = false;
            this.down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            movesMade++;
            this.left = true;

            if (!right)
            {
                this.left = true;
            }
            else
            {
                this.left = false;
                this.right = true;
            }
            this.up = false;
            this.down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            movesMade++;
            this.up = true;

            if (!down)
            {
                this.up = true;
            }
            else
            {
                this.up = false;
                this.down = true;
            }
            this.left = false;
            this.right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            movesMade++;
            this.down = true;

            if (!up)
            {
                this.down = true;
            }
            else
            {
                this.down = false;
                this.up = true;
            }
            this.left = false;
            this.right = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // Snake movement. 
        timer.start();

        if (right)
        {
            for (int i = snakeLength - 1; i >= 0; --i)
            {
                snakeYLength[i + 1] = snakeYLength[i];
            }

            for (int i = snakeLength; i >= 0; --i)
            {
                if (i == 0)
                {
                    snakeXLength[i] = snakeXLength[i] + 25;
                }
                else
                {
                    snakeXLength[i] = snakeXLength[i - 1];
                }

                if (snakeXLength[i] > 850)
                {
                    snakeXLength[i] = 25;
                }
            }

            repaint();
        }
        if (left)
        {
            for (int i = snakeLength - 1; i >= 0; --i)
            {
                snakeYLength[i + 1] = snakeYLength[i];
            }

            for (int i = snakeLength; i >= 0; --i)
            {
                if (i == 0)
                {
                    snakeXLength[i] = snakeXLength[i] - 25;
                }
                else
                {
                    snakeXLength[i] = snakeXLength[i - 1];
                }

                if (snakeXLength[i] < 25)
                {
                    snakeXLength[i] = 850;
                }
            }

            repaint();
        }
        if (up)
        {
            for (int i = snakeLength - 1; i >= 0; --i)
            {
                snakeXLength[i + 1] = snakeXLength[i];
            }

            for (int i = snakeLength; i >= 0; --i)
            {
                if (i == 0)
                {
                    snakeYLength[i] = snakeYLength[i] - 25;
                }
                else
                {
                    snakeYLength[i] = snakeYLength[i - 1];
                }

                if (snakeYLength[i] < 75)
                {
                    snakeYLength[i] = 625;
                }
            }

            repaint();
        }
        if (down)
        {
            for (int i = snakeLength - 1; i >= 0; --i)
            {
                snakeXLength[i + 1] = snakeXLength[i];
            }

            for (int i = snakeLength; i >= 0; --i)
            {
                if (i == 0)
                {
                    snakeYLength[i] = snakeYLength[i] + 25;
                }
                else
                {
                    snakeYLength[i] = snakeYLength[i - 1];
                }

                if (snakeYLength[i] > 625)
                {
                    snakeYLength[i] = 75;
                }
            }

            repaint();
        }
    }
}

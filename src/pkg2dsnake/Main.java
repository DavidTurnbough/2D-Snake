//******************************************************************************
// Name: David Turnbough
// Date: May 03, 2020 Sunday
// YouTube: Java Tutorial How to Develop Game in Java (Snake Game)
//https://www.youtube.com/watch?v=_SqnzvJuKiA
//******************************************************************************
package pkg2dsnake;

import java.awt.Color;
import javax.swing.JFrame;

public class Main
{

    public static void main(String[] args)
    {
        JFrame myFrame = new JFrame();
        Gameplay myGame = new Gameplay();

        myFrame.setTitle("2D-Snake");
        myFrame.setBackground(Color.DARK_GRAY);
        myFrame.setBounds(10, 10, 905, 700);
        myFrame.setResizable(false);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.add(myGame);
    }
}

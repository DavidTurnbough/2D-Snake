package pkg2dsnake;

import java.awt.Color;
import javax.swing.JFrame;

public class Main
{
    public static void main(String[] args)
    {
        JFrame myFrame = new JFrame();
        myFrame.setTitle("2D-Snake");
        myFrame.setBackground(Color.DARK_GRAY);
        myFrame.setBounds(10, 10, 500, 500);
        myFrame.setResizable(false);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
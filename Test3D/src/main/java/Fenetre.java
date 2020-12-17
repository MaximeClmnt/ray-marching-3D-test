
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maxime
 */
public class Fenetre extends JFrame{
    private Panel pan;
    public Fenetre(int width,int height){
        //this.setSize(width, height);
        this.setTitle("Test 3D");
        //this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pan = new Panel(width,height);
        pan.setPreferredSize(new Dimension(width,height));
        this.setContentPane(pan);
        this.pack();
        this.setVisible(true);
        pan.init();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SmartHome;

import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author hunglv
 */
public class SmartHomeUI extends JFrame {
    // List of devices
    ImagePanel airImage;
    ImagePanel airOn;
    ImagePanel airOff;
    
    ImagePanel refImage;
    ImagePanel reOn;
    ImagePanel reOff;
    
    DevicelPanel airConditional;
    DevicelPanel reFrigarator;
    
    public SmartHomeUI() {
        try {
            airImage = new ImagePanel(ImageIO.read(new File("C:\\hunglv\\air.png")));
            airOn = new ImagePanel(ImageIO.read(new File("C:\\hunglv\\on.png")));
            airOff = new ImagePanel(ImageIO.read(new File("C:\\hunglv\\off.png")));
            
            refImage = new ImagePanel(ImageIO.read(new File("C:\\hunglv\\ref.png")));
            reOn = new ImagePanel(ImageIO.read(new File("C:\\hunglv\\on.png")));
            reOff = new ImagePanel(ImageIO.read(new File("C:\\hunglv\\off.png")));
            
            airConditional = new DevicelPanel(airImage, airOff);
            reFrigarator = new DevicelPanel(refImage, reOff);
            
            setLayout(new GridLayout(1, 2));
            add(airConditional);
            add(reFrigarator);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(600, 800);
        } catch (IOException ex) {
            System.out.println("File not found.");
        }
    }
}

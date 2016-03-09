/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SmartHome;

import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author hunglv
 */
public class SmartHomeUI extends JFrame {
    // List of image devices
    ImagePanel airImage;
    ImagePanel airOn;
    ImagePanel airOff;
    
    ImagePanel refImage;
    ImagePanel reOn;
    ImagePanel reOff;
    
    ImagePanel fanImage;
    ImagePanel fanOn;
    ImagePanel fanOff;
 
    ImagePanel lamImage;
    ImagePanel lamOn;
    ImagePanel lamOff;
    
    ImagePanel tvImage;
    ImagePanel tvOn;
    ImagePanel tvOff;
    
    ImagePanel washImage;
    ImagePanel washOn;
    ImagePanel washOff;
    
    DevicelPanel airConditional;
    DevicelPanel reFrigarator;
    DevicelPanel fan;
    DevicelPanel lamp;
    DevicelPanel television;
    DevicelPanel washingmachine;
    
    public SmartHomeUI() {
        try {
            // Air Conditional
            airImage = new ImagePanel(ImageIO.read(getClass().getResource("/image/air.png")));
            airOn = new ImagePanel(ImageIO.read(getClass().getResource("/image/on.png")));
            airOff = new ImagePanel(ImageIO.read(getClass().getResource("/image/off.png")));
            
            // Refrigerator
            refImage = new ImagePanel(ImageIO.read(getClass().getResource("/image/ref.png")));
            reOn = new ImagePanel(ImageIO.read(getClass().getResource("/image/on.png")));
            reOff = new ImagePanel(ImageIO.read(getClass().getResource("/image/off.png")));
            
            // Fan
            fanImage = new ImagePanel(ImageIO.read(getClass().getResource("/image/fan.png")));
            fanOn = new ImagePanel(ImageIO.read(getClass().getResource("/image/on.png")));
            fanOff = new ImagePanel(ImageIO.read(getClass().getResource("/image/off.png")));
            
            // Television
            tvImage = new ImagePanel(ImageIO.read(getClass().getResource("/image/television.png")));
            tvOn = new ImagePanel(ImageIO.read(getClass().getResource("/image/on.png")));
            tvOff = new ImagePanel(ImageIO.read(getClass().getResource("/image/off.png")));
            
             // Lamp
            lamOn = new ImagePanel(ImageIO.read(getClass().getResource("/image/lamp_on.png")));
            lamOff = new ImagePanel(ImageIO.read(getClass().getResource("/image/lamp_off.png")));
            
            // Washing machine
            washImage = new ImagePanel(ImageIO.read(getClass().getResource("/image/washingmachine.png")));
            washOn = new ImagePanel(ImageIO.read(getClass().getResource("/image/on.png")));
            washOff = new ImagePanel(ImageIO.read(getClass().getResource("/image/off.png")));
            
            fan = new DevicelPanel(fanImage, fanOff);
            airConditional = new DevicelPanel(airImage, airOff);
            reFrigarator = new DevicelPanel(refImage, reOff);
            television = new DevicelPanel(tvImage, tvOff);
            lamp = new DevicelPanel(lamOff);
            washingmachine = new DevicelPanel(washImage, washOff);
            
            setLayout(new GridLayout(2, 3));
            add(airConditional);
            add(reFrigarator);
            add(fan);
            add(television);
            add(washingmachine);
            add(lamp);

            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setSize(1000, 625);
            
        } catch (IOException ex) {
            System.out.println("File not found.");
        }
    }
    
    public void setAir(int state) {
        if(state == 1) {
            airConditional.revalidate();
            airConditional.setState(airOn);
        }
        else {
            airConditional.revalidate();
            airConditional.setState(airOff);
        }
    }
    
    public void setRef(int state) {
        if(state == 1) {
            reFrigarator.revalidate();
            reFrigarator.setState(reOn);
        }
        else {
            reFrigarator.revalidate();
            reFrigarator.setState(reOff);
        }
    }

    void setLam(int state) {
        if(state == 1) {
            lamp.revalidate();
            lamp.setState(lamOn);
        }
        else {
            lamp.revalidate();
            lamp.setState(lamOff);
        }
    }

    void setFan(int state) {
        if(state == 1) {
            fan.revalidate();
            fan.setState(fanOn);
        }
        else {
            fan.revalidate();
            fan.setState(fanOff);
        }
    }

    void setWash(int state) {
        if(state == 1) {
            washingmachine.revalidate();
            washingmachine.setState(washOn);
        }
        else {
            washingmachine.revalidate();
            washingmachine.setState(washOff);
        }  
    }

    void setTV(int state) {
        if(state == 1) {
            television.revalidate();
            television.setState(tvOn);
        }
        else {
            television.revalidate();
            television.setState(tvOff);
        }      
    }
}

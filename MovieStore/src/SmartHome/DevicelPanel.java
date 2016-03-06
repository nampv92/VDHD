/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SmartHome;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author hunglv
 */
public class DevicelPanel extends JPanel {
    ImagePanel imgDevice;
    ImagePanel imgState;
    public DevicelPanel(ImagePanel imgDevice, ImagePanel imgState) {
        this.imgDevice = imgDevice;
        this.imgState = imgState;
        createLayout(imgDevice, imgState);
    }
    
    public DevicelPanel(ImagePanel imgState) {
        this.imgState = imgState;
        createLayout(imgState);
    }
    
    private void createLayout(ImagePanel imgDevice, ImagePanel imgState) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(imgDevice);
        add(imgState);
    }
    
    private void createLayout(ImagePanel imgDevice) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(imgDevice);
    }
    
    public void setState(ImagePanel imgState) {
        this.remove(this.imgState);
        this.imgState = imgState;
        this.add(imgState);
        repaint();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SmartHome;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.text.StyleConstants;

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
        createLayout();
    }
    
    private void createLayout() {
        setLayout(new GridLayout(2, 1));
        add(imgDevice, BorderLayout.CENTER);
        add(imgState, BorderLayout.CENTER);
    }
    
    public void setState(ImagePanel imgState) {
        this.remove(this.imgState);
        this.imgState = imgState;
        this.add(imgState);
        repaint();
    }
}

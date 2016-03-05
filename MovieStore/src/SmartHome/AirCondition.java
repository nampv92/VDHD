/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SmartHome;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author hunglv
 */
public class AirCondition extends JPanel {
    ImagePanel imgDevice;
    ImagePanel imgState;
    public AirCondition(ImagePanel imgDevice, ImagePanel imgState) {
        this.imgDevice = imgDevice;
        this.imgState = imgState;
        createLayout();
    }
    
    private void createLayout() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(imgDevice);
        add(imgState);
    }
    
    public void setState(ImagePanel imgState) {
        this.remove(this.imgDevice);
        this.imgState = imgState;
        this.add(imgState);
        repaint();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SmartHome;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author hunglv
 */
public class ImagePanel extends JPanel {
    private Image image;
    
    public ImagePanel (Image image) {
        this.image = image;
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, (this.getHeight() - image.getHeight(this))/2, (this.getWidth()- image.getWidth(this))/2, null);
    }
}

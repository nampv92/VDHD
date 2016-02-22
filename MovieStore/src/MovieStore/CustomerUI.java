/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovieStore;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author hunglv
 */
public class CustomerUI extends JFrame {
    private JTextField tf_movieName;
    private JButton btn_Search;
    
    Customer customerAgent;
    public CustomerUI(Customer customerAgent) {
        this.customerAgent = customerAgent;
        createUI();
    }
    
    private void createUI() {
        createLayout();
        setTitle(customerAgent.getLocalName() + " management");
        setSize(350, 160);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void createLayout() {
        // Initializes interface
        JPanel gridLayout = new JPanel();
        JPanel buttonPannel = new JPanel();
        gridLayout.setLayout(new GridLayout(1, 2));

        // Initializes sub components
        tf_movieName = new JTextField(20);
        btn_Search = new JButton("Search");
        gridLayout.add(new JLabel("Tên phim:"));
        gridLayout.add(tf_movieName);
        buttonPannel.add(btn_Search);
        btn_Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Start buying");
            }
        });
        
        getContentPane().add(buttonPannel, BorderLayout.SOUTH);
        getContentPane().add(gridLayout, BorderLayout.CENTER);
    }
}

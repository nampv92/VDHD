/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentManager;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author hunglv
 */
public class Manager extends JFrame {
    private University universityAgent;
    private JTextField tf_studentName, tf_studentId;
    private JButton btn_Add;
    private String studentName, studentId, university;
    
    public Manager(University universityAgent) {
        createUI(universityAgent);
    }
    
    private void createUI(University universityAgent) {
        createLayout();
        setTitle(universityAgent.getLocalName() + " management");
        setSize(350, 130);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void createLayout() {
        JPanel gridLayout = new JPanel();
        JPanel buttonPannel = new JPanel();
        gridLayout.setLayout(new GridLayout(2, 2));

        tf_studentId = new JTextField(20);
        tf_studentName = new JTextField(20);
        btn_Add = new JButton("Add");

        gridLayout.add(new JLabel("Student ID:"));
        gridLayout.add(tf_studentId);
        gridLayout.add(new JLabel("Name:"));
        gridLayout.add(tf_studentName);
        
        getContentPane().add(gridLayout, BorderLayout.CENTER);
        
        btn_Add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                studentId = tf_studentId.getText().trim();
                studentName = tf_studentName.getText().trim();
                
                tf_studentId.setText("");
                tf_studentName.setText("");
                
                System.out.println(studentId + "   " + studentName);
            }
        });
        
        buttonPannel.add(btn_Add);
        getContentPane().add(buttonPannel, BorderLayout.SOUTH);
    }
    
    private void updateData(String studentId, String studentName, String university) {
        
    }
}

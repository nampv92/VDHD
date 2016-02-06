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
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
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
        this.universityAgent = universityAgent;
        createUI();
    }
    
    private void createUI() {
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
                updateData(studentId, studentName);
            }
        });
        
        buttonPannel.add(btn_Add);
        getContentPane().add(buttonPannel, BorderLayout.SOUTH);
    }
    
    private void updateData(String studentId, String studentName) {
        JdbcUtil jdbc = JdbcUtil.getInstance();
        jdbc.init();
        Connection connection = jdbc.getConnection();
        
        
        String sql;
        /* Update database */
        if(universityAgent.getLocalName().compareTo("UET") == 0) {
            sql = "insert into student_uet(id, student_name, university) values ('"
                    + studentId + "', '" + studentName + "', '" + universityAgent.getLocalName() + "')";
        }
        else if (universityAgent.getLocalName().compareTo("ULIS") == 0) {
            sql = "insert into student_ulis(id, student_name, university) values ('"
                    + studentId + "', '" + studentName + "', '" + universityAgent.getLocalName() + "')";
        }
        else if (universityAgent.getLocalName().compareTo("HUS") == 0) {
            sql = "insert into student_hus(id, student_name, university) values ('"
                    + studentId + "', '" + studentName + "', '" + universityAgent.getLocalName() + "')";
        }
        else {
            sql = "insert into student_ueb(id, student_name, university) values ('"
                    + studentId + "', '" + studentName + "', '" + universityAgent.getLocalName() + "')";
        }

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        }
        catch (SQLException e) {
            System.out.println("Can not insert data into database.");
        }
        
        /* Update student list for each agent */
        universityAgent.getStudentList().add(new Student(studentId, studentName, universityAgent.getLocalName()));
            
        /*System.out.println("-------------------------");
        for(int i = 0; i < universityAgent.getStudentList().size(); i ++) {
            System.out.println(universityAgent.getStudentList().get(i).getId());
            System.out.println(universityAgent.getStudentList().get(i).getName());
            System.out.println(universityAgent.getStudentList().get(i).getUniversity());
        }
        System.out.println("-------------------------");*/
    }
}

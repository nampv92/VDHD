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
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author hunglv
 */
public class StoreUI extends JFrame {
    private final Store storeAgent;
    private JTextField tf_movieName, tf_movieDuration, tf_moviePrice, tf_movieValue;
    private JButton btn_Add;
    private String movieName = null;
    private float duration = 0;
    private float price = 0;
    private int value = 0;
    
    public StoreUI(Store universityAgent) {
        this.storeAgent = universityAgent;
        createUI();
    }
    
    private void createUI() {
        createLayout();
        setTitle(storeAgent.getLocalName() + " management");
        setSize(350, 160);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void createLayout() {
        JPanel gridLayout = new JPanel();
        JPanel buttonPannel = new JPanel();
        gridLayout.setLayout(new GridLayout(4, 2));

        tf_movieName = new JTextField(20);
        tf_movieDuration = new JTextField(20);
        tf_moviePrice = new JTextField(20);
        tf_movieValue = new JTextField(20);
        
        btn_Add = new JButton("Add");

        gridLayout.add(new JLabel("Tên phim:"));
        gridLayout.add(tf_movieName);
        gridLayout.add(new JLabel("Thời gian thuê:"));
        gridLayout.add(tf_movieDuration);
        gridLayout.add(new JLabel("Giá:"));
        gridLayout.add(tf_moviePrice);
        gridLayout.add(new JLabel("Đánh giá:"));
        gridLayout.add(tf_movieValue);
        
        getContentPane().add(gridLayout, BorderLayout.CENTER);
        
        btn_Add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isFill = true;
                movieName = tf_movieName.getText().trim();
                if(tf_moviePrice.getText().compareTo("") == 0 || tf_movieDuration.getText().compareTo("") == 0) {
                    isFill = false;
                }
                else {
                    duration = Integer.parseInt(tf_movieDuration.getText().trim());
                    price = Float.parseFloat(tf_moviePrice.getText().trim());
                }

                // Field value may be null
                if(tf_movieValue.getText().compareTo("") == 0) {
                    value = 0;
                }
                else {
                    value = Integer.parseInt(tf_movieValue.getText());
                }
                
                tf_movieName.setText("");
                tf_movieDuration.setText("");
                tf_moviePrice.setText("");
                tf_movieValue.setText("");
                
                if(movieName != null && isFill == true) {
                    updateData(movieName, duration, price, value);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please fill all fields before");
                }
            }
        });
        
        buttonPannel.add(btn_Add);
        getContentPane().add(buttonPannel, BorderLayout.SOUTH);
    }
    
    private void updateData(String movieName, float duration, float price, int value) {
        JdbcUtil jdbc = JdbcUtil.getInstance();
        jdbc.init();
        Connection connection = jdbc.getConnection();
        
        
        String sql = null;
        /* Update database */
        if(storeAgent.getLocalName().compareTo("STAR") == 0) {
            sql = "insert into star_store(movieName, duration, price, value) values ('"
                    + movieName + "', " + duration + ", " + price + ", " + value + ")";
        }
        else if (storeAgent.getLocalName().compareTo("CLOUD") == 0) {
            sql = "insert into cloud_store(movieName, duration, price, value) values ('"
                    + movieName + "', " + duration + ", " + price + ", " + value + ")";
        }
        else if (storeAgent.getLocalName().compareTo("WIND") == 0) {
            sql = "insert into wind_store(movieName, duration, price, value) values ('"
                    + movieName + "', " + duration + ", " + price + ", " + value + ")";
        }
        else {
        }

        try {
            Statement stmt = connection.createStatement();
            int insertResult = stmt.executeUpdate(sql);
            if(insertResult == 1) {
                JOptionPane.showMessageDialog(this, "Inset new movie successfull");
            }
            else {
                JOptionPane.showMessageDialog(this, "Can not insert new movie");
            }
        }
        catch (SQLException e) {
            System.out.println("Can not insert data into database.");
        }
        
        /* Update student list for each agent */
        storeAgent.getStudentList().add(new Movie(movieName, duration, price, value));
            
        /*System.out.println("-------------------------");
        for(int i = 0; i < universityAgent.getStudentList().size(); i ++) {
            System.out.println(universityAgent.getStudentList().get(i).getId());
            System.out.println(universityAgent.getStudentList().get(i).getName());
            System.out.println(universityAgent.getStudentList().get(i).getUniversity());
        }
        System.out.println("-------------------------");*/
    }
}

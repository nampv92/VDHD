/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentManager;

import jade.core.Agent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author hunglv
 */
public class University extends Agent {
    private Manager mangerGui;
    private ArrayList<Student> studentList;
    
    protected void setup(){
        studentList = new ArrayList<>();
        mangerGui = new Manager(this);
        mangerGui.setVisible(true);
        
        /**
         * Gets all data from database. Each database contain info with an university
         * We have total 4 agent include: UET, ULIS, HUS, UEB
         */
        
        /* Initializes connection */
        JdbcUtil jdbc = JdbcUtil.getInstance();
        jdbc.init();

        /* Create connection to databse */
        Connection connection = jdbc.getConnection();
        String sql;
        ResultSet result;
        Student tmp_student;

        try {
            Statement stmt = connection.createStatement();
            
            if(connection != null) {
                if (this.getLocalName().compareTo("UET") == 0) {
                    System.out.println("Agent UET");
                    sql = "select * from student_uet";
                    result = jdbc.getResult(stmt, sql);
                    
                    if(result != null) {
                        while(result.next()){
                            //Retrieve by column name
                            String id  = result.getString("id");
                            String student_name = result.getString("student_name");
                            String university = result.getString("university");

                            /* Adds new student in list */
                            tmp_student = new Student(id, student_name, university);
                            studentList.add(tmp_student);
                        }
                    }
                    else {
                        System.out.println("This university is empty.");
                    }
                }
                else if (this.getLocalName().compareTo("ULIS") == 0){
                    System.out.println("Agent ULIS");
                    sql = "select * from student_ulis";
                    result = jdbc.getResult(stmt, sql);
                    
                    if(result != null) {
                        while(result.next()){
                            //Retrieve by column name
                            String id  = result.getString("id");
                            String student_name = result.getString("student_name");
                            String university = result.getString("university");

                            /* Adds new student in list */
                            tmp_student = new Student(id, student_name, university);
                            studentList.add(tmp_student);
                        }
                    }
                    else {
                        System.out.println("This university is empty.");
                    }
                }
                else if (this.getLocalName().compareTo("UEB") == 0){
                    System.out.println("Agent UEB");
                    sql = "select * from student_ueb";
                    result = jdbc.getResult(stmt, sql);
                    
                    if(result != null) {
                        while(result.next()){
                            //Retrieve by column name
                            String id  = result.getString("id");
                            String student_name = result.getString("student_name");
                            String university = result.getString("university");

                            /* Adds new student in list */
                            tmp_student = new Student(id, student_name, university);
                            studentList.add(tmp_student);
                        }
                    }
                    else {
                        System.out.println("This university is empty.");
                    }
                }
                else {
                    System.out.println("Agent HUS");
                    sql = "select * from student_hus";
                    result = jdbc.getResult(stmt, sql);
                    
                    if(result != null) {
                        while(result.next()){
                            //Retrieve by column name
                            String id  = result.getString("id");
                            String student_name = result.getString("student_name");
                            String university = result.getString("university");

                            /* Adds new student in list */
                            tmp_student = new Student(id, student_name, university);
                            studentList.add(tmp_student);
                        }
                    }
                    else {
                        System.out.println("This university is empty.");
                    }
                }
            }
        }
        catch (SQLException e) {
            System.out.println("Can not create statement object");
            e.printStackTrace();
        }
        /*
        System.out.println("-------------------------");
        for(int i = 0; i < studentList.size(); i ++) {
            System.out.println(studentList.get(i).getId());
            System.out.println(studentList.get(i).getName());
            System.out.println(studentList.get(i).getUniversity());
        }
        System.out.println("-------------------------");*/
    }
    
    public void setStudentList(ArrayList<Student> student_list) {
        this.studentList = student_list;
    }
    
    public ArrayList<Student> getStudentList() {
        return this.studentList;
    }
}

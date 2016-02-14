/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentManager;

/**
 *
 * @author hunglv
 */
public class Student {
    private String name;
    private String id;
    private String university;
    
    /* Override default constructor */
    public Student() {
        name = "";
        id = "";
        university = "";
    }
    
    public Student(String id, String name, String university) {
        this.name = name;
        this.id    = id;
        this.university = university;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    
    public void setUniversity(String university) {
        this.university = university;
    }
    
    public String getUniversity() {
        return university;
    }
}

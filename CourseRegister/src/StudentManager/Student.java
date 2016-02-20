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
    private float mark;
    
    /* Override default constructor */
    public Student() {
        name = "";
        id = "";
        university = "";
        mark = 0;
    }
    
    public Student(String id, String name, String university, float mark) {
        this.name = name;
        this.id = id;
        this.university = university;
        this.mark = mark;
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
    
    public void setMark(float mark) {
        this.mark = mark;
    }
    
    public float getMark() {
        return mark;
    }
}

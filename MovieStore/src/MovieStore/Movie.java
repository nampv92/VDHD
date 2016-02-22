/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovieStore;

/**
 *
 * @author hunglv
 */
public class Movie {
    private String name;  // Name of movie
    private float duration; // Time to borrow a movie
    private float price;  // Price to borrow
    private int value;
    
    /* Override default constructor */
    public Movie() {
        name = "";
        duration = 0;
        price = 0;
        value = 0;
    }
    
    public Movie(String name, float duration, float price, int value) {
        this.name = name;
        this.duration = duration;
        this.price = price;
        this.value = value;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setDuration(float duration) {
        this.duration = duration;
    }
    
    public float getDuration() {
        return duration;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }
   
    public float getPrice() {
        return price;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}

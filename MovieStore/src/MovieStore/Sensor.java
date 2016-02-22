/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovieStore;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import java.util.Random;

/**
 * This class simulate a sensor that gather data
 * about environment every 3s
 * 
 * @author hunglv
 */
public class Sensor extends Agent {
    public int MAX = 40;
    public int MIN = 0;
    Random rand;
    double temperature; // The temperature in room
    int hour;        // The current hour
    int min;         // The current minute
    int second;      // The curren second
    
    

    protected void setup() {
        rand = new Random();
        this.addBehaviour(new TickerBehaviour(this, 3000) {
            
            @Override
            protected void onTick() {
                temperature = (rand.nextFloat() * MAX) + MIN;
;
            }
        });
    }
}

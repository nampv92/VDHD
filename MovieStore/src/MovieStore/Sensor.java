/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovieStore;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.TickerBehaviour;
import java.util.Random;

/**
 * This class simulate a sensor that gather data
 * about environment every 3s
 * 
 * @author hunglv
 */
public class Sensor extends Agent {
    Random rand;
    float temperature; // The temperature in room
    float time;        // The time auto generate to power on device
    
    

    protected void setup() {
        rand = new Random();
        this.addBehaviour(new TickerBehaviour(this, 3000) {
            
            @Override
            protected void onTick() {
                temperature = rand.nextFloat(40.0) + 1;
            }
        });
    }
}

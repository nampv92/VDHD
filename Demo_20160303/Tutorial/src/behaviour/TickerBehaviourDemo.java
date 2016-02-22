/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviour;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

/**
 *
 * @author hunglv
 */
public class TickerBehaviourDemo extends Agent {
    int i = 0;
    protected void setup() {
        this.addBehaviour(new TickerBehaviour(this, 3000) {
            
            @Override
            protected void onTick() {
                System.out.println("Ticker behavior " + i + " - Run every 3s");
                i ++;
            }
        });
    }
}

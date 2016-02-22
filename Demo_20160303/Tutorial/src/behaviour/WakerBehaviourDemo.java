/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviour;

import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;

/**
 *
 * @author hunglv
 */
public class WakerBehaviourDemo extends Agent {
    protected void setup() {
        this.addBehaviour(new WakerBehaviour(this, 3000) {
            protected void handleElapsedTimeout(){
                System.out.println("Hung Le");
            }
        
        });
    }
}

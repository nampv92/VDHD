/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviour;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

/**
 *
 * @author hunglv
 */
public class CyclicBehaviourDemo extends Agent {
    protected void setup() {
        this.addBehaviour(new MyBehaviour(this));
    }

    private static class MyBehaviour extends CyclicBehaviour {

        public MyBehaviour(CyclicBehaviourDemo aThis) {
        }

        @Override
        public void action() {
            System.out.println("Cyclic behaviour demo!");
        }
    }
}

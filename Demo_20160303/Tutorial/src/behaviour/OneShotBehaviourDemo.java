/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviour;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

/**
 *
 * @author hunglv
 */
public class OneShotBehaviourDemo extends Agent {
    protected void setup() {
        this.addBehaviour(new MyBehaviour(this));
    }

    private static class MyBehaviour extends OneShotBehaviour {

        public MyBehaviour(OneShotBehaviourDemo aThis) {
        }

        @Override
        public void action() {
            System.out.println("OneShot behaviour demo!");
        }
    }
}
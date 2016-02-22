/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package behaviour;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

/**
 *
 * @author hunglv
 */
public class GenericBehaviourDemo extends Agent {
    protected void setup() {
        this.addBehaviour(new MyBehaviour());
    }

    private static class MyBehaviour extends Behaviour {
        private static int finish;
        
        public MyBehaviour() {
        }

        @Override
        public void action() {
            switch(finish) {
                case 0:
                    System.out.println("finish = 0");
                    finish ++;
                    break;
                case 1:
                    System.out.println("finish = 1");
                    finish ++;
                    break;
                case 2:
                    System.out.println("finish = 2");
                    finish ++;
                    break;
                case 3:
                    System.out.println("finish = 3");
                    finish ++;
                    break;
            }
                    
        }

        @Override
        public boolean done() {
            return finish == 3;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendmessage;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

/**
 *
 * @author hunglv
 */
public class Receiver extends Agent {
    protected void setup() {
        this.addBehaviour(new MyBehavior(this));
    }

    private static class MyBehavior extends Behaviour {
        MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
        public MyBehavior(Receiver aThis) {
        }

        @Override
        public void action() {
            ACLMessage acl = myAgent.receive(mt);
            
            if (acl != null) {
                System.out.println(myAgent.getLocalName() + " received a message: " + acl.getContent()   );
                ACLMessage rep = acl.createReply();
                rep.setPerformative(ACLMessage.INFORM);
                rep.setContent("OK, I received a message");
                myAgent.send(rep);
            }
            else {
                this.block();
            }
        }

        @Override
        public boolean done() {
            return false;
        }
    }
}

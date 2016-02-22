/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendmessage;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import javax.sound.midi.Soundbank;

/**
 *
 * @author hunglv
 */
public class Sender extends Agent {
    protected void setup() {
        sendMessage();
        this.addBehaviour(new MyBehavior(this));
    }

    private void sendMessage() {
        AID r = new AID("receiver", AID.ISLOCALNAME);
        ACLMessage acl = new ACLMessage(ACLMessage.REQUEST);
        acl.addReceiver(r);
        
        acl.setContent("Hello, my name is sender.");
        this.send(acl);
    }

    private static class MyBehavior extends Behaviour {
        MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
        private static int finish;
                
        public MyBehavior(Sender aThis) {
        }

        @Override
        public void action() {
            ACLMessage acl = myAgent.receive(mt);
            
            if (acl != null) {
                System.out.println(myAgent.getLocalName() + " received a reply: " + acl.getContent() + " from " + acl.getSender());
                finish = 1;
            }
            else {
                this.block();
            }
        }

        @Override
        public boolean done() {
            return finish == 1;
        }
    }
}

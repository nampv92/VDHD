/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SmartHome;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

/**
 *
 * @author hunglv
 */
public class AirConditional extends Agent {
    protected void setup() {
        DFAgentDescription yellow_page = new DFAgentDescription();
        yellow_page.setName(getAID());
        ServiceDescription service = new ServiceDescription();
        service.setName("Smart Device");
        service.setType("SmartHome");
        yellow_page.addServices(service);
        
        try {
            DFService.register(this, yellow_page);
        }
        catch (FIPAException e) {
            System.out.println("Do not allow this agent registers to yellow page.");
        }
        
        addBehaviour(new ReceiveInfoBehaviour());
    }
    
    private class ReceiveInfoBehaviour extends CyclicBehaviour {
        //private static int finish;
        
        public ReceiveInfoBehaviour() {
        }

        @Override
        public void action() {
            MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
            ACLMessage msg = myAgent.receive(mt);
            if(msg != null) {
                String envInfo[] = msg.getContent().split(",");
                for(String s: envInfo)
                    System.out.println(s);
            }
        }
    }
}

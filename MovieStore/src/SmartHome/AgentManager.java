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
public class AgentManager extends Agent {
    SmartHomeUI smartHome;
    protected void setup() {
        smartHome = new SmartHomeUI();
        smartHome.setVisible(true);
        
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
        
        addBehaviour(new DisplayInfoBehaviour());
    }
        private class DisplayInfoBehaviour extends CyclicBehaviour {
            //private static int finish;
        
            public DisplayInfoBehaviour() {
            }

            @Override
            public void action() {
                MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.CONFIRM);
                ACLMessage msg = myAgent.receive(mt);
                if(msg != null) {
                    String status = msg.getContent();
                    char prex = status.charAt(0);
                    int state = Integer.valueOf(status.charAt(1) + "");
                    switch(prex) {
                        case 'A':
                            System.out.println(prex + state);
                            smartHome.setAir(state);
                            break;
                        case 'R':
                            System.out.println(prex + state);
                            smartHome.setAir(state);
                            break;
                        case 'L':
                            System.out.println(prex + state);
                            smartHome.setLam(state);
                            break;
                        case 'F':
                            System.out.println(prex + state);
                            smartHome.setFan(state);
                            break;
                        case 'T':
                            System.out.println(prex + state);
                            smartHome.setTV(state);
                            break;
                        case 'W':
                            System.out.println(prex + state);
                            smartHome.setWash(state);
                            break;
                        default:
                            break;
                    }
                }
            }
    }
}
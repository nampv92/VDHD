/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SmartHome;

import jade.core.AID;
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
public class Television extends Agent {
    int state;
    int level;
    private AID[] managerAgent;
    DFAgentDescription template;

    protected void setup() {
        DFAgentDescription yellow_page = new DFAgentDescription();
        yellow_page.setName(getAID());
        ServiceDescription service = new ServiceDescription();
        service.setName("Smart Device");
        service.setType("SmartHome");
        yellow_page.addServices(service);

        try {
            DFService.register(this, yellow_page);
        } catch (FIPAException e) {
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
            if (msg != null) {
                String envInfo[] = msg.getContent().split(",");
                if ((Integer.parseInt(envInfo[3]) >= 18 && Integer.parseInt(envInfo[4]) >= 30
                        && Integer.parseInt(envInfo[3]) <= 22) || (Integer.parseInt(envInfo[3]) >= 6
                        && Integer.parseInt(envInfo[3]) <= 7)) {
                    state = 1;
                }
                else {
                    state = 0;
                }
                try {
                    DFAgentDescription[] result = DFService.search(myAgent, template);
                    managerAgent = new AID[result.length];

                    // Assign name for agent receives message
                    for (int i = 0; i < managerAgent.length; i++) {
                        if (result[i].getName().toString().contains("manager")) {
                            managerAgent[i] = result[i].getName();
                        }
                    }
                } catch (FIPAException fe) {
                    fe.printStackTrace();
                }

                ACLMessage cfp = new ACLMessage(ACLMessage.CONFIRM);

                // Add list agent receiver request
                for (int i = 0; i < managerAgent.length; ++i) {
                    cfp.addReceiver(managerAgent[i]);
                }

                cfp.setContent("T" + state);
                myAgent.send(cfp);
            }
        }
    }
}

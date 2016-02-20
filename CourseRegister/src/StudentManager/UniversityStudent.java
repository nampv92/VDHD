/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentManager;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author hunglv
 */
public class UniversityStudent extends Agent {
    private String studentID = null;
    private String studentName = null;
    private AID[] universityAgents;

    public void setup() {
        Object[] args = getArguments();
        if (args != null && args.length > 0) { /* List of searchers */
            studentName = args[0].toString().trim();
            
            // Check wheather user want to find ID or not
            if(args.length >= 2)
                studentID = args[1].toString().trim();
            
            addBehaviour(new TickerBehaviour(this, 5000) {
                protected void onTick() {
                    // Update the list of seller agents
                    DFAgentDescription template = new DFAgentDescription();
                    ServiceDescription sd = new ServiceDescription();
                    sd.setType("UniversityMng");
                    template.addServices(sd);
                    try {
                        DFAgentDescription[] result = DFService.search(myAgent, template);
                        universityAgents = new AID[result.length];
                        
                        // Assign name for agent receives message
                        for(int i = 0; i < universityAgents.length; i ++) {
                            universityAgents[i] = result[i].getName();
                        }
                    } catch (FIPAException fe) {
                        fe.printStackTrace();
                    }

                    ACLMessage cfp = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);

                    // Add list agent receiver request
                    for (int i = 0; i < universityAgents.length; ++i) {
                        cfp.addReceiver(universityAgents[i]);
                    }
                    
                    if(studentID != null)
                        cfp.setContent(studentName + "," + studentID);
                    else
                        cfp.setContent(studentName);
                    myAgent.send(cfp);
                }
            });

        }
    }

    private class FindStudentBehaviour extends Behaviour {

        public FindStudentBehaviour() {
        }

        @Override
        public void action() {
            ACLMessage cfp = new ACLMessage(ACLMessage.INFORM);

            // Add list agent receiver request
            for (int i = 0; i < universityAgents.length; ++i) {
                cfp.addReceiver(universityAgents[i]);
            }

            cfp.setContent(studentName);
            myAgent.send(cfp);
        }

        @Override
        public boolean done() {
            return false;
        }
    }
}

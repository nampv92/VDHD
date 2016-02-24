/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SmartHome;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import java.util.Random;

/**
 * This class simulate a sensor that gather data about environment every 3s
 *
 * @author hunglv
 */
public class Sensor extends Agent {

    public int MAX = 40;
    public int MIN = 0;
    Random rand;
    double temperature; // The temperature in room
    int hour;        // The current hour
    int min;         // The current minute
    int second;      // The curren second
    private AID[] deviceAgents;
    DFAgentDescription template;

    protected void setup() {
        // Create a random object to generate random number
        rand = new Random();

        template = new DFAgentDescription();
        ServiceDescription sd = new ServiceDescription();
        sd.setType("SmartHome");
        template.addServices(sd);

        this.addBehaviour(new TickerBehaviour(this, 3000) {
            @Override
            protected void onTick() {

                try {
                    DFAgentDescription[] result = DFService.search(myAgent, template);
                    deviceAgents = new AID[result.length];

                    // Assign name for agent receives message
                    for (int i = 0; i < deviceAgents.length; i++) {
                        deviceAgents[i] = result[i].getName();
                    }
                } catch (FIPAException fe) {
                    fe.printStackTrace();
                }

                ACLMessage cfp = new ACLMessage(ACLMessage.INFORM);

                // Add list agent receiver request
                for (int i = 0; i < deviceAgents.length; ++i) {
                    cfp.addReceiver(deviceAgents[i]);
                }
                temperature = (rand.nextFloat() * MAX) + MIN;
                temperature = (float) Math.round((temperature * 10 / 10));
                hour = rand.nextInt(24);
                min = rand.nextInt(60);
                second = rand.nextInt(60);
                cfp.setContent(temperature + "," + hour + "," + min + "," + second);
                myAgent.send(cfp);
            }
        });
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial;

import jade.core.Agent;

/**
 *
 * @author hunglv
 */
public class HelloWorld extends Agent {
    protected void setup(){
        Object args[] = this.getArguments();
        
        System.out.println("Hello, my name is " + this.getLocalName());
        System.out.println("Hello, my name is " + this.getName());
        
        if(args != null && args.length >= 0) {
            System.out.println("Args is: " + args[0]);
        }
        else {
            System.out.println("Nothing");    
        }
    }
}

package MovieStore;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hunglv
 */
public class Resource {
    public Properties getResource(String resource) {
        InputStream stream = null;
        Properties properties = new Properties();
        
        try {
            stream = this.getClass().getClassLoader().getResourceAsStream(resource);
            properties.load(stream);
        }
        catch (IOException e) {
            System.out.println("I/O exception");
            e.printStackTrace();
            
        }
        catch (NullPointerException e) {
            System.out.println("Null pointer exception");
            e.printStackTrace();
        }
        finally {
            try {
                if(stream != null)
                    stream.close();
            }
            catch (IOException e) {
                System.out.println("Problem when closing file!");
                e.printStackTrace();
            }
        }
        
        return properties;
    }
}

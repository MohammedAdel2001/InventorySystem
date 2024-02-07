
package lab4;

import java.util.ArrayList;


public abstract class database {
     String filename;
    
    ArrayList records = new ArrayList();
   
    public abstract void readFromFile();
        
    
    
    public abstract boolean contains(String k);
    
   
    
    public abstract void deleteRecord(String x);
    
    public abstract void saveToFile();
    
    
    
}

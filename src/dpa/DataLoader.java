package dpa;

/**
 * Load data 
 * @author brian.compter
 */
public class DataLoader implements Runnable{
    
    /**
     * A reference to the Dpa object
     */
    Dpa dpa;
    
    /**
     * Create a new DataLoader object
     */
    public DataLoader(Dpa d)
    {
        dpa = d;
    }
    
    /**
     * Load up our data
     */
    public void run()
    {
        
    }  // end run
    
}  // end DataLoader

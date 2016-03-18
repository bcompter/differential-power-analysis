package dpa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

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
     * Collection of all data points to analyze
     */
    ArrayList <DataPoint> dataPoints;
    
    /**
     * Create a new DataLoader object
     */
    public DataLoader(Dpa d, ArrayList <DataPoint> dp)
    {
        dpa = d;
        dataPoints = dp;
    }
    
    /**
     * Load up our data
     */
    public void run()
    {
        dataPoints.clear();
        
        String plainTextFileName = "data/Plaintext.txt";
        String cipherTextFileName = "data/Cipher.txt";
        String powerTraceFileName = "data/powertrace_Time_Point.txt";
        
        // Progress tracking
        int totalItemsToLoad = 70000*3;
        float percentPerItem = 100.0f/totalItemsToLoad;
        float percentComplete = 0.0f;
        
        try {
            
            // Plaintext
            BufferedReader plainTextBr = new BufferedReader(new FileReader(plainTextFileName));
            String tempStr;
            while ((tempStr = plainTextBr.readLine()) != null)
            {
                DataPoint dp = new DataPoint();
                String[] split = tempStr.split(" ");
                for (int i = 0; i < split.length; i++)
                {
                    dp.plainText[i] = (byte)Integer.parseInt(split[i], 16);
                }
                dataPoints.add(dp);
                percentComplete += percentPerItem;
                dpa.UpdateProgress((int)percentComplete);
            }
            plainTextBr.close();
            
            // Ciphertext
            int count = 0;
            BufferedReader cipherTextBr = new BufferedReader(new FileReader(cipherTextFileName));
            while ((tempStr = cipherTextBr.readLine()) != null)
            {
                DataPoint dp = dataPoints.get(count++);
                String[] split = tempStr.split(" ");
                for (int i = 0; i < split.length; i++)
                {
                    dp.cipherText[i] = (byte)Integer.parseInt(split[i], 16);
                }
                percentComplete += percentPerItem;
                dpa.UpdateProgress((int)percentComplete);
            }
            cipherTextBr.close();
            
            // Power trace
            count = 0;
            BufferedReader powerTraceBr = new BufferedReader(new FileReader(powerTraceFileName));
            while ((tempStr = powerTraceBr.readLine()) != null)
            {
                DataPoint dp = dataPoints.get(count++);
                dp.power = Float.parseFloat(tempStr);
                percentComplete += percentPerItem;
                dpa.UpdateProgress((int)percentComplete);
            }
            powerTraceBr.close();
            dpa.UpdateProgress(100);
        }
        catch(Exception e)
        {
            System.err.println("Dpa::LoadData EXCEPTION -> " + e.getMessage());
        }
    }  // end run
    
}  // end DataLoader

package dpa;

import gui.Gui;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

/**
 *
 * @author brian.compter
 */
public class Dpa {
    
    /**
     * A reference to the gui for display purposes
     */
    Gui gui;
    
    /**
     * Collection of all data points to analyze
     */
    ArrayList <DataPoint> dataPoints;
    
    /**
     * Average power usage across all data points
     */
    float averagePower;
    
    /**
     * Standard deviation of power
     */
    float stdDeviation;
    
    /**
     * Create a new Dpa Object
     * @param g 
     */
    public Dpa (Gui g)
    {
        gui = g;
        dataPoints = new ArrayList();
    }
    
    /**
     * Load data from files
     */
    public void LoadData()
    {
        DataLoader dl = new DataLoader(this, dataPoints);
        SwingUtilities.invokeLater(dl);     
    }
    
    /**
     * Update data loading progress
     */
    public void UpdateProgress(int p)
    {
        gui.UpdateProgress(p);
    }
    
    /**
     * Perform our Differential Power Analysis
     */
    public void PerformDPA()
    {
        // Calculate average power
        averagePower = Average();
        
        // Calculate standard deviation
        stdDeviation = StandardDeviation(averagePower);
        
        System.out.println("Complete...");
        
    }  // end PerformDPA
    
    
    /**
     * Calculate the average power usage
     * @return 
     */
    private float Average()
    {        
        float sum = 0;
        for (int i = 0; i < dataPoints.size(); i++)
        {
            sum += dataPoints.get(i).power;
        }
        return sum / dataPoints.size();
    }
    
    /**
     * Calculate the standard deviation
     * @return 
     */
    private float StandardDeviation(float avg)
    {
        float variance = 0;
        for (int i = 0; i < dataPoints.size(); i++)
        {
            variance += Math.pow(dataPoints.get(i).power - avg, 2);
        }
        variance /= dataPoints.size();
        return (float)Math.sqrt(variance);        
    }
    
}  // end Dpa

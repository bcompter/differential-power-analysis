package dpa;

/**
 * A collection of known data that together make up a 
 */
public class DataPoint {
    
    /**
     * Plaintext input
     */
    int [] plainText = new int [16];
    
    /**
     * Ciphertext output
     */
    int [] cipherText = new int [16];
    
    /**
     * Power usage at the 2664th data point
     */
    float power;
    
    /**
     * 
     */
    int selectionBit;
    
}  // end DataPoint

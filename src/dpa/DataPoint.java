package dpa;

/**
 * A collection of known data that together make up a 
 */
public class DataPoint {
    
    /**
     * Plaintext input
     */
    byte [] plainText = new byte [16];
    
    /**
     * Ciphertext output
     */
    byte [] cipherText = new byte [16];
    
    /**
     * Power usage at the 2664th data point
     */
    float power;
    
}  // end DataPoint

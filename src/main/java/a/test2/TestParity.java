/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a.test2;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 *
 * @author ekaterina
 */
public class TestParity {
    
    @Test
    public void testNullArray() {
        
       byte[] data = new byte[]{0, 0, 0, 0};
       int checksum = 0;
            for (byte b : data) {
                int count = 0;
                    while (b != 0) {
                        if ((b & 1) == 1) {
                            count++;
                        }
                        b >>= 1;
                    }
                    checksum += count;
            }
       checksum = checksum%2;
       Assert.assertEquals(checksum, 0);
        
    }
    
    @Test
    public void testRandomArray() {
        
       byte[] data = new byte[]{0, 1, 1, 1, 0};
       int checksum = 0;
            for (byte b : data) {
                int count = 0;
                    while (b != 0) {
                        if ((b & 1) == 1) {
                            count++;
                        }
                        b >>= 1;
                    }
                    checksum += count;
            }
       checksum = checksum%2;
       Assert.assertEquals(checksum, 1);
        
    }
    
    @Test
    public void testUnitArray() {
        
       byte[] data = new byte[]{1, 1, 1, 1, 1};
       int checksum = 0;
            for (byte b : data) {
                int count = 0;
                    while (b != 0) {
                        if ((b & 1) == 1) {
                            count++;
                        }
                        b >>= 1;
                    }
                    checksum += count;
            }
       checksum = checksum%2;
       Assert.assertEquals(checksum, 1);
        
    }
    
}

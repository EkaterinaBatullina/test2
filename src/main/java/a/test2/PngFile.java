/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a.test2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author ekaterina
 */

public class PngFile {
    private String name;
    private Map<Integer, byte[]> dataMap= new TreeMap<>();
    //набор данных небольшой, можем использовать TreeMap для хранения данных в порядке возрастания
    
    public PngFile(String name) {
        
        this.name = name;
        
    }
    
    public void combineData() {
        
        try (FileOutputStream outputStream = new FileOutputStream(name)) {
            for (byte[] data : dataMap.values()) {
                outputStream.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        
    }
    
    public void fillMap(Integer key, byte[] value) {
        
        dataMap.put(key, value);
        
    }
    
}

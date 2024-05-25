/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package a.test2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.InputStream;


/**
 *
 * @author ekaterina
 */
public class Test2 {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {


        
        PngFile pngFile = new PngFile("/Users/ekaterina/Downloads/v4.png");
        
        FileThread first = new FileThread ("/Users/ekaterina/Downloads/папка/1", pngFile);
        first.start(); 
        FileThread second = new FileThread ("/Users/ekaterina/Downloads/папка/2", pngFile);
        second.start(); 
        FileThread third = new FileThread ("/Users/ekaterina/Downloads/папка/3", pngFile);
        third.start(); 
        FileThread fourth = new FileThread ("/Users/ekaterina/Downloads/папка/4", pngFile);
        fourth.start(); 
        FileThread fiveth = new FileThread ("/Users/ekaterina/Downloads/папка/5", pngFile);
        fiveth.start(); 
        FileThread sixth = new FileThread ("/Users/ekaterina/Downloads/папка/6", pngFile);
        sixth.start(); 
        FileThread seventh = new FileThread ("/Users/ekaterina/Downloads/папка/7", pngFile);
        seventh.start();  
        FileThread eigth = new FileThread ("/Users/ekaterina/Downloads/папка/8", pngFile);
        eigth.start(); 
        
        first.join();
        second.join();
        third.join();
        fourth.join();
        fiveth.join();
        sixth.join();
        seventh.join();
        eigth.join(); 
              
        pngFile.combineData();
        
        TestParity test = new TestParity();
        test.testNullArray();
        test.testRandomArray();
        test.testUnitArray();
        
        
    }
}

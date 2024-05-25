/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a.test2;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ekaterina
 */
public class FileThread extends Thread {
    private String fileName;
    private int size;
    private byte[] data;
    private int parity;
    private int part;
    private PngFile pngFile;
    
    public FileThread(String fileName, PngFile pngFile) {
        
        this.fileName =  fileName;
        this.pngFile = pngFile;
        
    }
    
    @Override
    public void run() {
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(fileName))) {
        //для считывания разных типов данных используем DataInputStream
        
            // пока количество доступных байт больше 0
            while (inputStream.available() > 0) {
                
            //1. Прочитать содержимое файлов; каждый файл содержит размер фрагмента картинки, данные фрагмента картинки, 
            //контрольное число, номер фрагмента картинки [0..7] для определения порядка соединения фрагментов.
     
            // Чтение размера блока данных
            size = inputStream.readInt();

            // Создание буфера для данных
            data = new byte[size];

            // Чтение данных с фрагментом картинки
            inputStream.readFully(data);

            // Чтение контрольного числа четности
            parity = inputStream.readInt();

            // Чтение номера фрагмента картинки
            part = inputStream.readInt();
            
            int checksum = 0;
//            for (byte b : data) {
//                int count = 0;
//                    while (b != 0) {
//                        if ((b & 1) == 1) {
//                            count++;
//                        }
//                        b >>= 1;
//                    }
//                    checksum += count;
//            }
            checksum = checksum%2;

            synchronized (pngFile) {
                 pngFile.fillMap(part, data);
            }
                
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    
}

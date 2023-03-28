package com.usatu;
import com.usatu.processor.CsvDataProcessor;
import com.usatu.processor.DataProcessor;
import com.usatu.processor.DataProcessorService;
import com.usatu.processor.TxtDataProcessor;
import joinery.*;

/**
 *   Main-класс с функцией main - это точка входа для Java-приложения.
 */

public class AppMain  {

    public static void main(String[] args) {
        // Без указания полного пути, программа будет читать файл из своей корневой папки
        DataProcessorService service = new DataProcessorService("C:\\Games\\pikpo3_java\\dataprocessorlab\\seeds_dataset.csv");

        service.runService();
        /*AppMain main=new AppMain();
        main.printResult();*/




    }




}

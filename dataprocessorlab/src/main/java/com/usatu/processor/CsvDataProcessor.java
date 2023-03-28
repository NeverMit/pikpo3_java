package com.usatu.processor;
import joinery.DataFrame;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Реализация абстрактного класса DataProcessor для обработчика csv-файлов
 */

public class CsvDataProcessor extends DataProcessor {

    private final String[] separators = {";", ",", "|"};     // список возможных разделителей столбцов csv-файла

    @Override
    public boolean read() {
        // Читаем файл данных
        File datasetFile = new File(this.datasource);
        InputStream dataStream = null;
        // Пытаемся преобразовать данные файла в DataFrame с помощью встроенной функции readCsv, используя различные разделители
        for (String separator: separators) {
            try {
                dataStream = Files.newInputStream(datasetFile.toPath());
                dataset = DataFrame.readCsv(dataStream, separator);
                // Если DataFrame создан и количество прочитанных колонок > 1, возвращаем результат true (данные успешно прочитаны)
                if (null != dataset && dataset.columns().size() > 1) {
                    // Выводим количество считанных из файла колонок
                    System.out.println("Columns read: " + dataset.columns() + " using separator " + separator);
                    return true;
                }
            } catch (IOException e) {
                System.out.println("Datasource error: ");
                e.printStackTrace();
                //System.out.println("Can't read using separator: " + separator);
            }
        }
        return false;
    }
    DataFrame newDF=null;
    @Override
    public void run() {
        result = sortByColName(dataset, "A", true);
        DataFrame myDS=dataset.drop(2,3,4);
        /*   System.out.println(myDS.columns());
        System.out.println(myDS.row(189));*/
        newDF=sortByColName(myDS,"A",true);
    }

    @Override
    public void printResult() {
        System.out.println("CSV-file processor result:\n" + result);
        System.out.println("New dataset \n"+newDF);
    }

}


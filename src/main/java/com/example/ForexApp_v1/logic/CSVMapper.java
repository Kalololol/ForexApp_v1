package com.example.ForexApp_v1.logic;

import com.example.ForexApp_v1.model.Transac;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
@Service
public class CSVMapper {

    public List<Transac> readingFromFile(String fileName){

        Path file = Paths.get(fileName + ".csv");
        List<String> arrayFromFile = new ArrayList<String>();
        List<Transac> transactionArrayList = new ArrayList<>();

        try {
            arrayFromFile = (ArrayList<String>) Files.readAllLines(file);
            for (String readLine : arrayFromFile){
                String[] lineFromArray = readLine.split(",");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(lineFromArray[0], formatter);
                double valueCurrency = Double.parseDouble(lineFromArray[2]);

                transactionArrayList.add(new Transac(date, lineFromArray[1], valueCurrency));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return transactionArrayList;
    }
}
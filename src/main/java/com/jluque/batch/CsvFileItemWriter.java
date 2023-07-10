package com.jluque.batch;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CsvFileItemWriter implements ItemWriter<Customer> {

    private static final String CSV_FILE_PATH = "output.csv";


    @Override
    public void write(Chunk<? extends Customer> customers) throws Exception {

        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE_PATH, true))) {
            for (Customer customer : customers) {
                writer.println(customer.getId() + "," + customer.getName() + "," + customer.getEmail());
            }
        } catch (IOException e) {
            throw new Exception("Error while writing to CSV file", e);
        }
    }

//    @Override
//    public void write(Chunk<? extends Customer> chunk) throws Exception {
//
//    }
}

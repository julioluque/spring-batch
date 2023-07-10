package com.jluque.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final DatabaseItemReader databaseItemReader;
    private final CsvFileItemWriter csvFileItemWriter;

    @Autowired
    public BatchConfiguration(JobBuilderFactory jobBuilderFactory,
                              StepBuilderFactory stepBuilderFactory,
                              DatabaseItemReader databaseItemReader,
                              CsvFileItemWriter csvFileItemWriter) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.databaseItemReader = databaseItemReader;
        this.csvFileItemWriter = csvFileItemWriter;
    }

    @Bean
    public Step myStep() {
        return stepBuilderFactory.get("myStep")
                .<Customer, Customer>chunk(10)
                .reader(databaseItemReader)
                .writer(csvFileItemWriter)
                .build();
    }

    @Bean
    public Job myJob() {
        return jobBuilderFactory.get("myJob")
                .incrementer(new RunIdIncrementer())
                .flow(myStep())
                .end()
                .build();
    }
}


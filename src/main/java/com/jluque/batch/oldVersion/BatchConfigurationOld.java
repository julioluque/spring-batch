package com.jluque.batch.oldVersion;

//import com.jluque.batch.entity.Student;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.database.JdbcCursorItemReader;
//import org.springframework.batch.item.file.FlatFileItemWriter;
//import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
//import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.jdbc.core.RowMapper;
//
//import javax.sql.DataSource;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//@Configuration
//@EnableBatchProcessing
//@ComponentScan("com.jluque.batch.config")
public class BatchConfigurationOld {
//
//
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Bean
//    public JdbcCursorItemReader<Student> reader() {
//        JdbcCursorItemReader<Student> reader = new JdbcCursorItemReader<Student>();
//        reader.setDataSource(dataSource);
//        reader.setSql("select id, firstName, lastName, email from batchdata");
//        reader.setRowMapper(new RowMapper<Student>() {
//            @Override
//            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Student s = new Student();
//                s.setId(rs.getInt("id"));
//                s.setFirstName(rs.getString("fistName"));
//                s.setLastName(rs.getString("lastName"));
//                s.setEmail(rs.getString("email"));
//                return s;
//            }
//        });
//        return reader;
//    }
//
//
//    @Bean
//    public FlatFileItemWriter<Student> writer() {
//        FlatFileItemWriter<Student> writer = new FlatFileItemWriter<Student>();
//        writer.setResource(new FileSystemResource("C:\\temp\\batch\\output.csv"));
//        DelimitedLineAggregator<Student> aggregator = new DelimitedLineAggregator<>();
//        BeanWrapperFieldExtractor<Student> filedExtractor = new BeanWrapperFieldExtractor<>();
//        filedExtractor.setNames(new String[]{"id", "firstName", "lastName", "email"});
//        aggregator.setFieldExtractor(filedExtractor);
//        writer.setLineAggregator(aggregator);
//        return writer;
//    }
//
//    @Bean
//    public Step executeStep() {
//        return stepBuilderFactory
//                .get("executeStep")
//                .<Student, Student>chunk(10)
//                .reader(reader())
//                .writer(writer())
//                .build();
//    }
//
//
//    @Bean
//    public Job processJob() {
//        return jobBuilderFactory
//                .get("processJob")
//                .incrementer(new RunIdIncrementer())
//                .flow(executeStep())
//                .end()
//                .build();
//    }

}

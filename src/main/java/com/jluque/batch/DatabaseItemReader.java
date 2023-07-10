package com.jluque.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseItemReader implements ItemReader<Customer> {

    private final JdbcTemplate jdbcTemplate;
    private boolean read = false;

    @Autowired
    public DatabaseItemReader(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Customer read() {
        if (!read) {
            List<Customer> customers = jdbcTemplate.query("SELECT * FROM customers", (rs, rowNum) -> {
                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                return customer;
            });

            read = true;

            return customers.isEmpty()? null:customers.get(0);
        }

        return null;
    }

}

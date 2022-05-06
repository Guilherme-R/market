package com.guilhermebrandao.dao.customer;

import com.guilhermebrandao.domain.Customer;
import com.guilhermebrandao.request.CustomerPutRequestBody;
import com.guilhermebrandao.service.exception.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import java.sql.Types;
import java.util.*;

@Component
public class CustomerDaoImpl implements CustomerDao {
    private static final Logger log = LoggerFactory.getLogger(CustomerDaoImpl.class);

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert insertCustomer;

    RowMapper<Customer> rowMapper = (rs, rowNum) -> {
        Customer customer = new Customer();
        customer.setId(rs.getLong("ID_CUSTOMER"));
        customer.setName(rs.getString("NAME"));
        customer.setEmail(rs.getString("EMAIL"));
        customer.setPhone(rs.getString("PHONE"));
        customer.setPassword(rs.getString("PASSWORD"));
        return customer;
    };

    @Autowired
    public CustomerDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.insertCustomer = new SimpleJdbcInsert(jdbcTemplate).withTableName("TR_CUSTOMER").usingGeneratedKeyColumns("ID_CUSTOMER");
    }

    @Override
    public Optional findById(Long id) {
        String sql = "SELECT * FROM TR_CUSTOMER WHERE ID_CUSTOMER = ?";
        Customer customer = null;
        try {
            customer = jdbcTemplate.queryForObject(sql, new Object[]{id}, new int[]{Types.INTEGER}, rowMapper);
        }catch(DataAccessException e){
            throw new ObjectNotFoundException("Customer não encontrado");
        }
        return Optional.ofNullable(customer);
    }

    @Override
    public List<Customer> findAll() {
        String sql = "SELECT * FROM TR_CUSTOMER";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Optional insert(Object obj) {
        Customer customer = (Customer) obj;

        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("NAME", customer.getName());
        parameters.put("EMAIL", customer.getEmail());
        parameters.put("PHONE", customer.getPhone());
        parameters.put("PASSWORD", customer.getPassword());
        Long id = insertCustomer.executeAndReturnKey(parameters).longValue();
        return findById(id);
    }

    @Override
    public void update(Object obj) {
        Customer customer = (Customer) obj;
        String sql = "UPDATE TR_CUSTOMER SET NAME = ?, EMAIL = ?, PHONE = ? WHERE ID_CUSTOMER = ?";
        jdbcTemplate.update(sql, customer.getName(), customer.getEmail(), customer.getPhone(), customer.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM TR_CUSTOMER WHERE ID_CUSTOMER = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updatePassword(Object obj) {
        String sql = "UPDATE TR_CUSTOMER SET PASSWORD = ? WHERE ID_CUSTOMER = ?";
        CustomerPutRequestBody customerPutRequestBody = (CustomerPutRequestBody) obj;
        jdbcTemplate.update(sql, customerPutRequestBody.getNewPassword(), customerPutRequestBody.getId());
    }
}

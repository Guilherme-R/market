package com.guilhermebrandao.dao;

import com.guilhermebrandao.domain.Client;
import com.guilhermebrandao.service.exception.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.Types;
import java.util.List;
import java.util.Optional;

@Component
public class ClientDAO implements DAO{
    private static final Logger log = LoggerFactory.getLogger(ClientDAO.class);

    private final JdbcTemplate jdbcTemplate;

    RowMapper<Client> rowMapper = (rs, rowNum) -> {
        Client client = new Client();
        client.setId(rs.getLong("ID_CLIENT"));
        client.setName(rs.getString("NAME"));
        client.setEmail(rs.getString("EMAIL"));
        client.setPhone(rs.getString("PHONE"));
        return client;
    };

    @Autowired
    public ClientDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Optional findById(Long id) {
        String sql = "SELECT ID_CLIENT, NAME, EMAIL, PHONE FROM TR_CLIENT WHERE ID_CLIENT = ?";
        Client client = null;
        try {
            client = jdbcTemplate.queryForObject(sql, new Object[]{id}, new int[]{Types.INTEGER}, rowMapper);
        }catch(DataAccessException e){
            log.error(e.getMessage());
            throw new ObjectNotFoundException("Cliente não encontrado");
        }
        return Optional.ofNullable(client);
    }

    @Override
    public List<Client> findAll() {
        String sql = "SELECT ID_CLIENT, NAME, EMAIL, PHONE FROM TR_CLIENT";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void insert(Object o) {

    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(Long id) {

    }
}

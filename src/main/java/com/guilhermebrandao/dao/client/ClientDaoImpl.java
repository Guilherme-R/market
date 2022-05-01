package com.guilhermebrandao.dao.client;

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
public class ClientDaoImpl implements ClientDao {
    private static final Logger log = LoggerFactory.getLogger(ClientDaoImpl.class);

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
    public ClientDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional findById(Long id) {
        String sql = "SELECT ID_CLIENT, NAME, EMAIL, PHONE FROM TR_CLIENT WHERE ID_CLIENT = ?";
        Client client = null;
        try {
            client = jdbcTemplate.queryForObject(sql, new Object[]{id}, new int[]{Types.INTEGER}, rowMapper);
        }catch(DataAccessException e){
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
    public void insert(Object obj) {
        Client client = (Client) obj;
        String sql = "INSERT INTO TR_CLIENT (NAME, EMAIL, PHONE, PASSWORD) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, client.getName(), client.getEmail(), client.getPhone(), client.getPassword());
    }

    @Override
    public void update(Object obj) {
        Client client = (Client) obj;
        String sql = "UPDATE TR_CLIENT SET NAME = ?, EMAIL = ?, PHONE = ? WHERE ID_CLIENT = ?";
        jdbcTemplate.update(sql, client.getName(), client.getEmail(), client.getPhone(), client.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM TR_CLIENT WHERE ID_CLIENT = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updatePassword(String newPassword) {
        String sql = "UPDATE TR_CLIENT SET PASSWORD = ? WHERE = ?";
        jdbcTemplate.update(sql, newPassword);
    }
}

package com.guilhermebrandao.dao.order;

import com.guilhermebrandao.domain.Order;
import com.guilhermebrandao.domain.enums.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderDaoImpl implements OrderDao{

    private final JdbcTemplate jdbcTemplate;

    RowMapper<Order> rowMapper = (rs, rowNum) -> {
        Order order = new Order();
        order.setId(rs.getLong("ID_ORDER"));
        order.setMoment(rs.getTimestamp("MOMENT").toLocalDateTime());
        order.setOrderStatus(OrderStatus.valueOf(rs.getInt("ORDER_STATUS")));
        return order;
    };

    @Autowired
    public OrderDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public List<Order> findAllByCustomerId(Long customerId) {
        String sql = "SELECT * FROM TR_ORDER WHERE CUSTOMER_ID = ?";
        return  jdbcTemplate.query(sql, rowMapper, customerId);
    }

    @Override
    public Optional insert(Object o) {
        return Optional.empty();
    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(Long id) {

    }
}

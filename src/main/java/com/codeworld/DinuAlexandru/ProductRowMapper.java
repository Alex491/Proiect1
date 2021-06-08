package com.codeworld.DinuAlexandru;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowCallbackHandler;

public class ProductRowMapper implements RowMapper<Produs> {
    @Override
    public Produs mapRow(ResultSet resultSet, int i) throws SQLException {
        Produs product= new Produs();
        product.setID(resultSet.getLong("id"));
        product.setNume(resultSet.getString("name"));
        product.setPret(resultSet.getInt("price"));
        return product;
    }
}
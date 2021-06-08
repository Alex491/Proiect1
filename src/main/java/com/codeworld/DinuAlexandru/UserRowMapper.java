package com.codeworld.DinuAlexandru;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper  implements RowMapper<Utilizator> {
    @Override
    public Utilizator mapRow(ResultSet resultSet, int i) throws SQLException {

        Utilizator user =new Utilizator();

        user.setMail(resultSet.getString("email"));
        user.setParola(resultSet.getString("Parola"));
        user.setNume(resultSet.getString("Nume"));
        user.setPrenume(resultSet.getString("Prenume"));
        user.setUsername(resultSet.getString("Username"));
        return user;
    }
}

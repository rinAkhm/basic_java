package qa.guru.db;

import org.springframework.jdbc.core.RowMapper;
import qa.guru.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserEntityRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        String username = rs.getString("username");
        String password = rs.getString("password");
        return new User(username, password);
    }
}

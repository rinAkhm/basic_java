package qa.guru.data;

import org.springframework.jdbc.core.JdbcTemplate;
import qa.guru.db.DataSourceProvider;
import qa.guru.db.UserEntityRowMapper;
import qa.guru.domain.User;

import java.util.List;
import java.util.Optional;

public class DataBaseUserRepository implements UserRepository{

    private static final JdbcTemplate  template = new JdbcTemplate(DataSourceProvider.INSTANCE.getInstance());


    @Override
    public Optional<User> findByUsername(String username) {
        List<User> candidate = template.query("SELECT * FROM users WHERE username = ?", new UserEntityRowMapper(), username);
        if(candidate.size() != 0) {
            return Optional.of(candidate.get(0));
        }
        return Optional.empty();
    }
}

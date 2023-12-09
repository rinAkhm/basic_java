package qa.guru.db;

import org.springframework.jdbc.core.RowMapper;
import qa.guru.domain.Note;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NoteEntityRowMapper implements RowMapper<Note> {
    @Override
    public Note mapRow(ResultSet rs, int rowNum) throws SQLException {
        String username = rs.getString("username");
        String password = rs.getString("text");
        return new Note(username, password);
    }
}

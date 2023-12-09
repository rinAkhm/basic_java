package qa.guru.data;

import org.springframework.jdbc.core.JdbcTemplate;
import qa.guru.db.DataSourceProvider;
import qa.guru.db.NoteEntityRowMapper;
import qa.guru.domain.Note;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class DataBaseNoteRepository implements NoteRepository {
    private static final JdbcTemplate template = new JdbcTemplate(DataSourceProvider.INSTANCE.getInstance());

    @Override
    public List<Note> findAllByUsername(String username) {
        List<Note> candidate = template.query("SELECT * FROM notes WHERE username = ?",
                new NoteEntityRowMapper(), username);
        if(candidate.size() != 0) {
            return candidate;
        }
        return Collections.emptyList();
    }

    @Override
    public void save(Note note) {
        Note newNote = Optional.ofNullable(note).orElseThrow();
        template.update("INSERT INTO notes (username, text) values (?, ?)", newNote.username(), newNote.note());
    }
}

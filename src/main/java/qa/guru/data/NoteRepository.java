package qa.guru.data;

import qa.guru.domain.Note;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface NoteRepository {
    List<Note> findAllByUsername(String username);

    void save(Note note);

    class MockNoteRepository implements NoteRepository {
    private static final List<Note> mockNotes = new ArrayList<>(
            List.of(
                    new Note(
                            "dima",
                            "wash the dishes"
                    ),
                    new Note(
                            "dima",
                            "watch football"
                    )
            )
    );

    @Override
    public List<Note> findAllByUsername(String username) {
        if ("dima".equals(username)) {
            return mockNotes;
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public void save(Note note) {
        if ("dima".equals(note.username())) {
            mockNotes.add(note);
        }
    }
}
}

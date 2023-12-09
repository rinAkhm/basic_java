package qa.guru.view;

import qa.guru.data.NoteRepository;
import qa.guru.domain.Note;
import qa.guru.domain.User;
import qa.guru.service.Session;

import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class NotesUiComponent implements UiComponent {
    private final NoteRepository noteRepository;

    public NotesUiComponent(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Session render(Session session) throws IOException {
        User user = session.unwrap();
        showNotes(noteRepository.findAllByUsername(
                user.username()
        ));
        int code = getConfirmation();
        if (code == 0) {
            noteRepository.save(
                    new Note(
                            user.username(),
                            JOptionPane.showInputDialog("New Note:")
                    )
            );
            showNotes(
                    noteRepository.findAllByUsername(
                            user.username()
                    )
            );
        }
        return session;
    }

    private int getConfirmation() {
        return JOptionPane.showConfirmDialog(
                null,
                "Any new notes? (y/n)",
                "Confirm",
                JOptionPane.YES_NO_OPTION
        );
    }

    private void showNotes(List<Note> notes) {
        String notesAsString = notes.stream()
                .map(Note::note)
                .collect(Collectors.joining(", "));

        JOptionPane.showMessageDialog(
                null,
                notesAsString,
                "Current notes:",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}

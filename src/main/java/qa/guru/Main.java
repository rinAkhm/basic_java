package guru.qa;


import qa.guru.data.FileUserRepository;
import qa.guru.data.NoteRepository;
import qa.guru.service.Session;
import qa.guru.view.LoginUiComponent;
import qa.guru.view.NotesUiComponent;
import qa.guru.view.UiComponents;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        new UiComponents(
                new LoginUiComponent(
                        new FileUserRepository(Path.of("users.csv"))
                ),
                new NotesUiComponent(
                        new NoteRepository.MockNoteRepository()
                )
        ).render(
                new Session.MockSession()
        );
    }
}

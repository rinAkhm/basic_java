package qa.guru;

import qa.guru.data.FileNotesRepository;
import qa.guru.data.FileUserRepository;
import qa.guru.service.Session;
import qa.guru.view.LoginUiComponent;
import qa.guru.view.NotesUiComponent;
import qa.guru.view.UiComponents;

import java.io.IOException;
import java.nio.file.Path;

public class MainForFile {
    public static void main(String[] args) throws IOException {
        new UiComponents(
                new LoginUiComponent(
                        new FileUserRepository(Path.of("users.csv"))
                ),
                new NotesUiComponent(
                        new FileNotesRepository(Path.of("notes.csv"))
                )
        ).render(
                new Session.MockSession()
        );
    }
}

package qa.guru;

import qa.guru.data.DataBaseNoteRepository;
import qa.guru.data.DataBaseUserRepository;
import qa.guru.service.Session;
import qa.guru.view.LoginUiComponent;
import qa.guru.view.NotesUiComponent;
import qa.guru.view.UiComponents;

import java.io.IOException;

public class MainFormDb {
    public static void main(String[] args) throws IOException {
        new UiComponents(
                new LoginUiComponent(
                        new DataBaseUserRepository()
                ),
                new NotesUiComponent(
                        new DataBaseNoteRepository()
                )
        ).render(
                new Session.MockSession()
        );
    }
}

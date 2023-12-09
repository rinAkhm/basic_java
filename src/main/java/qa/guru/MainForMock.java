package qa.guru;

import qa.guru.data.DataBaseNotesRepository;
import qa.guru.data.NoteRepository;
import qa.guru.data.UserRepository;
import qa.guru.service.Session;
import qa.guru.view.LoginUiComponent;
import qa.guru.view.NotesUiComponent;
import qa.guru.view.UiComponents;

import java.io.IOException;


public class MainForMock {

    public static void main(String[] args) throws IOException {
        new UiComponents(
                new LoginUiComponent(
                        new UserRepository.MockUserRepository()
                ),
                new NotesUiComponent(
                        new NoteRepository.MockNoteRepository()
                )
        ).render(
                new Session.MockSession()
        );
    }
}

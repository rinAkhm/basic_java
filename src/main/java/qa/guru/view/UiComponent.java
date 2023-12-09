package qa.guru.view;

import qa.guru.service.Session;

import javax.swing.*;
import java.io.IOException;

public interface UiComponent {
    Session render(Session session) throws IOException;

    class MockUiComponent implements UiComponent {
        @Override
        public Session render(Session session) {
            JOptionPane.showMessageDialog(
                    null,
                    "I`m a mock UI component!",
                    "Mock message",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return session;
        }
    }
}

package qa.guru.view;

import qa.guru.service.Session;

import java.io.IOException;

public class UiComponents implements UiComponent {
    private final UiComponent[] components;

    public UiComponents(UiComponent... components) {
        this.components = components;
    }

    @Override
    public Session render(Session session) throws IOException {
        Session sessionFromComponent = session;
        for (UiComponent component : components) {
            sessionFromComponent = component.render(sessionFromComponent);
        }
        return sessionFromComponent;
    }
}

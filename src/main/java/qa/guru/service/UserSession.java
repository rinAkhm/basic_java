package qa.guru.service;

import qa.guru.domain.User;

public class UserSession implements Session {
    private final User user;

    public UserSession(User user) {
        this.user = user;
    }

    @Override
    public User unwrap() {
        return user;
    }
}

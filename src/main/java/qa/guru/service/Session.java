package qa.guru.service;

import qa.guru.domain.User;

public interface Session {
    User unwrap();

    class MockSession implements Session {
        @Override
        public User unwrap() {
            return null;
        }
    }
}

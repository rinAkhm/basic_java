package qa.guru.data;

import qa.guru.domain.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);


    class MockUserRepository implements UserRepository {

        @Override
        public Optional<User> findByUsername(String username) {
            if ("dima".equals(username)) {
                return Optional.of(
                        new User(
                                "dima",
                                "12345"
                        )
                );
            } else {
                return Optional.empty();
            }
        }
    }
}

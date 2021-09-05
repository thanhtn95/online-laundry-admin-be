package online.laundry.onlinelaundryadminbe.repository;

import online.laundry.onlinelaundryadminbe.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findUserByPhoneNumber(String phoneNumber);

    Optional<User> findUserByEmail(String email);

    Boolean existsByUsernameOrPhoneNumberOrEmail(String username, String phoneNumber, String email);
}

package online.laundry.onlinelaundryadminbe.repository;

import online.laundry.onlinelaundryadminbe.models.StaffUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StaffUserRepository extends JpaRepository<StaffUser,Long> {
    Optional<StaffUser> findByUsername(String username);
}

package ua.home.repository;

import org.springframework.data.repository.CrudRepository;
import ua.home.domain.User;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, String> {
}

package ua.home.repository;

import org.springframework.data.repository.CrudRepository;
import ua.home.domen.User;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
}

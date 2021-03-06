package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import javacamp.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{
	boolean existsByEmail(String email); // Emailin mevcut olup olmadığını kontrol edecek.
}

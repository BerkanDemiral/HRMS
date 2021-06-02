package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javacamp.hrms.entities.concretes.User;
@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	boolean existByEmail(String email); // Emailin mevcut olup olmadığını kontrol edecek.
}

package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javacamp.hrms.entities.concretes.SystemPersonnel;
@Repository
public interface SystemPersonnelDao extends JpaRepository<SystemPersonnel, Integer> {
	SystemPersonnel getBySystemPersonnelName(String systemPersonnelName);
	boolean existBySystemPersonnelName(String systemPersonnelName);
}

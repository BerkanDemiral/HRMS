package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javacamp.hrms.entities.concretes.JobPosition;
@Repository
public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
	List<JobPosition> getByJobPosition(String position);
	boolean existByPosition(String position);
}

package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import javacamp.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
	List<JobPosition> getByJobPosition(String position);
	boolean existByPosition(String position);
}

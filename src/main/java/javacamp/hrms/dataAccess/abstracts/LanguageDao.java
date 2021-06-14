package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageDao extends JpaRepository<LanguageDao, Integer>{
	List<LanguageDao> getByResume_Id(int resumeId);
}

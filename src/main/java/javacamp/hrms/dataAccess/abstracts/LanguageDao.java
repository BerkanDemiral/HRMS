package javacamp.hrms.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer>{

}

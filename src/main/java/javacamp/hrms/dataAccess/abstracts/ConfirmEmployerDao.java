package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javacamp.hrms.entities.concretes.ConfirmEmployer;

@Repository
public interface ConfirmEmployerDao extends JpaRepository<ConfirmEmployer, Integer> {
	ConfirmEmployer getByEmployerId(int id); // employer id'sini alacağız bu sayede kontrol gerçekleştirebileceğiz

	boolean exisyByEmployerId(int id);

}

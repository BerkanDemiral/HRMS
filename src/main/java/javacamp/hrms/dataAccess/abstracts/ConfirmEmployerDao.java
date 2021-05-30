package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.ConfirmEmployer;

public interface ConfirmEmployerDao extends JpaRepository<ConfirmEmployerDao, Integer>{
	ConfirmEmployer getByEmployerId(int id); // employer id'sini alacağız bu sayede kontrol gerçekleştirebileceğiz 
	boolean exisyByEmployerId(int id);
	
}
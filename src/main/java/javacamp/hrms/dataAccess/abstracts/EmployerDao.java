package javacamp.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;
import javacamp.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	Employer getByCompanyName(String companyName); // şirket ismini getireceğiz
	boolean existsByCompanyName(String companyName); // daha sonrasında daha önceden tanımlanıp tanımlanmadığı hakkında bilgi döneceğiz.
	Employer getById(int id);
}

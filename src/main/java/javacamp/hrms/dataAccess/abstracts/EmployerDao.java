package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javacamp.hrms.entities.concretes.Employer;
@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer> {
	Employer getByCompanyName(String companyName); // şirket ismini getireceğiz
	List<Employer> getByEmployeryName(String companyName);
	boolean existByCompanyName(String companyName); // daha sonrasında daha önceden tanımlanıp tanımlanmadığı hakkında bilgi döneceğiz.
}

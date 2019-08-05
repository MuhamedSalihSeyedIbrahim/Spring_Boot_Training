package in.tp.scrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.tp.scrud.model.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long>{
	
}

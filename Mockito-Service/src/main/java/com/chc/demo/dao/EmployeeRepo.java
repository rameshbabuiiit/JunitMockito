package com.chc.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.chc.demo.entity.EmployeeEntity;


@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {
	@Query(value = "SELECT * FROM employee WHERE employee.name=?1", nativeQuery = true)
	EmployeeEntity findByEmpName(String name);
}
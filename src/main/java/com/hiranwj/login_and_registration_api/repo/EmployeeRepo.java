package com.hiranwj.login_and_registration_api.repo;

import com.hiranwj.login_and_registration_api.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByEmailAndPassword(String email, String password);

    Employee findByEmail(String email);
}

package com.hiranwj.login_and_registration_api.service.serviceImpl;

import com.hiranwj.login_and_registration_api.dto.EmployeeDto;
import com.hiranwj.login_and_registration_api.dto.LoginDto;
import com.hiranwj.login_and_registration_api.entity.Employee;
import com.hiranwj.login_and_registration_api.repo.EmployeeRepo;
import com.hiranwj.login_and_registration_api.response.LoginResponse;
import com.hiranwj.login_and_registration_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPassword(this.passwordEncoder.encode(employeeDto.getPassword()));

        employeeRepo.save(employee);

        return employee.getName();
    }

    @Override
    public LoginResponse loginEmployee(LoginDto loginDto) {
        Employee email = employeeRepo.findByEmail(loginDto.getEmail());

        if (email != null) {
            String password = loginDto.getPassword();
            String encodedPassword = email.getPassword();

            Boolean isMatch = passwordEncoder.matches(password, encodedPassword);

            if (isMatch) {
                Optional<Employee> employee = employeeRepo.findByEmailAndPassword(loginDto.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else  {
                return new LoginResponse("Password not match", false);
            }
        } else {
            return new LoginResponse("Email not exist", false);
        }
    }
}

package com.hiranwj.login_and_registration_api.service;

import com.hiranwj.login_and_registration_api.dto.EmployeeDto;
import com.hiranwj.login_and_registration_api.dto.LoginDto;
import com.hiranwj.login_and_registration_api.response.LoginResponse;

public interface EmployeeService {

    String addEmployee(EmployeeDto employeeDto);

    LoginResponse loginEmployee(LoginDto loginDto);
}


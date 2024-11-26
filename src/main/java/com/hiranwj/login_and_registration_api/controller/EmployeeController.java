package com.hiranwj.login_and_registration_api.controller;

import com.hiranwj.login_and_registration_api.dto.EmployeeDto;
import com.hiranwj.login_and_registration_api.dto.LoginDto;
import com.hiranwj.login_and_registration_api.response.LoginResponse;
import com.hiranwj.login_and_registration_api.service.EmployeeService;
import com.hiranwj.login_and_registration_api.service.serviceImpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody EmployeeDto employeeDto) {
        String id = employeeService.addEmployee(employeeDto);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDto loginDto) {
        LoginResponse loginResponse = employeeService.loginEmployee(loginDto);
        return ResponseEntity.ok(loginResponse);
    }
}

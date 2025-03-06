//Operations

package com.demo.firstSpring.tutorial.Controllers;

import com.demo.firstSpring.tutorial.dto.EmployeeDTO;
import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class EmployeeController {

    @GetMapping(path = "/employees/{id}")
    public EmployeeDTO getEmployees(@PathVariable Long id) {
        return new EmployeeDTO(id,"Tejas", LocalDate.of(2022,5,14),true);
    }

    @GetMapping(path = "/employees")
    public String getData(@PathParam("sortBy") String sortBy, @PathParam("limit") Integer limit) {
        return  "Hello " +sortBy +" "+limit;
    }
}

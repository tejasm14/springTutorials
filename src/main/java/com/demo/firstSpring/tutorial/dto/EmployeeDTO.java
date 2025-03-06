package com.demo.firstSpring.tutorial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String name;
    private LocalDate dateOfJoining;
    private Boolean isActive;
}

package com.example.skill9.controller;

import com.example.skill9.model.Student;
import com.example.skill9.exception.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id) {

        // Invalid input check
        if (!id.matches("\\d+")) {
            throw new InvalidInputException("Invalid ID format. Must be a number.");
        }

        int studentId = Integer.parseInt(id);

        // Dummy condition
        if (studentId != 1) {
            throw new StudentNotFoundException("Student not found with ID: " + studentId);
        }

        return new Student(1, "Sathwik");
    }
}
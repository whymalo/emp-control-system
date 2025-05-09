package com.example.emp_control_system.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="departments")
public class Department {
    private String name;

    private String short_name;

    private String location;
}

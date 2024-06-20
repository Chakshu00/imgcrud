package com.imgcrud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Add {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String department;
    private String empId;

    @OneToMany(mappedBy = "add", orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

}

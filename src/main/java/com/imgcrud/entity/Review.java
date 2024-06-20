package com.imgcrud.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "stars", nullable = false)
    private Integer stars;

    @ManyToOne
    @JoinColumn(name = "add_id")
    @JsonBackReference
    private Add add;

}
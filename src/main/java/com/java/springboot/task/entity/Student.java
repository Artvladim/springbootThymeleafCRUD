package com.java.springboot.task.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotBlank(message = "Name's required,bitch")
    @Column(name = "name")
    private String name;

    //@NotBlank(message = "Email is obligatory, mf")
    @Column(name = "email")
    private String email;

    //@NotNull(message = "Can't be just null, moron ")
    @Column(name = "age")
    private Integer age;

    //@NotBlank(message = "Password is required")
    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "faculty_id", nullable = false, foreignKey = @ForeignKey(name = "fk_faculty_id"))
    private Faculty faculty;
}
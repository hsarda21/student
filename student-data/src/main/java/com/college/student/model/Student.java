package com.college.student.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student extends Person
{
    @Builder
    public Student(Long id, String firstName, String lastName, String gender,
                   Stream stream, String address, String city, String phone, Set<Subject> subjects) {
        super(id, firstName, lastName, gender);
        this.stream = stream;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.subjects = subjects;
    }

    @ManyToOne
    @JoinColumn(name = "stream_id")
    private Stream stream;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "phone")
    private String phone;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "subject_id")
    private Set<Subject> subjects = new HashSet<>();

}

package com.college.student.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "streams")
public class Stream extends BaseEntity
{
    @Column(name = "name")
    private String streamName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stream")
    private Set<Teacher> teachers = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stream")
    private Set<Student> students = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stream")
    private Set<Subject> subjects = new HashSet<>();
}

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
@Table(name = "subjects")
public class Subject extends BaseEntity
{
    @Column(name = "name")
    private String subjectName;

    @ManyToOne
    @JoinColumn(name = "stream_id")
    private Stream stream;

    @ManyToMany
    @JoinTable(name = "subject_student", joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name  = "student_id"))
    private Set<Student> students = new HashSet<>();
}

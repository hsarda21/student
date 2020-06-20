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
@Table(name = "teachers")
public class Teacher extends Person
{
    @Builder
    public Teacher(Long id, String firstName, String lastName, String gender, Stream stream, Set<Subject> specialities)
    {
        super(id, firstName, lastName, gender);
        this.stream = stream;
        this.specialities = specialities;
    }

    @ManyToOne
    @JoinColumn(name = "stream_id")
    private Stream stream;

    @Column(name = "specialities")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "teacher_specialities", joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<Subject> specialities = new HashSet<>();
}

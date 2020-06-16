package com.college.student.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teachers")
public class Teacher extends Person
{
    @Column(name = "stream")
    private Stream stream;

    @Column(name = "specialities")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "teacher_specialities", joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<Subject> specialities = new HashSet<>();

    public Stream getStream() {
        return stream;
    }

    public void setStream(Stream stream) {
        this.stream = stream;
    }

    public Set<Subject> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Subject> specialities) {
        this.specialities = specialities;
    }
}

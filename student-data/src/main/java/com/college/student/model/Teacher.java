package com.college.student.model;

import java.util.HashSet;
import java.util.Set;

public class Teacher extends Person
{
    private Stream stream;
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

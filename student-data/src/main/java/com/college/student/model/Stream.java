package com.college.student.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
}

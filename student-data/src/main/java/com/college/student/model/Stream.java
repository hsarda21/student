package com.college.student.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "streams")
public class Stream extends BaseEntity
{
    @Column(name = "name")
    private String streamName;

    @Column(name = "subjects")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stream")
    private Set<Subject> subjects;

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
}

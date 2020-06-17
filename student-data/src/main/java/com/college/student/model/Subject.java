package com.college.student.model;

import javax.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject extends BaseEntity
{
    @Column(name = "name")
    String subjectName;

    @ManyToOne
    @JoinColumn(name = "stream_id")
    Stream stream;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Stream getStream() {
        return stream;
    }

    public void setStream(Stream stream) {
        this.stream = stream;
    }
}

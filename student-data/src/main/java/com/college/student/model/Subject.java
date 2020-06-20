package com.college.student.model;

import lombok.*;

import javax.persistence.*;

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
}

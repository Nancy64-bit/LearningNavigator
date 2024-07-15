package com.crio.learning_navigator.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "subjects")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "enrolledSubjects")
    @ToString.Exclude
    private List<Student> registeredStudents;
}

package com.crio.learning_navigator.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "exams")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examId;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @ManyToMany(mappedBy = "registeredExams")
    @ToString.Exclude
    private List<Student> enrolledStudents;
}
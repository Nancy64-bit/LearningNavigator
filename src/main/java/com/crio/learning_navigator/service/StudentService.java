package com.crio.learning_navigator.service;

import com.crio.learning_navigator.model.Student;
import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    Student getStudentById(Long id);
    List<Student> getAllStudents();
    Student updateStudent(Long id, Student studentDetails);
    String deleteStudent(Long id);
    Student enrollStudentInSubject(Long registrationId, Long subjectId);
    Student registerStudentForExam(Long registrationId, Long examId);
}
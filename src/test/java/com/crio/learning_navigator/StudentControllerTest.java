package com.crio.learning_navigator;

import com.crio.learning_navigator.controller.StudentController;
import com.crio.learning_navigator.model.Student;
import com.crio.learning_navigator.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    public void testCreateStudent() {
        Student student = new Student();
        Student createdStudent = new Student();
        when(studentService.createStudent(any(Student.class))).thenReturn(createdStudent);

        ResponseEntity<Student> response = studentController.createStudent(student);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdStudent, response.getBody());
    }

    @Test
    public void testGetStudentById() {
        Long id = 1L;
        Student student = new Student();
        when(studentService.getStudentById(id)).thenReturn(student);

        ResponseEntity<Student> response = studentController.getStudentById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(student, response.getBody());
    }

    @Test
    public void testGetAllStudents() {
        List<Student> students = Collections.emptyList();
        when(studentService.getAllStudents()).thenReturn(students);

        ResponseEntity<List<Student>> response = studentController.getAllStudents();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(students, response.getBody());
    }

    @Test
    public void testUpdateStudent() {
        Long id = 1L;
        Student student = new Student();
        when(studentService.updateStudent(anyLong(), any(Student.class))).thenReturn(student);

        ResponseEntity<Student> response = studentController.updateStudent(id, student);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(student, response.getBody());
    }

    @Test
    public void testDeleteStudent() {
        Long id = 1L;
        String responseMessage = "Student deleted successfully";
        when(studentService.deleteStudentById(id)).thenReturn(responseMessage);

        ResponseEntity<String> response = studentController.deleteStudentById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(responseMessage, response.getBody());
    }

    @Test
    public void testEnrollStudentInSubject() {
        Long registrationId = 1L;
        Long subjectId = 1L;
        Student student = new Student();
        when(studentService.enrollStudentInSubject(registrationId, subjectId)).thenReturn(student);

        ResponseEntity<Student> response = studentController.enrollStudentInSubject(registrationId, subjectId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(student, response.getBody());
    }

    @Test
    public void testRegisterStudentForExam() {
        Long registrationId = 1L;
        Long examId = 1L;
        Student student = new Student();
        when(studentService.registerStudentForExam(registrationId, examId)).thenReturn(student);

        ResponseEntity<Student> response = studentController.registerStudentForExam(registrationId, examId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(student, response.getBody());
    }
}

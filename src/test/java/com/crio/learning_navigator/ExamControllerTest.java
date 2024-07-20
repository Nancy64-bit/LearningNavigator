package com.crio.learning_navigator;

import com.crio.learning_navigator.controller.ExamController;
import com.crio.learning_navigator.model.Exam;
import com.crio.learning_navigator.service.ExamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExamControllerTest {

    @Mock
    private ExamService examService;

    @InjectMocks
    private ExamController examController;

    @BeforeEach
    void setUp() {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(examController).build();
    }

    @Test
    public void testCreateExam() throws Exception {
        // Given
        Exam exam = new Exam(); // Create a sample exam
        Exam createdExam = new Exam(); // Create a sample created exam
        when(examService.createExam(any(Exam.class))).thenReturn(createdExam);

        // When
        ResponseEntity<Exam> response = examController.createExam(exam);

        // Then
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdExam, response.getBody());
    }

    @Test
    public void testGetAllExams() throws Exception {
        // Given
        List<Exam> exams = List.of(new Exam(), new Exam());
        when(examService.getAllExams()).thenReturn(exams);

        // When
        ResponseEntity<List<Exam>> response = examController.getAllExams();

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(exams, response.getBody());
    }

    @Test
    public void testGetExamById() throws Exception {
        // Given
        Long id = 1L;
        Exam exam = new Exam();
        when(examService.getExamById(id)).thenReturn(exam);

        // When
        ResponseEntity<Exam> response = examController.getExamById(id);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(exam, response.getBody());
    }
}

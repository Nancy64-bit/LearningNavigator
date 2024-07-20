package com.crio.learning_navigator;

import com.crio.learning_navigator.controller.SubjectController;
import com.crio.learning_navigator.model.Subject;
import com.crio.learning_navigator.service.SubjectService;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SubjectControllerTest {

    @Mock
    private SubjectService subjectService;

    @InjectMocks
    private SubjectController subjectController;

    @Test
    public void testCreateSubject() {
        Subject subject = new Subject();
        Subject createdSubject = new Subject();
        when(subjectService.createSubject(any(Subject.class))).thenReturn(createdSubject);

        ResponseEntity<Subject> response = subjectController.createSubject(subject);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdSubject, response.getBody());
    }

    @Test
    public void testGetAllSubjects() {
        List<Subject> subjects = Collections.emptyList();
        when(subjectService.getAllSubjects()).thenReturn(subjects);

        ResponseEntity<List<Subject>> response = subjectController.getAllSubjects();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(subjects, response.getBody());
    }

    @Test
    public void testGetSubjectById() {
        Long id = 1L;
        Subject subject = new Subject();
        when(subjectService.getSubjectById(id)).thenReturn(subject);

        ResponseEntity<Subject> response = subjectController.getSubjectById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(subject, response.getBody());
    }
}

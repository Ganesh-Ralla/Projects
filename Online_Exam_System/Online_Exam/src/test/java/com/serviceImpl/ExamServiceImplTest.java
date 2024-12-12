package com.serviceImpl;

import com.entity_class.Course;
import com.entity_class.Exam;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExamServiceImplTest {

    @Test
    void createExam() {
        Course course = new Course();
        course.setCourseName("Java Programming");
        Exam exam = new Exam(1,course,"Basic Java Exam");
        assertEquals(1, exam.getExamId());
        assertEquals("Java Programming", course.getCourseName());
        assertEquals("Basic Java Exam", exam.getExamName());
    }
}
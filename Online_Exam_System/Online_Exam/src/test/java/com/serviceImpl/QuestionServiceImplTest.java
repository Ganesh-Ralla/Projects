package com.serviceImpl;

import com.entity_class.Exam;
import com.entity_class.Questions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionServiceImplTest {

    @Test
    void createquestions() {
        Exam exam = new Exam();
        exam.setExamName("Java Basic Exam");
        Questions questions = new Questions(1,"What is 2 + 2","2","3","4","5",exam,1,"4");

        assertEquals(1, questions.getQuestionId());
        assertEquals("What is 2 + 2", questions.getQuestionText());
        assertEquals("2", questions.getOptionA());
        assertEquals("3", questions.getOptionB());
        assertEquals("4", questions.getOptionC());
        assertEquals("5", questions.getOptionD());
        assertEquals(exam.getExamName(), questions.getExam().getExamName());
        assertEquals("4", questions.getCorrectOption());
    }
}
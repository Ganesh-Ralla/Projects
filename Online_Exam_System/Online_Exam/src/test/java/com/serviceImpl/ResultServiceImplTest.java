package com.serviceImpl;

import com.entity_class.Exam;
import com.entity_class.Result;
import com.entity_class.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultServiceImplTest {

    @Test
    void getresult() {
        User user = new User();
        user.setUsername("ganesh07");
        Exam exam = new Exam();
        exam.setExamName("Java Basic Exam");
        Result result = new Result(1, user, exam, 4);

        assertEquals(1, result.getResultId());
        assertEquals(user.getUsername(), result.getUser().getUsername());
        assertEquals(exam.getExamName(), result.getExam().getExamName());
        assertEquals(4, result.getScore());
    }
}
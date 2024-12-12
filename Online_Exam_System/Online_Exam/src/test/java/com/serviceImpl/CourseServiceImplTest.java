package com.serviceImpl;

import com.entity_class.Course;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseServiceImplTest {

    @Test
    void create_course() {
        Course course = new Course(1, "Java Programming", "5 months","Chaitanya Poighal");

        assertEquals(1, course.getCourseId());
        assertEquals("Java Programming", course.getCourseName());
        assertEquals("5 months", course.getDuration());
        assertEquals("Chaitanya Poighal", course.getTrainer());
    }

}
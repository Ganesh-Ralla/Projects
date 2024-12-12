package com.serviceImpl;

import com.entity_class.Course;
import com.entity_class.JoinCourse;
import com.entity_class.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JoinCourseImplTest {

    @Test
    void joincourse() {
        User user = new User();
        user.setUsername("ganesh07");
        Course course = new Course();
        course.setCourseName("Java Programming");
        JoinCourse join = new JoinCourse(1,user,course);

        assertEquals(1, join.getJoin_id());
        assertEquals("ganesh07", join.getUser().getUsername());
        assertEquals("Java Programming", join.getCourse().getCourseName());
    }
}
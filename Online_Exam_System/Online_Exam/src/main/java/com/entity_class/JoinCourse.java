package com.entity_class;

import jakarta.persistence.*;

@Entity
public class JoinCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int join_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public int getJoin_id() {
        return join_id;
    }

    public void setJoin_id(int join_id) {
        this.join_id = join_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public JoinCourse(int join_id, User user, Course course) {
        this.join_id = join_id;
        this.user = user;
        this.course = course;
    }

    public JoinCourse() {
    }

}


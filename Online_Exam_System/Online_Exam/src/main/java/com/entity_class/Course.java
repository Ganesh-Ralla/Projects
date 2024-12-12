package com.entity_class;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {

    @Id
    private int courseId;

    @Column(nullable = false)
    private String courseName;

    @Column(nullable = false)
    private String duration;

    @Column(name = "Trainer")
    private String trainer;

    // Getters and Setters

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }

    public Course(int courseId, String courseName, String duration , String trainer) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.duration = duration;
        this.trainer = trainer;
    }

    public Course() {
    }
}


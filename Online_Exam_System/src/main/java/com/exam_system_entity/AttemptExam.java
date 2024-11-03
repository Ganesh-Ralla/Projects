package com.exam_system_entity;


import jakarta.persistence.*;

@Entity
@Table(name = "attemptexam")
public class AttemptExam {
    @Id
    private int attemptId;

    @Column(name = "user_answer", nullable = false)
    private String userAnswer;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;

    public int getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(int attemptId) {
        this.attemptId = attemptId;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
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

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public AttemptExam(int attemptId, String userAnswer, User user, Course course, Exam exam) {
        this.attemptId = attemptId;
        this.userAnswer = userAnswer;
        this.user = user;
        this.course = course;
        this.exam = exam;
    }

    public AttemptExam() {
    }
}


package com.exam_system_entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_exams")
public class UserExam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userExamId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private ExamStatus status;

    private Integer score;

    public enum ExamStatus {
        COMPLETED,
        IN_PROGRESS,
        NOT_ATTEMPTED
    }

    // Getters and Setters
    public Long getUserExamId() {
        return userExamId;
    }

    public void setUserExamId(Long userExamId) {
        this.userExamId = userExamId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ExamStatus getStatus() {
        return status;
    }

    public void setStatus(ExamStatus status) {
        this.status = status;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}

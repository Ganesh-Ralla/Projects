package com.exam_system_service_impl;

import com.exam_system_entity.Exam;
import com.exam_system_entity.Question;
import com.exam_system_service.QuestionService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class QuestionsServiceImpl implements QuestionService {
    Session s;
    Transaction t;
    Scanner sc = new Scanner(System.in);
    @Override
    public void createQuestion(SessionFactory sf) {

        Exam exam = new Exam();

        Question question1 = new Question();
        question1.setQuestionId(1);
        question1.setQuestionText("Which of the following is not a Java primitive type?");
        question1.setCorrectOption(Question.Option.A);
        question1.setExam(exam);



        Question question2 = new Question();
        question2.setQuestionId(1);
        question2.setQuestionText("What is the correct way to create an array in Java?");
        question2.setCorrectOption(Question.Option.B);
        question2.setExam(exam);


        Question question3 = new Question();
        question3.setQuestionId(1);
        question3.setQuestionText("Which of the following keywords is used to define a class in Java?");
        question3.setCorrectOption(Question.Option.C);
        question3.setExam(exam);


        Question question4 = new Question();
        question4.setQuestionId(1);
        question4.setQuestionText("What is the output of the following code? `System.out.println(2 + 3 + '5')");
        question4.setCorrectOption(Question.Option.A);
        question4.setExam(exam);


        Question question5 = new Question();
        question5.setQuestionId(1);
        question5.setQuestionText("Which of the following statements is true regarding the `static` keyword?");
        question5.setCorrectOption(Question.Option.C);
        question5.setExam(exam);

        Question question6 = new Question();
        question6.setQuestionId(2);
        question6.setQuestionText("What is the output of the following code?\nprint(type([]) is list)");
        question6.setCorrectOption(Question.Option.A);
        question6.setExam(exam);

        Question question7 = new Question();
        question7.setQuestionId(2);
        question7.setQuestionText("Which of the following data types is immutable in Python?");
        question7.setCorrectOption(Question.Option.D);
        question7.setExam(exam);

        Question question8 = new Question();
        question8.setQuestionId(2);
        question8.setQuestionText("What is the purpose of the self parameter in a class method? ");
        question8.setCorrectOption(Question.Option.A);
        question8.setExam(exam);

        Question question9 = new Question();
        question9.setQuestionId(2);
        question9.setQuestionText("Which of the following is a correct way to create a function in Python? ");
        question9.setCorrectOption(Question.Option.D);
        question9.setExam(exam);

        Question question10 = new Question();
        question10.setQuestionId(2);
        question10.setQuestionText("What will be the output of the following code?\nprint(2 ** 3 ** 2)");
        question10.setCorrectOption(Question.Option.A);
        question10.setExam(exam);

        Question question11 = new Question();
        question11.setQuestionId(3);
        question11.setQuestionText("Which of the following data structures uses Last In First Out (LIFO) ordering? ");
        question11.setCorrectOption(Question.Option.B);
        question11.setExam(exam);

        Question question12 = new Question();
        question12.setQuestionId(3);
        question12.setQuestionText("What is the time complexity of accessing an element in an array? ");
        question12.setCorrectOption(Question.Option.C);
        question12.setExam(exam);

        Question question13 = new Question();
        question13.setQuestionId(3);
        question13.setQuestionText("Which of the following sorting algorithms has the best average-case time complexity? ");
        question13.setCorrectOption(Question.Option.C);
        question13.setExam(exam);

        Question question14 = new Question();
        question14.setQuestionId(3);
        question14.setQuestionText("Which of the following data structures is used to implement recursion?");
        question14.setCorrectOption(Question.Option.A);
        question14.setExam(exam);

        Question question15 = new Question();
        question15.setQuestionId(3);
        question15.setQuestionText("What is the average time complexity of searching for an element in a hash table?");
        question15.setCorrectOption(Question.Option.B);
        question15.setExam(exam);






    }

    @Override
    public void updateQuestion(SessionFactory sf) {

        System.out.print("Enter question id to update :");
        Question question = new Question();
        question.setQuestionText(sc.next());

        s.save(question);
        t.commit();

    }

    @Override
    public void deleteQuestion(SessionFactory sf) {
        System.out.print("Enter question id to delete the question :");
        int qid=sc.nextInt();
        Question question =s.get(Question.class, qid);
        if(question != null){
            s.delete(question);
            System.out.println("Question deleted successfully");
        }
        else{
            System.out.println("No question found with the given id");
        }


    }

    @Override
    public void getQuestion(SessionFactory sf) {
        sf.openSession();
        Question question = new Question();
        System.out.print("Enter question id :");
        int qid=sc.nextInt();
        if(question != null){
            System.out.println(question);
        }
        else{
            System.out.println("No question found with the given id");
        }

    }

    @Override
    public void getAllQuestion(SessionFactory sf) {
        s= sf.openSession();
        List<Question> list = s.createQuery("from questions", Question.class).list();
        for(Question question: list){
            System.out.println(list);
        }

    }
}

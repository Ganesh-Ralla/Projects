package com.serviceImpl;

import com.entity_class.Exam;
import com.entity_class.Questions;
import com.entity_class.Result;
import com.entity_class.User;
import com.service.QuestionService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class QuestionServiceImpl implements QuestionService {
    Scanner sc = new Scanner(System.in);
    Session s;
    Transaction t;

    @Override
    public void createquestions(SessionFactory sf) {
        s = sf.openSession();
        t = s.beginTransaction();
        Exam exam1 = s.get(Exam.class, 1);

        Questions question1 = new Questions();
        question1.setQuestionText("Which of the following is not a Java primitive type?");
        question1.setOptionA("1.int");
        question1.setOptionB("2.float");
        question1.setOptionC("3.boolean");
        question1.setOptionD("4.String");
        question1.setCorrectOption("4");
        question1.setExam(exam1);
        s.save(question1);

        Questions question2 = new Questions();
        question2.setQuestionText("Which of the following keywords is used to define a class in Java?");
        question2.setOptionA("1.class");
        question2.setOptionB("2.object");
        question2.setOptionC("3.define");
        question2.setOptionD("4.struct");
        question2.setCorrectOption("1");
        question2.setExam(exam1);
        s.save(question2);

        Questions question3 = new Questions();
        question3.setQuestionText("Which of the following is an interface in Java?");
        question3.setOptionA("1.Abstract class");
        question3.setOptionB("2.Enumeration");
        question3.setOptionC("3.Runnable");
        question3.setOptionD("4.String");
        question3.setCorrectOption("3");
        question3.setExam(exam1);
        s.save(question3);

        Questions question4 = new Questions();
        question4.setQuestionText("What will be the output of the following code snippet? `System.out.println(10 / 3);");
        question4.setOptionA("1.3");
        question4.setOptionB("2.3.0");
        question4.setOptionC("3.3.333");
        question4.setOptionD("4.10/0");
        question4.setCorrectOption("1");
        question4.setExam(exam1);
        s.save(question4);

        Questions question5 = new Questions();
        question5.setQuestionText("What does JVM stand for?");
        question5.setOptionA("1.Java Variable Manager");
        question5.setOptionB("2.Java Virtual Machine");
        question5.setOptionC("3.Java Visual Machine");
        question5.setOptionD("4.Java Verified Machine");
        question5.setCorrectOption("2");
        question5.setExam(exam1);
        s.save(question5);

        Exam exam2 = s.get(Exam.class, 2);
        Questions question6 = new Questions();
        question6.setQuestionText("Which of the following data types is immutable in Python?");
        question6.setOptionA("1.List");
        question6.setOptionB("2.Set");
        question6.setOptionC("3.Dictionary");
        question6.setOptionD("4.Tuple");
        question6.setCorrectOption("4");
        question6.setExam(exam2);
        s.save(question6);

        Questions question7 = new Questions();
        question7.setQuestionText("What will be the output of the following code?\nprint(2 ** 3 ** 2)");
        question7.setOptionA("1.64");
        question7.setOptionB("2.9");
        question7.setOptionC("3.8");
        question7.setOptionD("4.6");
        question7.setCorrectOption("1");
        question7.setExam(exam2);
        s.save(question7);

        Questions question8 = new Questions();
        question8.setQuestionText("Which of the following is used to define a function in Python?");
        question8.setOptionA("1.function");
        question8.setOptionB("2.def");
        question8.setOptionC("3.define");
        question8.setOptionD("4.func");
        question8.setCorrectOption("2");
        question8.setExam(exam2);
        s.save(question8);

        Questions question9 = new Questions();
        question9.setQuestionText("What is the purpose of the // operator in Python?");
        question9.setOptionA("1.Exponentiation");
        question9.setOptionB("2.Division with decimal results");
        question9.setOptionC("3.Floor division");
        question9.setOptionD("4.Modulus");
        question9.setCorrectOption("3");
        question9.setExam(exam2);
        s.save(question9);

        Questions question10 = new Questions();
        question10.setQuestionText("Which of the following is NOT a valid Python keyword?");
        question10.setOptionA("1.lambda");
        question10.setOptionB("2.eval");
        question10.setOptionC("3.assert");
        question10.setOptionD("4.pass");
        question10.setCorrectOption("2");
        question10.setExam(exam2);
        s.save(question10);

        t.commit();
    }

    @Override
    public void getquestions(SessionFactory sf) {
        s= sf.openSession();
        t= s.beginTransaction();
        int score=0;
        System.out.print("Enter exam id :");
        int eid=sc.nextInt();
        List<Questions> list = s.createQuery("from Questions q where q.exam.id = :eid", Questions.class).setParameter("eid",eid).list();
        System.out.println("QUESTION");
        for (Questions question : list) {
            System.out.println(question.getQuestionText());

            System.out.println(question.getOptionA()+"\t"+question.getOptionB()+"\t\t"+question.getOptionC()+"\t"+question.getOptionD());
            System.out.print("Enter your answer :");
            String ans=sc.next();
            if(ans.equals(question.getCorrectOption())){
                score++;
            }
            question.setScore(score);
        }
        System.out.println("Your final score: " +  score + " out of " + list.size());


        t.commit();
    }

}

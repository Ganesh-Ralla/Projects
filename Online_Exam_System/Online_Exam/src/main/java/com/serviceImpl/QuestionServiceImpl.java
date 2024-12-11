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

        //Basic java questions
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

        //Basic python questions
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

        //Basic HTML questions
        Exam exam3 = s.get(Exam.class, 3);
        Questions question11 = new Questions();
        question11.setQuestionText("Which HTML tag is used to define an unordered list? ");
        question11.setOptionA("1.<ul>");
        question11.setOptionB("2.<ol>");
        question11.setOptionC("3.<list>");
        question11.setOptionD("4.<ulist>");
        question11.setCorrectOption("1");
        question11.setExam(exam3);
        s.save(question11);

        Questions question12 = new Questions();
        question12.setQuestionText("Which attribute is used to specify the background color of a webpage? ");
        question12.setOptionA("1.bgcolor");
        question12.setOptionB("2.color");
        question12.setOptionC("3.bachground");
        question12.setOptionD("4.bgcolor='color'");
        question12.setCorrectOption("1");
        question12.setExam(exam3);
        s.save(question12);

        Questions question13 = new Questions();
        question13.setQuestionText("Which HTML tag is used to display a line break? ");
        question13.setOptionA("1.<br>");
        question13.setOptionB("2.<lb>");
        question13.setOptionC("3.<break>");
        question13.setOptionD("4.<hr>");
        question13.setCorrectOption("1");
        question13.setExam(exam3);
        s.save(question13);

        Questions question14 = new Questions();
        question14.setQuestionText(" Which of the following tags is used to define a table in HTML? ");
        question14.setOptionA("1.<table>");
        question14.setOptionB("2.<tbody>");
        question14.setOptionC("3.<tr>");
        question14.setOptionD("4.<thead>");
        question14.setCorrectOption("1");
        question14.setExam(exam3);
        s.save(question14);

        Questions question15 = new Questions();
        question15.setQuestionText("What is the correct HTML tag for inserting a line horizontal rule? ");
        question15.setOptionA("1.<line>");
        question15.setOptionB("2.<hr>");
        question15.setOptionC("3.<rule>");
        question15.setOptionD("4.<hline>");
        question15.setCorrectOption("2");
        question15.setExam(exam3);
        s.save(question15);

        //Basic DSA questions
        Exam exam4 = s.get(Exam.class, 4);
        Questions question16 = new Questions();
        question16.setQuestionText("Which of the following data structures is used for implementing recursion? ");
        question16.setOptionA("1.Stack");
        question16.setOptionB("2.Queue");
        question16.setOptionC("3.Linked list");
        question16.setOptionD("4.Binary tree");
        question16.setCorrectOption("1");
        question16.setExam(exam4);
        s.save(question16);


        Questions question17 = new Questions();
        question17.setQuestionText(" What is the best data structure to implement a queue? ");
        question17.setOptionA("1.Stack");
        question17.setOptionB("2.Linked list");
        question17.setOptionC("3.Array");
        question17.setOptionD("4.Binary tree");
        question17.setCorrectOption("2");
        question17.setExam(exam4);
        s.save(question17);

        Questions question18 = new Questions();
        question18.setQuestionText("  Which algorithm is used to find the shortest path in a graph? ");
        question18.setOptionA("1.Merge sort");
        question18.setOptionB("2.Dijkstra's Algorithm");
        question18.setOptionC("3.Quick sort");
        question18.setOptionD("4.Binary search");
        question18.setCorrectOption("2");
        question18.setExam(exam4);
        s.save(question18);

        Questions question19 = new Questions();
        question19.setQuestionText(" Which of the following sorting algorithms is the most efficient for large datasets? ");
        question19.setOptionA("1.Bubble sort");
        question19.setOptionB("2.Quick sort");
        question19.setOptionC("3.Selection sort");
        question19.setOptionD("4.Insertion sort");
        question19.setCorrectOption("2");
        question19.setExam(exam4);
        s.save(question19);

        Questions question20 = new Questions();
        question20.setQuestionText("  What is the time complexity of Quick Sort in the average case? ");
        question20.setOptionA("1.O(n log n)");
        question20.setOptionB("2.O(n^2)");
        question20.setOptionC("3.O(log n)");
        question20.setOptionD("4.O(n)");
        question20.setCorrectOption("1");
        question20.setExam(exam4);
        s.save(question20);


        //Basic DBMS questions
        Exam exam5 = s.get(Exam.class, 5);
        Questions question21 = new Questions();
        question21.setQuestionText("Which of the following is a type of database model? ");
        question21.setOptionA("1.Relational model");
        question21.setOptionB("2.File based model");
        question21.setOptionC("3.Hierarchical mode;");
        question21.setOptionD("4.All the above");
        question21.setCorrectOption("4");
        question21.setExam(exam5);
        s.save(question21);

        Questions question22 = new Questions();
        question22.setQuestionText("What is the primary key in a relational database? ");
        question22.setOptionA("1.A field that can be null");
        question22.setOptionB("2.A unique identifier for a record");
        question22.setOptionC("3.A foreign key that references another table");
        question22.setOptionD("4.A field that can hold multiple values");
        question22.setCorrectOption("2");
        question22.setExam(exam5);
        s.save(question22);

        Questions question23 = new Questions();
        question23.setQuestionText("What does SQL stand for? ");
        question23.setOptionA("1.Standard Query Language");
        question23.setOptionB("2.Structured Query Language");
        question23.setOptionC("3.Simple Query Language");
        question23.setOptionD("4.Sequential Query Language");
        question23.setCorrectOption("2");
        question23.setExam(exam5);
        s.save(question23);

        Questions question24 = new Questions();
        question24.setQuestionText("Which of the following SQL statements is used to retrieve data from a database? ");
        question24.setOptionA("1.INSERT");
        question24.setOptionB("2.SELECT");
        question24.setOptionC("3.UPDATE");
        question24.setOptionD("4.DELETE");
        question24.setCorrectOption("2");
        question24.setExam(exam5);
        s.save(question24);

        Questions question25 = new Questions();
        question25.setQuestionText("Which SQL command is used to modify an existing database table? ");
        question25.setOptionA("1.MODIFY");
        question25.setOptionB("2.ALTER");
        question25.setOptionC("3.UPDATE");
        question25.setOptionD("4.CHANGE");
        question25.setCorrectOption("2");
        question25.setExam(exam5);
        s.save(question25);


        t.commit();
    }

    @Override
    public void getquestions(SessionFactory sf) {
        s= sf.openSession();
        t= s.beginTransaction();
        int score=0;

        System.out.print("Enter user id :");
        int uid = sc.nextInt();
        User user = s.get(User.class, uid);


        System.out.print("Enter exam id :");
        int eid=sc.nextInt();
        Exam exam = s.get(Exam.class, eid);


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

        //result insert
        Result result = new Result();
        result.setUser(user);
        result.setExam(exam);
        result.setScore(score);

        s.save(result);
        t.commit();
    }



}

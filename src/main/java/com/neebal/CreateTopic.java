package com.neebal;

import com.neebal.entities.Question;
import com.neebal.entities.QuestionOptions;
import com.neebal.entities.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class CreateTopic {
    public static void main(String[] args) {

        QuestionOptions opt1 = new QuestionOptions("A. JDK", true);
        QuestionOptions opt2 = new QuestionOptions("B. JVM", false);
        QuestionOptions opt3 = new QuestionOptions("C. JRE", false);
        QuestionOptions opt4 = new QuestionOptions("D. JAR", false);

        QuestionOptions opt5 = new QuestionOptions("A. Inheritance", false);
        QuestionOptions opt6 = new QuestionOptions("B. Polymorphism", true);
        QuestionOptions opt7 = new QuestionOptions("C. Encapsulation", false);
        QuestionOptions opt8 = new QuestionOptions("D. Abstraction", false);

        Question question1 = new Question("What does JDK stand for?", 5);
        Question question2 = new Question("Which Java concept allows objects of different classes to be treated as objects of the same class?", 10);

        Topic topic = new Topic("Java Programming");

        opt1.setQuestion(question1);
        opt2.setQuestion(question1);
        opt3.setQuestion(question1);
        opt4.setQuestion(question1);

        opt5.setQuestion(question2);
        opt6.setQuestion(question2);
        opt7.setQuestion(question2);
        opt8.setQuestion(question2);

        Set<QuestionOptions> questionOptionSet1 = new HashSet<>();
        questionOptionSet1.add(opt1);
        questionOptionSet1.add(opt2);
        questionOptionSet1.add(opt3);
        questionOptionSet1.add(opt4);
        question1.setQuestion_optionSet(questionOptionSet1);

        Set<QuestionOptions> questionOptionSet2 = new HashSet<>();
        questionOptionSet2.add(opt5);
        questionOptionSet2.add(opt6);
        questionOptionSet2.add(opt7);
        questionOptionSet2.add(opt8);
        question2.setQuestion_optionSet(questionOptionSet2);

        question1.setTopic(topic);
        question2.setTopic(topic);
        Set<Question> questionSet = new HashSet<>();
        questionSet.add(question1);
        questionSet.add(question2);
        topic.setQuestionSet(questionSet);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(topic);
            transaction.commit();
        }
    }
}

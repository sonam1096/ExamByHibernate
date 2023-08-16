package com.neebal;

import com.neebal.entities.Question;
import com.neebal.entities.QuestionOptions;
import com.neebal.entities.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class ExistingTopic {
    public static void main(String[] args) {

        QuestionOptions opt1 = new QuestionOptions("A. int x = 5;", false);
        QuestionOptions opt2 = new QuestionOptions("B. float x = 5.0;", false);
        QuestionOptions opt3 = new QuestionOptions("C. String x = 'Hello';", false);
        QuestionOptions opt4 = new QuestionOptions("D. String x = \"Hello\";", true);

        Question question = new Question("Which of the following Java statements declares a valid string variable?", 2);

        opt1.setQuestion(question);
        opt2.setQuestion(question);
        opt3.setQuestion(question);
        opt4.setQuestion(question);

        Set<QuestionOptions> questionOptionSet = new HashSet<>();
        questionOptionSet.add(opt1);
        questionOptionSet.add(opt2);
        questionOptionSet.add(opt3);
        questionOptionSet.add(opt4);
        question.setQuestion_optionSet(questionOptionSet);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Topic topic = session.get(Topic.class, 3l);
            Transaction transaction = session.beginTransaction();
            question.setTopic(topic);
            session.save(question);
            transaction.commit();
        }
    }
}

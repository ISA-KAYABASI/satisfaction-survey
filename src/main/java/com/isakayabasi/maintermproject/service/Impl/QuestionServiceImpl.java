package com.isakayabasi.maintermproject.service.Impl;

import com.isakayabasi.maintermproject.model.Question;
import com.isakayabasi.maintermproject.model.QuestionForm;
import com.isakayabasi.maintermproject.repository.QuestionRepo;
import com.isakayabasi.maintermproject.service.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionForm qForm;

    @Autowired
    QuestionRepo qRepo;

    @Autowired
    Question question;


    @Override
    public QuestionForm getQuestions() {



        List<Question> allQues = qRepo.findAll();

        allQues.add(new Question(
                1,
                "Please indicate your general satisfaction with your education.",
                "Highly Dissatisfied",
                "Dissatisfied",
                "Neither Satisfied nor Dissatisfied",
                "Satisfied",
                "Highly Satisfied",
                1,
                2,
                3,
                4,
                5,
                -1)
        );

        allQues.add(new Question(
                2,
                "Please indicate your general assessment of the Adequacy of the Training Scope and Content?",
                "Highly Dissatisfied",
                "Dissatisfied",
                "Neither Satisfied nor Dissatisfied",
                "Satisfied",
                "Highly Satisfied",
                1,
                2,
                3,
                4,
                5,
                -1)
        );

        allQues.add(new Question(
                3,
                "Tell us your opinion about the prices of our trainings?",
                "Highly Dissatisfied",
                "Dissatisfied",
                "Neither Satisfied nor Dissatisfied",
                "Satisfied",
                "Highly Satisfied",
                1,
                2,
                3,
                4,
                5,
                -1)
        );

        allQues.add(new Question(
                4,
                "Please indicate your general assessment of the Adequacy of the Training Period?",
                "Highly Dissatisfied",
                "Dissatisfied",
                "Neither Satisfied nor Dissatisfied",
                "Satisfied",
                "Highly Satisfied",
                1,
                2,
                3,
                4,
                5,
                -1)
        );

        allQues.add(new Question(
                5,
                "Please indicate your general evaluation of the trainer?",
                "Highly Dissatisfied",
                "Dissatisfied",
                "Neither Satisfied nor Dissatisfied",
                "Satisfied",
                "Highly Satisfied",
                1,
                2,
                3,
                4,
                5,
                -1)
        );

        allQues.add(new Question(
                6,
                "Please indicate your assessment of the Educator(s) Knowledge?Please indicate your evaluation about the Educator(s) Lecture?",
                "Highly Dissatisfied",
                "Dissatisfied",
                "Neither Satisfied nor Dissatisfied",
                "Satisfied",
                "Highly Satisfied",
                1,
                2,
                3,
                4,
                5,
                -1)
        );

        allQues.add(new Question(
                7,
                "Please indicate your evaluation about the Educator(s) Lecture?",
                "Highly Dissatisfied",
                "Dissatisfied",
                "Neither Satisfied nor Dissatisfied",
                "Satisfied",
                "Highly Satisfied",
                1,
                2,
                3,
                4,
                5,
                -1)
        );

        allQues.add(new Question(
                8,
                "Please indicate your evaluation about the adequacy of the examples given during the training?",
                "Highly Dissatisfied",
                "Dissatisfied",
                "Neither Satisfied nor Dissatisfied",
                "Satisfied",
                "Highly Satisfied",
                1,
                2,
                3,
                4,
                5,
                -1)
        );

        allQues.add(new Question(
                9,
                "Please indicate your evaluation about the training notes, materials, adequacy of the training presentation?",
                "Highly Dissatisfied",
                "Dissatisfied",
                "Neither Satisfied nor Dissatisfied",
                "Satisfied",
                "Highly Satisfied",
                1,
                2,
                3,
                4,
                5,
                -1)
        );

        allQues.add(new Question(
                10,
                "Please indicate your evaluation regarding Certification and response to your requests?",
                "Highly Dissatisfied",
                "Dissatisfied",
                "Neither Satisfied nor Dissatisfied",
                "Satisfied",
                "Highly Satisfied",
                1,
                2,
                3,
                4,
                5,
                -1)
        );

        allQues.add(new Question(
                11,
                "Tell us your opinion about the prices of our trainings?",
                "Highly Dissatisfied",
                "Dissatisfied",
                "Neither Satisfied nor Dissatisfied",
                "Satisfied",
                "Highly Satisfied",
                1,
                2,
                3,
                4,
                5,
                -1)
        );






        List<Question> qList =new ArrayList<Question>();

        Random random = new Random();
        for(int i=0; i<5; i++) {
            int rand = random.nextInt(allQues.size());
            qList.add(allQues.get(rand));
            allQues.remove(rand);
        }

        qForm.setQuestions(qList);

        return qForm;
    }
}

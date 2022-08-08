package com.isakayabasi.maintermproject.service.Impl;

import com.isakayabasi.maintermproject.model.Question;
import com.isakayabasi.maintermproject.model.QuestionForm;
import com.isakayabasi.maintermproject.model.Result;
import com.isakayabasi.maintermproject.repository.ResultRepo;
import com.isakayabasi.maintermproject.service.Service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {




    @Autowired
    Result result;

    @Autowired
    ResultRepo rRepo;


    @Override
    public void saveScore(Result result) {
        Result saveResult = new Result();

        saveResult.setEmail(result.getEmail());
        saveResult.setUsername(result.getUsername());
        saveResult.setTotalCorrect(result.getTotalCorrect());
        saveResult.setSatisfaction(result.getSatisfaction());
        saveResult.setMessageId(result.getMessageId());
        rRepo.save(saveResult);
    }

    @Override
    public String getMessageId(QuestionForm questionForm) {
        return null;
    }

    @Override
    public void saveSatisfaction(Result result) {
        Result saveResult = new Result();

        saveResult.setEmail(result.getEmail());
        saveResult.setTotalCorrect(result.getTotalCorrect());
        saveResult.setUsername(result.getUsername());
        saveResult.setSatisfaction(result.getSatisfaction());
        saveResult.setMessageId(result.getMessageId());
        rRepo.save(saveResult);

    }

    @Override
    public List<Result> getTopScore() {
        List<Result> sList = rRepo.findAll(Sort.by(Sort.Direction.DESC, "totalCorrect"));

        return sList;
    }

    @Override
    public String getResultSatisfaction(QuestionForm qForm) {
        int total =0;
        String result1 = null;
        double correct = 0;

        for(Question q : qForm.getQuestions()) {
            if(q.getAns1() == q.getChose()){
                total=total-2;
            } else if (q.getAns2() == q.getChose() ) {
                total=total-1;
            }else if (q.getAns3() == q.getChose() ) {
                total=total+0;
            }else if (q.getAns4() == q.getChose() ) {
                total=total+1;
            }else if (q.getAns5() == q.getChose() ) {
                total=total+2;
            } else{
                total=total+0;
            }
        }
        total=total/5;



        if (total<-2){
            result1 = "Highly Dissatisfied" ;
        } else if (total==-1){
            result1 = "Dissatisfied";
        } else if (total==0) {
            result1 = "Neither Satisfied nor Dissatisfied";
        } else if (total==1) {
            result1 = "Satisfied";
        } else if (total>=2) {
            result1 = "Highly Satisfied";
        }

        return result1;
    }




    @Override
    public double getResultPoint(QuestionForm qForm) {
        int total = 0;
        double avaragePoint = 0;

        for (Question q : qForm.getQuestions()) {
            if (q.getAns1() == q.getChose()) {
                total = total - 2;
            } else if (q.getAns2() == q.getChose()) {
                total = total - 1;
            } else if (q.getAns3() == q.getChose()) {
                total = total + 0;
            } else if (q.getAns4() == q.getChose()) {
                total = total + 1;
            } else if (q.getAns5() == q.getChose()) {
                total = total + 2;
            } else {
                total = total + 0;
            }
        }
        avaragePoint = total / 5;

        return avaragePoint;
    }




}

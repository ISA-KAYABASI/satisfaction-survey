package com.isakayabasi.maintermproject.service.Service;

import com.isakayabasi.maintermproject.model.QuestionForm;
import com.isakayabasi.maintermproject.model.Result;
import java.util.List;

public interface ResultService {

    public void saveSatisfaction(Result result);

    public List<Result> getTopScore();

    public String getResultSatisfaction(QuestionForm qForm);

    public void saveScore(Result result);

    String getMessageId(QuestionForm questionForm);


    double getResultPoint(QuestionForm qForm);
}

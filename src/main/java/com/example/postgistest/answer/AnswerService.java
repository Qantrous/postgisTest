package com.example.postgistest.answer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AnswerService {



    @Autowired
    private AnswerRepository answerRepository;


    public String getAnswer() {

        Random random = new Random();
        List<Answer> answers = answerRepository.findAll();

        return answers.get(random.nextInt(answers.size())).getAnswer();

    }
}

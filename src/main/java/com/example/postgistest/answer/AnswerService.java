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

    @PostConstruct
    public void generateData() {
        List<Answer> answers = new ArrayList<>();

        answers.add(new Answer("I love you"));
        answers.add(new Answer("I miss you"));
        answers.add(new Answer("I’m thinking about you"));
        answers.add(new Answer("I adore you"));
        answers.add(new Answer("You are my everything"));
        answers.add(new Answer("You take my breath away"));
        answers.add(new Answer("You make my smile"));
        answers.add(new Answer("I’m yours"));
        answers.add(new Answer("I’m always by your side"));
        answers.add(new Answer("I’ll love you always"));
        answers.add(new Answer("Remember the good times"));
        answers.add(new Answer("You’re worth every mile between us"));
        answers.add(new Answer("We’ll see each other soon"));
        answers.add(new Answer("Love conquers distance"));
        answers.add(new Answer("No regrets, just love"));
        answers.add(new Answer("send nudes"));
        answers.add(new Answer("send nudes"));
        answers.add(new Answer("wona fak?"));
        answers.add(new Answer("wona fak?"));
        answers.add(new Answer("No regrets, just love"));
        answers.add(new Answer("No regrets, just love"));
        answers.add(new Answer("No regrets, just love"));




        answers.forEach(answerRepository::saveAndFlush);
    }
}

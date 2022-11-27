package com.example.question;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class QuestionApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionApplication.class, args);
        question test = new question();
        int num = 20;
        List<question.inter_Static> list = test.get_Inter_Static();
        for (question.inter_Static qSaver: list) {
            System.out.println(qSaver.name+"\t"+ qSaver.gra_time+"\t"+ qSaver.major+"\t"+ qSaver.total_inter);
        }
    }

}

package edu.njit.test;

import org.springframework.stereotype.Component;

@Component
public class Test {

    public void say(String word){
        System.out.println("calss from entity:syaing===="+word);
    }
}

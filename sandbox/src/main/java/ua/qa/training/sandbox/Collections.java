package ua.qa.training.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by osoboleva on 9/29/2016.
 */
public class Collections {

    public static void main (String[] args) {
        String[] langs = {"Java", "C#", "Python", "PHP"};

        List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

        for (String l: languages){
            System.out.println("I want to learn " + l);
        }
    }
}

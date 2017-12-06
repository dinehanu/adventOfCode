package com.adventofcode;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class MainClass {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainClass.class);
        PassphraseValidator validator = context.getBean(PassphraseValidator.class);
        System.out.println("PassphraseValidator with file: passphrases.txt returns: " + validator.getNumberOfValidPassphrases("passphrases.txt"));
    }
}

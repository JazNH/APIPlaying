package org.example;

import java.util.Scanner;

public class DogStuff {

    public void dogStuff() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter a doggy name");
        String doggysName = myObj.nextLine();
        System.out.println("Enter a verb that a dog does");
        String doggysAction = myObj.nextLine();

        Dog dogOne = new Dog();
        dogOne.name = doggysName;
        dogOne.action = doggysAction;

        System.out.println("************************ here ************************");
        dogOne.action();
        System.out.println("************************ here ************************");
    }
}

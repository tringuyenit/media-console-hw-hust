package hust.soict.globalict.lab08.ver2.controller;

import java.util.Scanner;

public class MenuController {
    private final Scanner sc = new Scanner(System.in);
    AdminController adminController = new AdminController();
    UserController userController = new UserController();

    private void errorChoice(){
        System.out.println("--------------------------------");
        System.out.println("Please choose another number");
    }// shows error warning when user types in number that cannot be handled

    public void showMenu(){
        chooseMenuToShow();
    }

    public void chooseMenuToShow(){
        System.out.println("--------------------------------");
        System.out.println("Choose Mode");
        System.out.println("1. Admin");
        System.out.println("2. User");
        System.out.println("0. Exit");
        System.out.print("Your choice : ");

        try {
            int choice = Integer.parseInt(sc.nextLine());
            if (choice > 2 || choice < 0){
                errorChoice();
                chooseMenuToShow();
                return;
            }
            System.out.println("--------------------------------");
            switch (choice){
                case 1:
                    adminController.showMenu();
                    break;
                case 2:
                    userController.showMenu();
                    break;
                case 0:
                    System.out.println("~~~~~~~~~~ BYE BYE <3 ~~~~~~~~~~");
                    System.out.println("--------------------------------");
                    return;
            }
            chooseMenuToShow();
        } catch (Exception e){
            errorChoice();
            chooseMenuToShow();
        }
    }
}

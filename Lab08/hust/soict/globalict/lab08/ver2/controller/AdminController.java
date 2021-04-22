package hust.soict.globalict.lab08.ver2.controller;

import hust.soict.globalict.lab08.ver2.fakedb.FakeDB;
import hust.soict.globalict.lab08.ver2.service.AdminService;
import hust.soict.globalict.lab08.ver2.service.MediaService;
import hust.soict.globalict.lab08.ver2.service_impl.AdminServiceImpl;
import hust.soict.globalict.lab08.ver2.service_impl.MediaServiceImpl;
import java.util.Scanner;

public class AdminController {
    private final Scanner sc = new Scanner(System.in);
    private final MediaService mediaService = new MediaServiceImpl();
    private final AdminService adminService = new AdminServiceImpl();

    private void errorChoice(){
        System.out.println("--------------------------------");
        System.out.println("Please choose another number");
    }// shows error warning when user types in number that cannot be handled

    public void handleAdminZero(){
        System.out.println("--------------------------------");
        System.out.println("1. Create new item");
        System.out.println("2. Display the items list");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Your choice : ");

        try {
            int choice = Integer.parseInt(sc.nextLine());
            if (choice > 2 || choice < 0){
                errorChoice();
                handleAdminZero();
                return;
            }

            if (choice == 2){
                choice = 3; // 3 means displayResource() in handleChoiceAdmin() method
            }

            handleChoiceAdmin(choice);

        } catch (Exception e){
            errorChoice();
            handleAdminZero();
        }
    } // when the order has no item yet, there's no DELETE option
    public void handleAdmin(){
        System.out.println("--------------------------------");
        System.out.println("1. Create new item");
        System.out.println("2. Delete item by id");
        System.out.println("3. Display the items list");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Your choice : ");

        try {
            int choice = Integer.parseInt(sc.nextLine());
            if (choice > 3 || choice < 0){
                errorChoice();
                handleAdmin();
                return;
            }
            handleChoiceAdmin(choice);
        } catch (Exception e){
            errorChoice();
            handleAdmin();
        }
    }
    public void handleChoiceAdmin(int choice){
        switch (choice){
            case 1: //1. Create new item
                handleCreateByType();
                chooseMenuToShow();
                break;
            case 2: //2. Delete item by id
                try {
                    System.out.print("Your item id : ");
                    int choice_2 = Integer.parseInt(sc.nextLine());
                    if (choice_2 > FakeDB.getResourceSize() || choice_2 < 1){
                        errorChoice();
                        chooseMenuToShow();
                        return;
                    }
                    mediaService.deleteMedia(mediaService.findById(choice_2-1)); // minus 1 for indexing of array
                    chooseMenuToShow();

                } catch (Exception e){
                    errorChoice();
                    chooseMenuToShow();
                }
                break;
            case 3: //3. Display the items list
                mediaService.displayResource();
                chooseMenuToShow();
                break;
            case 0:
                break;
        }
    }

    public void chooseMenuToShow(){
        if (FakeDB.getResourceSize() > 0){
            handleAdmin();
        }else {
            handleAdminZero(); // when the order has no item yet, no DELETE option
        }
    }

    public void handleCreateByType(){
        System.out.println("--------------------------------");
        System.out.println("1. Book");
        System.out.println("2. DVD");
        System.out.println("3. CD");
        System.out.println("0. Back menu");

        try {
            System.out.print("Your choice : ");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice > 3 || choice < 0){
                errorChoice();
                handleCreateByType();
                return;
            }

            System.out.println("");
            System.out.println("!!! To escape at any point, press ENTER without any input !!!");
            switch (choice) {
                case 1:
                    mediaService.addMedia(adminService.setupBook());
                    break;
                case 2:
                    mediaService.addMedia(adminService.setupDVD());
                    break;
                case 3:
                    mediaService.addMedia(adminService.setupCD());
                    break;
            }

        } catch (Exception e){
            errorChoice();
            handleCreateByType();
        }
    }

    public void showMenu() {
        System.out.println("Product Management Application: ");
        chooseMenuToShow();
        System.out.println("--------------------------------");
        System.out.println("Thanks for using our Application");
    }


}

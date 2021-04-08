package hust.soict.globalict.lab06.ver2.controller;

import hust.soict.globalict.lab06.ver2.model.order.Order;
import hust.soict.globalict.lab06.ver2.service.MediaService;
import hust.soict.globalict.lab06.ver2.service.OrderService;
import hust.soict.globalict.lab06.ver2.service_impl.MediaServiceImpl;
import hust.soict.globalict.lab06.ver2.service_impl.OrderServiceImpl;

import java.util.Scanner;

public class OrderController {
    private final Scanner sc = new Scanner(System.in);
    private final OrderService orderService = new OrderServiceImpl();
    private final MediaService mediaService = new MediaServiceImpl();

    private void errorChoice(){
        System.out.println("--------------------------------");
        System.out.println("Please choose another number");
    }// shows error warning when user types in number that cannot be handled

    // HANDLING one order at a time -----------------
    public void handleOrderXZero(Order X){

        // shows current order's ID that user are using
        System.out.println("----- Current order id <"+orderService.getOrderId(X)+"> -----");


        System.out.println("1. Add item by id");
        System.out.println("2. Display available items");
        System.out.println("0. Main menu");
        System.out.println("--------------------------------");
        System.out.print("Your choice : ");

        try {
            int choice = Integer.parseInt(sc.nextLine());
            if (choice > 2 || choice < 0){
                errorChoice();
                handleOrderXZero(X);
                return;
            }
            if (choice == 2){
                choice = 4; // 4 means displayResource() in handleChoiceOrderX() method
            }//this "redirects" the choice number to suits handleChoiceOrderX() method
            handleChoiceOrderX(choice, X);

        } catch (Exception e){
            errorChoice();
            handleOrderXZero(X);
        }
    } // when the order has no item yet, there's no DELETE option
    public void handleOrderX(Order X){

        // shows current order's ID that user are using
        System.out.println("----- Current order id <"+orderService.getOrderId(X)+"> -----");


        System.out.println("1. Add item by id");
        System.out.println("2. Delete item by id");
        System.out.println("3. Display items in this order");
        System.out.println("4. Display available items");
        System.out.println("0. Main menu");
        System.out.println("--------------------------------");
        System.out.print("Your choice : ");

        try {
            int choice = Integer.parseInt(sc.nextLine());
            if (choice > 4 || choice < 0){
                errorChoice();
                handleOrderX(X);
                return;
            }
            handleChoiceOrderX(choice, X);
        } catch (Exception e){
            errorChoice();
            handleOrderX(X);
        }
    } // when one or more items exist, shows DELETE option
    public void handleChoiceOrderX(int choice, Order X){
        switch (choice){
            case 1: //1. Add item by id
                try {
                    System.out.print("Your item id : ");
                    int choice_2 = Integer.parseInt(sc.nextLine());
                    if (choice_2 > 8 || choice_2 < 1){
                        errorChoice();
                        if (X.getNumberOfItem() > 0){
                            handleOrderX(X); // when one or more items exist, show DELETE option
                        }else {
                            handleOrderXZero(X); // when the order has no item yet, no DELETE option
                        }
                        return;
                    }
                    orderService.addItemById(choice_2-1, X); // minus 1 for indexing of array
                    handleOrderX(X);
                } catch (Exception e){
                    errorChoice();
                    if (X.getNumberOfItem() > 0){
                        handleOrderX(X);
                    }else {
                        handleOrderXZero(X);
                    }
                }
                break;
            case 2: //2. Delete item by id
                try {
                    System.out.print("Your item id : ");
                    int choice_2 = Integer.parseInt(sc.nextLine());
                    if (choice_2 > 8 || choice_2 < 1){ // 8 because there are 8 sample media
                        errorChoice();
                        handleOrderX(X);
                        return;
                    }
                    orderService.deleteItemById(choice_2-1, X); // minus 1 for indexing of array

                    if (X.getNumberOfItem() > 0){
                        handleOrderX(X);
                    }else {
                        handleOrderXZero(X);
                    }

                } catch (Exception e){
                    errorChoice();
                    handleOrderX(X);
                }
                break;
            case 3: //3. Display items in this order
                X.listItemInOrder();
                handleOrderX(X);
                break;
            case 4: //4. Display available items
                mediaService.displayResource();
                if (X.getNumberOfItem() > 0){
                    handleOrderX(X);
                }else {
                    handleOrderXZero(X);
                }
                break;
            case 0:
                break;
        }
    }
}

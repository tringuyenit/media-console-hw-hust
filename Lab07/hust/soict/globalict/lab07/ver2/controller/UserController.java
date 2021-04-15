package hust.soict.globalict.lab07.ver2.controller;

import hust.soict.globalict.lab07.ver2.model.order.Order;
import hust.soict.globalict.lab07.ver2.service.OrderService;
import hust.soict.globalict.lab07.ver2.service_impl.OrderServiceImpl;

import java.util.Scanner;

public class UserController {
    private final Scanner sc = new Scanner(System.in);
    private final OrderService orderService = new OrderServiceImpl();
    private final OrderController orderController = new OrderController();

    private void errorChoice(){
        System.out.println("--------------------------------");
        System.out.println("Please choose another number");
    }// shows error warning when user types in number that cannot

    //HANDLING main menu ----------------------------
    private void handleUserZero(){
        System.out.println("--------------------------------");
        System.out.println("1. Create new order");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Your choice : ");

        try {
            int choice = Integer.parseInt(sc.nextLine());
            if (choice > 1 || choice < 0){
                errorChoice();
                handleUserZero();
                return;
            }
            handleChoiceMenu(choice);
        } catch (Exception e){
            errorChoice();
            handleUserZero();
        }
    } // when no order has been made, shows only "create" option
    private void handleUser(){
        System.out.println("--------------------------------");
        System.out.println("1. Create new order");
        System.out.println("2. Delete order by id");
        System.out.println("3. Display list of orders");
        System.out.println("4. Choose order by id to work with");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Your choice : ");

        try {
            int choice = Integer.parseInt(sc.nextLine());
            if (choice > 4 || choice < 0){
                errorChoice();
                handleUser();
                return;
            }
            handleChoiceMenu(choice);

        } catch (Exception e){
            errorChoice();
            handleUser();
        }
    } // when at least one order has been made, shows more options
    private void handleChoiceMenu(int choice){
        switch (choice){
            case 1: //1. Create new order
                Order X = orderService.createOrder();
                if (X != null){
                    orderController.handleOrderXZero(X);
                }
                handleUser();
                break;
            case 2: //2. Delete order by id
                try {
                    System.out.print("Your order id : ");
                    int choice_2 = Integer.parseInt(sc.nextLine());
                    if (choice_2 > orderService.findAll().size() || choice_2 < 0){
                        errorChoice();
                        handleUser();
                        return;
                    }
                    orderService.deleteOrderById(choice_2-1);
                    if (orderService.findAll().size() > 0){
                        handleUser();
                    } else {
                        handleUserZero();
                    }
                } catch (Exception e){
                    errorChoice();
                    handleUser();
                }
                break;
            case 3: // 3. Display list of orders
                orderService.displayOrders();
                if (orderService.findAll().size() > 0){
                    handleUser();
                    return;
                }
                handleUserZero();
                break;
            case 4: //4. Choose order by id to work with
                try {
                    System.out.print("Your order id : ");
                    int choice_2 = Integer.parseInt(sc.nextLine());
                    if (choice_2 > orderService.findAll().size() || choice_2 < 0){
                        errorChoice();
                        handleUser();
                        return;
                    }

                    if (orderService.findById(choice_2-1).getNumberOfItem() > 0){
                        orderController.handleOrderX(orderService.findById(choice_2-1));
                    } else {
                        orderController.handleOrderXZero(orderService.findById(choice_2-1));
                    }

                    handleUser();
                } catch (Exception e){
                    errorChoice();
                    handleUser();
                }
                break;
            case 0:
                break;
        }
    }

    public void chooseMenuToShow(){
        if (orderService.findAll().size() > 0){
            handleUser();
        } else {
            handleUserZero(); // when the order has no item yet, no DELETE option
        }
    }

    public void showMenu() {
        System.out.println("Order Management Application: ");
        chooseMenuToShow(); // when no order has been made, shows only "create" option
        System.out.println("--------------------------------");
        System.out.println("Thanks for using our Application");
    }
}

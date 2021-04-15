package hust.soict.globalict.lab07.ver2.controller;

import hust.soict.globalict.lab07.ver2.model.media.*;
import hust.soict.globalict.lab07.ver2.model.order.Order;
import hust.soict.globalict.lab07.ver2.service.MediaService;
import hust.soict.globalict.lab07.ver2.service.OrderService;
import hust.soict.globalict.lab07.ver2.service_impl.MediaServiceImpl;
import hust.soict.globalict.lab07.ver2.service_impl.OrderServiceImpl;

import java.util.List;
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
        System.out.println("3. Show available items with specific type");
        System.out.println("0. Main menu");
        System.out.println("--------------------------------");
        System.out.print("Your choice : ");

        try {
            int choice = Integer.parseInt(sc.nextLine());
            if (choice > 3 || choice < 0){
                errorChoice();
                handleOrderXZero(X);
                return;
            }

            if (choice == 2){
                choice = 4; // 4 means displayResource() in handleChoiceOrderX() method
            }else if(choice == 3){
                choice = 5; // 5 means handleShowByType(Order O) in handleChoiceOrderX() method
            } //this "redirects" the choice number to suits handleChoiceOrderX() method

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
        System.out.println("5. Show available items with specific type");
        System.out.println("0. Main menu");
        System.out.println("--------------------------------");
        System.out.print("Your choice : ");

        try {
            int choice = Integer.parseInt(sc.nextLine());
            if (choice > 5 || choice < 0){
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
    public void handleOrderX2(Order X){

        // shows current order's ID that user are using
        System.out.println("----- Current order id <"+orderService.getOrderId(X)+"> -----");


        System.out.println("1. Add item by id");
        System.out.println("2. Delete item by id");
        System.out.println("3. Display items in this order");
        System.out.println("4. Display available items");
        System.out.println("5. Show available items with specific type");
        System.out.println("6. Play sample");
        System.out.println("0. Main menu");
        System.out.println("--------------------------------");
        System.out.print("Your choice : ");

        try {
            int choice = Integer.parseInt(sc.nextLine());
            if (choice > 6 || choice < 0){
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
                    if (choice_2 > mediaService.findAll().size() || choice_2 < 1){
                        errorChoice();
                        chooseMenuToShow(X);
                        return;
                    }
                    orderService.addItemById(choice_2-1, X); // minus 1 for indexing of array
                    chooseMenuToShow(X);

                } catch (Exception e){
                    errorChoice();
                    chooseMenuToShow(X);
                }
                break;
            case 2: //2. Delete item by id
                try {
                    System.out.print("Your item id : ");
                    int choice_2 = Integer.parseInt(sc.nextLine());
                    if (choice_2 > X.getNumberOfItem() || choice_2 < 1){
                        errorChoice();
                        chooseMenuToShow(X);
                        return;
                    }
                    orderService.deleteItemById(choice_2-1, X); // minus 1 for indexing of array
                    chooseMenuToShow(X);

                } catch (Exception e){
                    errorChoice();
                    chooseMenuToShow(X);
                }
                break;
            case 3: //3. Display items in this order
                X.listItemInOrder();
                chooseMenuToShow(X);
                break;
            case 4: //4. Display available items
                mediaService.displayResource();
                chooseMenuToShow(X);
                break;
            case 5: //5. Show available items with specific type
                handleShowByType(X);
                chooseMenuToShow(X);
                break;
            case 6: //6. Play sample
                handleItemPlayable(X);
                chooseMenuToShow(X);
                break;
            case 0:
                break;
        }
    }

    public void chooseMenuToShow(Order O){
        if (O.getNumberOfItem() > 0){
            if(orderService.checkExistDisc(O)){
                handleOrderX2(O);
                return;
            }
            handleOrderX(O);
        }else {
            handleOrderXZero(O); // when the order has no item yet, no DELETE option
        }
    }

    public void handleShowByType(Order O){
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
                handleShowByType(O);
                return;
            }

            int max = 0;
            List<Media> listByType;
            System.out.println("");
            switch (choice){
                case 1:
                    listByType = mediaService.displayResourceByType(Book.class);
                    max = listByType.size();
                    break;
                case 2:
                    listByType = mediaService.displayResourceByType(DVD.class);
                    max = listByType.size();
                    break;
                case 3:
                    listByType = mediaService.displayResourceByType(CD.class);
                    max = listByType.size();
                    break;
                default:
                    return;
            }


            System.out.println("\nChoose item's id to add to cart");
            try {
                System.out.print("Your item id : ");
                int choice_2 = Integer.parseInt(sc.nextLine());
                if (choice_2 > max || choice_2 < 1){
                    errorChoice();
                    handleShowByType(O);
                    return;
                }

                O.addMedia(listByType.get(choice_2-1));
                System.out.println("Item has been added");
                handleShowByType(O);

            } catch (Exception e){
                errorChoice();
                handleShowByType(O);
            }

        } catch (Exception e){
            errorChoice();
            handleShowByType(O);
        }
    }
    public void handleItemPlayable(Order O){
        List<Disc> itemsPlayable = mediaService.displayResourcePlayable(O);

        System.out.println("\nChoose item's id to play sample");
        System.out.println("(*Type 0 to escape)");
        try {
            System.out.print("Your item id : ");
            int choice_2 = Integer.parseInt(sc.nextLine());
            if (choice_2 > itemsPlayable.size() || choice_2 < 0){
                errorChoice();
                System.out.println("--------------------------------");
                handleItemPlayable(O);
                return;
            }

            if(choice_2 == 0){
                return;
            }

            System.out.println("");
            itemsPlayable.get(choice_2-1).play();
            System.out.println("\n--------------------------------");
            handleItemPlayable(O);

        } catch (Exception e){
            errorChoice();
            System.out.println("--------------------------------");
            handleItemPlayable(O);
        }
    }

}

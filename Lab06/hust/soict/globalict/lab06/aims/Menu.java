package hust.soict.globalict.lab06.aims;

import hust.soict.globalict.lab06.aims.media.Book;
import hust.soict.globalict.lab06.aims.media.DVD;
import hust.soict.globalict.lab06.aims.media.Media;
import hust.soict.globalict.lab06.aims.order.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private final Scanner sc = new Scanner(System.in);
    private final ArrayList<Order> orders = new ArrayList<Order>(); // maximum 5 orders
    private static List<Media> resource; // sample data

    // generates sample data,
    // đại ca Châu bảo mỗi loại 4 cái
    static {
        Menu.resource = new ArrayList<>();

        DVD dvd1 = new DVD("The Lion King", "Animation",
                "Roger Allers", 87, 19.95f);
        DVD dvd2 = new DVD("Star Wars", "Science Fiction",
                "George", 87, 24.95f);
        DVD dvd3 = new DVD("Tom and Jerry", "Animation",
                "William Hanna", 100, 18.99f);
        DVD dvd4 = new DVD("Hornpub", "Action",
                "tringuyen", 69, 99.99f);

        Book book1 = new Book("Sherlock Holmes", "Adventures", 1f).addAuthor("Arthur Conan Doyle");
        Book book2 = new Book("Doraemon", "Comic", 2f).addAuthor("Fujiko F. Fujio").addAuthor("Motoo Abiko");
        Book book3 = new Book("Cambridge IELTS 10", "Study guide", 3f).addAuthor("Cambridge English");
        Book book4 = new Book("How To Read Minds", "Science", 4f).addAuthor("nigahiga");

        Menu.resource.add(dvd1);
        Menu.resource.add(dvd2);
        Menu.resource.add(dvd3);
        Menu.resource.add(dvd4);
        Menu.resource.add(book1);
        Menu.resource.add(book2);
        Menu.resource.add(book3);
        Menu.resource.add(book4);
    }

    public Menu(){
        showMenu();
    }

    // utilitis
    public void showMenu() {
        System.out.println("Order Management Application: ");
        mainMenuZero(); // when no order has been made, shows only "create" option
        System.out.println("--------------------------------");
        System.out.println("Thanks for using our Application");
    }
    private void errorChoice(){
        System.out.println("--------------------------------");
        System.out.println("Please choose another number");
    }// shows error warning when user types in number that cannot be handled
    private int getOrderId(Order O){
        return orders.indexOf(O)+1;
    } // shows current order's ID that user are using








    // ADD and DELETE methods------------------------
    private Order createOrder(){
        Order O = Order.makeOrder(); // maximum 5 orders
        if (O == null){
            return null;
        }
        this.orders.add(O); // maximum 5 orders
        System.out.println("An new order has been made");

        return O;
    }
    private void deleteOrderById(int id){
        this.orders.get(id).deleteOrder();
        this.orders.remove(id);
        System.out.println("Order has been deleted");
    }
    private void addItem(int id, Order O){
        if(O.addMedia(Menu.resource.get(id))){
            System.out.println("Item has been added");
        }
    }
    private void deleteItemById(int id, Order O){
        O.removeMediaById(id);
        System.out.println("Item has been deleted");
    }







    // RETRIEVING DATA methods-----------------------
    private void displayOrders(){
        System.out.print("Your orders' ids : ");
        for (int i = 1; i <= orders.size(); i++){
            System.out.print("<"+i+"> ");
        }
        System.out.println("");
    } // shows how many orders has been made - maximum 5 orders
    private void displayResource(){
        System.out.println("(Type)\t<Id>\t\t\t\t\t\t\t<Details>");
        int i = 1;
        for(Media m : Menu.resource){
            System.out.println("("+displayType(m)+")\t<"+i+"> "+ m.displayInfo());
            i++;
        }
    } // displays sample data
    private String displayType(Media m){
        if (m.getClass() == DVD.class){
            return "DVD";
        }
        return "Book";
    } // distinguishes types of media for users








    // HANDLING one order at a time -----------------
    private void handleOrderXZero(Order X){

        // shows current order's ID that user are using
        System.out.println("----- Current order id <"+getOrderId(X)+"> -----");


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
    private void handleOrderX(Order X){

        // shows current order's ID that user are using
        System.out.println("----- Current order id <"+getOrderId(X)+"> -----");


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
    private void handleChoiceOrderX(int choice, Order X){
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
                    addItem(choice_2-1, X); // minus 1 for indexing of array
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
                    deleteItemById(choice_2-1, X); // minus 1 for indexing of array

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
                displayResource();
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








    // HANDLING main menu ----------------------------
    private void mainMenuZero(){
        System.out.println("--------------------------------");
        System.out.println("1. Create new order");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Your choice : ");

        try {
            int choice = Integer.parseInt(sc.nextLine());
            if (choice > 1 || choice < 0){
                errorChoice();
                mainMenuZero();
                return;
            }
            handleChoiceMenu(choice);
        } catch (Exception e){
            errorChoice();
            mainMenuZero();
        }
    } // when no order has been made, shows only "create" option
    private void mainMenu(){
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
                mainMenu();
                return;
            }
            handleChoiceMenu(choice);

        } catch (Exception e){
            errorChoice();
            mainMenu();
        }
    } // when at least one order has been made, shows more options
    private void handleChoiceMenu(int choice){
        switch (choice){
            case 1: //1. Create new order
                Order X = createOrder();
                if (X != null){
                    handleOrderXZero(X);
                }
                mainMenu();
                break;
            case 2: //2. Delete order by id
                try {
                    System.out.print("Your order id : ");
                    int choice_2 = Integer.parseInt(sc.nextLine());
                    if (choice_2 > orders.size() || choice_2 < 0){
                        errorChoice();
                        mainMenu();
                        return;
                    }
                    deleteOrderById(choice_2-1);
                    if (orders.size() > 0){
                        mainMenu();
                    } else {
                        mainMenuZero();
                    }
                } catch (Exception e){
                    errorChoice();
                    mainMenu();
                }
                break;
            case 3: // 3. Display list of orders
                displayOrders();
                if (orders.size() > 0){
                    mainMenu();
                    return;
                }
                mainMenuZero();
                break;
            case 4: //4. Choose order by id to work with
                try {
                    System.out.print("Your order id : ");
                    int choice_2 = Integer.parseInt(sc.nextLine());
                    if (choice_2 > orders.size() || choice_2 < 0){
                        errorChoice();
                        mainMenu();
                        return;
                    }

                    if (orders.get(choice_2-1).getNumberOfItem() > 0){
                        handleOrderX(orders.get(choice_2-1));
                    } else {
                        handleOrderXZero(orders.get(choice_2-1));
                    }

                    mainMenu();
                } catch (Exception e){
                    errorChoice();
                    mainMenu();
                }
                break;
            case 0:
                break;
        }
    }


}

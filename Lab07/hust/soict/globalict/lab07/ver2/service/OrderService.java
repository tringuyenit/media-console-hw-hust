package hust.soict.globalict.lab07.ver2.service;

import hust.soict.globalict.lab07.ver2.model.order.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();
    Order findById(int id);
    Order createOrder();
    void deleteOrderById(int id);

    void addItemById(int id, Order O);
    void deleteItemById(int id, Order O);
    int getOrderId(Order O);
    boolean checkExistDisc(Order O);// check if exists item in cart that is playable --> then show play sample option

    void displayOrders(); // shows how many orders has been made - maximum 5 orders
}

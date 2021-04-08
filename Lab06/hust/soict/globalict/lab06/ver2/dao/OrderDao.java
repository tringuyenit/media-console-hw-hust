package hust.soict.globalict.lab06.ver2.dao;

import hust.soict.globalict.lab06.ver2.model.order.Order;

public interface OrderDao extends BaseDao<Order>{
    Order createOrder();
    void deleteOrderById(int id);
    void displayOrders(); // shows how many orders has been made - maximum 5 orders
}

package hust.soict.globalict.lab07.ver2.dao_impl;

import hust.soict.globalict.lab07.ver2.dao.OrderDao;
import hust.soict.globalict.lab07.ver2.fakedb.FakeDB;
import hust.soict.globalict.lab07.ver2.model.order.Order;

import java.util.List;

public class OrderDaoImpl implements OrderDao {

    @Override
    public List<Order> findAll() {
        return FakeDB.getOrders();
    }

    @Override
    public Order findById(int id) {
        return FakeDB.getOrders().get(id);
    }

    @Override
    public Order createOrder() {
        Order O = Order.makeOrder(); // maximum 5 orders
        if (O == null){
            return null;
        }
        this.findAll().add(O); // maximum 5 orders
        System.out.println("An new order has been made");

        return O;
    }

    @Override
    public void deleteOrderById(int id) {
        this.findAll().get(id).deleteOrder();
        this.findAll().remove(id);
        System.out.println("Order has been deleted");
    }

    @Override
    public void displayOrders(){
        System.out.print("Your orders' ids : ");
        for (int i = 1; i <= findAll().size(); i++){
            System.out.print("<"+i+"> ");
        }
        System.out.println("");
    } // shows how many orders has been made - maximum 5 orders
}

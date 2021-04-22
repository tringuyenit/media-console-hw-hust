package hust.soict.globalict.lab08.ver2.service_impl;

import hust.soict.globalict.lab08.ver2.dao.OrderDao;
import hust.soict.globalict.lab08.ver2.dao_impl.OrderDaoImpl;
import hust.soict.globalict.lab08.ver2.model.media.CD;
import hust.soict.globalict.lab08.ver2.model.media.DVD;
import hust.soict.globalict.lab08.ver2.model.media.Media;
import hust.soict.globalict.lab08.ver2.model.order.Order;
import hust.soict.globalict.lab08.ver2.service.MediaService;
import hust.soict.globalict.lab08.ver2.service.OrderService;

import java.util.List;
import java.util.Scanner;

public class OrderServiceImpl implements OrderService {
    private final Scanner sc = new Scanner(System.in);

    private final OrderDao orderDao = new OrderDaoImpl();
    private final MediaService mediaService = new MediaServiceImpl();

    private void errorChoice(){
        System.out.println("--------------------------------");
        System.out.println("Please choose another number");
    }

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    public Order findById(int id) {
        return orderDao.findById(id);
    }

    @Override
    public Order createOrder() {
        return orderDao.createOrder();
    }

    @Override
    public void deleteOrderById(int id) {
        orderDao.deleteOrderById(id);
    }

    @Override
    public void addItemById(int id, Order O) {
        if(O.addMedia(mediaService.findById(id))){
            System.out.println("Item has been added");
        }
    }

    @Override
    public void deleteItemById(int id, Order O) {
        O.removeMediaById(id);
        System.out.println("Item has been deleted");
    }

    @Override
    public int getOrderId(Order O){
        return orderDao.findAll().indexOf(O)+1;
    } // shows current order's ID that user are using

    @Override
    public boolean checkExistDisc(Order O) {
        for (Media m : O.getItemsOrdered()){
            if(m.getClass() == DVD.class || m.getClass() == CD.class){
                return true;
            }
        }
        return false;
    } // check if exists item in cart that is playable --> then show play sample option

    @Override
    public void displayOrders() {
        orderDao.displayOrders();
    }

}

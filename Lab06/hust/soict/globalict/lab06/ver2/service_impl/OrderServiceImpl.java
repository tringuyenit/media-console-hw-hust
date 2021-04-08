package hust.soict.globalict.lab06.ver2.service_impl;

import hust.soict.globalict.lab06.ver2.dao.OrderDao;
import hust.soict.globalict.lab06.ver2.dao_impl.OrderDaoImpl;
import hust.soict.globalict.lab06.ver2.model.order.Order;
import hust.soict.globalict.lab06.ver2.service.MediaService;
import hust.soict.globalict.lab06.ver2.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao = new OrderDaoImpl();
    private final MediaService mediaService = new MediaServiceImpl();

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
    public void displayOrders() {
        orderDao.displayOrders();
    }

}

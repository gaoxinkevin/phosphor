package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.ChildDAO;
import com.cafebabe.phosphor.dao.GroupDAO;
import com.cafebabe.phosphor.dao.OrderDAO;
import com.cafebabe.phosphor.dao.ParentDAO;
import com.cafebabe.phosphor.model.dto.OrderDTO;
import com.cafebabe.phosphor.model.dto.OrderDetail;
import com.cafebabe.phosphor.model.entity.Group;
import com.cafebabe.phosphor.model.entity.Order;
import com.cafebabe.phosphor.service.OrderService;
import com.cafebabe.phosphor.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.*;

/**
 *
 * @author thethingyk@gmail.com
 *
 * class_name: OrderServiceImpl
 *
 * create_date: 18-10-20
 *
 * create_time: 下午2:53
 *
 * description:
 **/

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;
    private final OrderDetailServiceImpl orderDetailService;
    private final ParentDAO parentDAO;
    private final ChildDAO childDAO;
    private final GroupDAO groupDAO;

    @Autowired
    public OrderServiceImpl(GroupDAO groupDAO, OrderDAO orderDAO, OrderDetailServiceImpl orderDetailService, ParentDAO parentDAO, ChildDAO childDAO) {
        this.groupDAO = groupDAO;
        this.orderDAO = orderDAO;
        this.orderDetailService = orderDetailService;
        this.parentDAO = parentDAO;
        this.childDAO = childDAO;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer insertOrder(Order order) {
        if(orderDAO.insertOrder(order)>0){
           return orderDAO.getOrderId();
        }else{
            return 0;
        }

    }

    @Override
    public Integer updateOrder(Order order) {
        return orderDAO.updateOrder(order);
    }

    @Override
    public Integer removeOrder(Integer id) {
        return orderDAO.removeOrder(id);
    }

    @Override
    public OrderDTO getOrderById(Integer id) {

        OrderDTO cache = RedisUtil.getObj("getOrderById"+id,OrderDTO.class);
        if (cache != null){
            return cache;
        }else {
            OrderDTO orderDTO = toOrderDTO(orderDAO.getOrderById(id));
            RedisUtil.set("getOrderById"+id,orderDTO);
            return orderDTO;
        }
    }

    @Override
    public List<OrderDTO> getOrderListAll() {

        List<OrderDTO> cache = RedisUtil.getList("getOrderDTOListAll");
        if (cache != null){
            return cache;
        }else {
            List<OrderDTO> orderDTOList = new ArrayList<>() ;
            List<Order> orders= orderDAO.getOrderListAll();
            for (Order order : orders) {
                orderDTOList.add(toOrderDTO(order));
            }
            RedisUtil.setList("getOrderDTOListAll",orderDTOList);
            return orderDTOList;
        }
    }

    @Override
    public List<OrderDTO> getOrderList(Integer id) {
        List<OrderDTO> cache = RedisUtil.getList("getOrderList"+id);
        if (cache != null&&cache.size()>0){
            return cache;
        }else {
            List<OrderDTO> orderDTOList = new ArrayList<>() ;
            List<Order> orders= orderDAO.getOrderList(id);
            for (Order order : orders) {
                orderDTOList.add(toOrderDTO(order));
            }
            RedisUtil.setList("getOrderList"+id,orderDTOList);
            return orderDTOList;
        }
    }

    @Override
    public List<OrderDTO> getOrderListByChildId(Integer id) {

        List<OrderDTO> cache = RedisUtil.getList("getOrderListByChildId"+id);
        if (cache != null){
            return cache;
        }else {
            List<OrderDTO> orderDTOList = new ArrayList<>() ;
            List<Order> orders= orderDAO.getOrderListByChildId(id);
            for (Order order : orders) {
                orderDTOList.add(toOrderDTO(order));
            }
            RedisUtil.setList("getOrderListByChildId"+id,orderDTOList);
            return orderDTOList;
        }
    }

    @Override
    public List<OrderDTO> getCourseOrderList(Integer parentId) {
        List<OrderDTO> cache = RedisUtil.getList("getCourseOrderList"+parentId);
        if (cache != null){
            return cache;
        }else {
            List<OrderDTO> orderDTOList = new ArrayList<>() ;
            List<Order> orders= orderDAO.getCourseOrderList(parentId);
            for (Order order : orders) {
                orderDTOList.add(toOrderDTO(order));
            }
            RedisUtil.setList("getCourseOrderList"+parentId,orderDTOList);
            return orderDTOList;
        }
    }

    @Override
    public List<OrderDTO> getGroupOrderList(Integer parentId) {
        List<OrderDTO> cache = RedisUtil.getList("getGroupOrderList"+parentId);
        if (cache != null){
            return cache;
        }else {
            List<OrderDTO> orderDTOList = new ArrayList<>() ;
            List<Order> orders= orderDAO.getGroupOrderList(parentId);
            for (Order order : orders) {
                orderDTOList.add(toOrderDTO(order));
            }
            RedisUtil.setList("getGroupOrderList"+parentId,orderDTOList);
            return orderDTOList;
        }
    }

    @Override
    public List<OrderDTO> getActivityOrderList(Integer parentId) {
        List<OrderDTO> cache = RedisUtil.getList("getActivityOrderList"+parentId);
        if (cache != null){
            return cache;
        }else {
            List<OrderDTO> orderDTOList = new ArrayList<>() ;
            List<Order> orders= orderDAO.getActivityOrderList(parentId);
            for (Order order : orders) {
                orderDTOList.add(toOrderDTO(order));
            }
            RedisUtil.setList("getActivityOrderList"+parentId,orderDTOList);
            return orderDTOList;
        }
    }

    @Override
    public OrderDTO createOrder(String type, Integer detailId) {
        String groupType= "group";
        String courseType = "course";
        String activityType = "activity";

        List<OrderDetail> orderDetails;
        OrderDTO orderDTO =new OrderDTO();
        if(groupType.equals(type)){
            orderDetails = orderDetailService.getListByGroupId(detailId);
            Group group = groupDAO.getGroupById(detailId);
            orderDTO.setOrderPrice(group.getGroupPrice());
            orderDTO.setOrderSf(groupType);
        }else if(courseType.equals(type)){
            orderDetails = orderDetailService.getListByCourseId(detailId,1);
            orderDTO.setOrderSf(courseType);
        }else if(activityType.equals(type)){
            orderDetails = orderDetailService.getListByActivityId(detailId,1);
            orderDTO.setOrderSf(activityType);
        }else {
            return null;
        }
        if (orderDetails.size()<=1) {orderDTO.setOrderPrice(orderDetails.get(0).getPrice());}
        orderDTO.setOrderState(detailId);
        orderDTO.setDetails(orderDetails);
        orderDTO.setOrderNumber("x"+new Random().nextLong());
        orderDTO.setOrderCreateTime(new Date());
        return orderDTO;
    }

    @Override
    public File createOrderPdfFile(Integer orderId) {

        return null;
    }

    @Override
    public Integer delFile(File file) {
        return null;
    }

    /**
     * 将订单转化为订单数据传输对象
     * @param order 订单
     * @return 订单数据传输对象
     */
    private OrderDTO toOrderDTO(Order order){
        if (order == null) {
            return null;
        }else {
            OrderDTO orderDTO = new OrderDTO();
            if (order.getCourseId()!=null){
                orderDTO.setDetails(orderDetailService.getListByCourseId(order.getCourseId(),order.getOrderState()));
            } else if(order.getGroupId()!=null){
                orderDTO.setDetails(orderDetailService.getListByGroupId(order.getGroupId()));
            } else if (order.getActivityId()!=null){
                orderDTO.setDetails(orderDetailService.getListByActivityId(order.getActivityId(),order.getOrderState()));
            }
            orderDTO.setOrderId(order.getOrderId());
            orderDTO.setOrderCreateTime(order.getOrderCreateTime());
            orderDTO.setChildId(order.getChildId());
            orderDTO.setChild(childDAO.getChildNameById(order.getChildId()));
            orderDTO.setOrderEndTime(order.getOrderEndTime());
            orderDTO.setOrderNumber(order.getOrderNumber());
            orderDTO.setOrderPrice(order.getOrderPrice());
            orderDTO.setOrderSf(order.getOrderSf());
            orderDTO.setOrderState(order.getOrderState());
            orderDTO.setParentId(order.getParentId());
            orderDTO.setParent(parentDAO.getParentNameById(order.getParentId()));
            return orderDTO;
        }
    }

    /**
     * 生成HTML代码
     * @return
     */
    public String getHtmlCode() throws IOException {
        //TODO 这里暂时生成静态的html代码，验证功能之后要删掉
        /*StringBuffer html = new StringBuffer();
        html.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
        html.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">")
                .append("<head>")
                .append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />")
                .append("<style type=\"text/css\" mce_bogus=\"1\">body {font-family: SimSun;}</style>")
                .append("<style type=\"text/css\">img {width: 700px;}</style>")
                .append("</head>")
                .append("<body>");
        html.append("<h1>这是一个PDF文档</h1>");
        html.append("<table>");
        html.append("<tr>")
                .append("<td>第一列</td>")
                .append("<td>第二列</td>")
                .append("<td>第三列</td>")
                .append("<td>第四列</td>");
        html.append("</tr>");
        html.append("</table>");
        html.append("</body>");
        html.append("</html>");
        return html.toString();*/
        String path = this.getClass().getResource("/") +"\\templates\\template.js";
        File file = new File(path);
        String suffix = ".html";
        if(!file.exists() && !file.getAbsolutePath().endsWith(suffix)){
            return "";
        }

        InputStream inputStream = new FileInputStream(file);
        StringBuffer stringBuffer = new StringBuffer();
        int c;
        while ((c = inputStream.read()) != 1){
            stringBuffer.append((char) c);
        }
        return stringBuffer.toString();
    }

}

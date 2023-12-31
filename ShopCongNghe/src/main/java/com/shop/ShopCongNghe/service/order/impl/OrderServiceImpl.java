package com.shop.ShopCongNghe.service.order.impl;

import com.shop.ShopCongNghe.dto.detail.card.CardResponse;
import com.shop.ShopCongNghe.dto.detail.color.ColorResponse;
import com.shop.ShopCongNghe.dto.detail.os.OsResponse;
import com.shop.ShopCongNghe.dto.detail.ram.RamResponse;
import com.shop.ShopCongNghe.dto.detail.rom.RomResponse;
import com.shop.ShopCongNghe.dto.order_detail.OrderDetailResponse;
import com.shop.ShopCongNghe.dto.productdetail.ProductDetailResponse;
import com.shop.ShopCongNghe.dto.role.RoleResponse;
import com.shop.ShopCongNghe.dto.user.UserResponse;
import com.shop.ShopCongNghe.entity.order.OrderEntity;
import com.shop.ShopCongNghe.entity.order_detail.OrderDetailEntity;
import com.shop.ShopCongNghe.entity.product.ProductDetailEntity;
import com.shop.ShopCongNghe.entity.user.UserEntity;
import com.shop.ShopCongNghe.repository.order.OrderRepository;
import com.shop.ShopCongNghe.repository.order_detail.OrderDetailRepository;
import com.shop.ShopCongNghe.repository.product.ProductDetailRepository;
import com.shop.ShopCongNghe.service.order.OrderService;
import com.shop.ShopCongNghe.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import com.shop.ShopCongNghe.dto.order.OrderRequest;
import com.shop.ShopCongNghe.dto.order.OrderResponse;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
@Service
public class OrderServiceImpl implements OrderService {

    private ModelMapper modelMapper;
    @Autowired
    private ProductDetailRepository productDetailRepository;
    @Autowired
    private UserService userService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

//    @Autowired
//    public OrderServiceImpl(ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//    }


    @Override
    public Boolean saveOrder(OrderRequest order) {
        try {
            BigDecimal yourDoubleValue = BigDecimal.valueOf(123456789.9999);
            System.out.println(yourDoubleValue);
            java.util.Date currentDate = new java.util.Date();
            Date date_note = new Date(currentDate.getYear(), currentDate.getMonth(), currentDate.getDate());

            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setId(order.getId());
            orderEntity.setStatus(order.getStatus());

            UserEntity userEntity = userService.showUserEntiy(order.getUser_id());
            orderEntity.setUser(userEntity);
            //orderRepository.save(orderEntity);

            float totalMoney = 0;
            OrderEntity ord = orderEntity;
            List<OrderDetailEntity> ordDe = new ArrayList<>();
            for( int i = 0 ; i < order.getOrderDetail().size() ;i++ ){
                OrderDetailEntity orderDetail = new OrderDetailEntity();
                ProductDetailEntity pro = productDetailRepository.findById(order.getOrderDetail().get(i).getProduct_detail_id() ).orElse(null) ;
                if (pro != null) {
                    orderDetail.setProduct_detail(pro);
                    orderDetail.setQuantity(order.getOrderDetail().get(i).getQuantity());
                    orderDetail.setDate_note(date_note);
                    orderDetail.setInto_money(order.getOrderDetail().get(i).getInto_money());
                    System.out.println(String.format("%.6E", (double) order.getOrderDetail().get(i).getInto_money() ));
                    orderDetail.setColor(order.getOrderDetail().get(i).getColor());
                    orderDetail.setOrder(ord); // Đảm bảo thiết lập quan hệ với đơn hàng
                    //totalMoney += order.getOrderDetail().get(i).getQuantity() * order.getOrderDetail().get(i).getInto_money() ;
                    totalMoney +=  order.getOrderDetail().get(i).getInto_money() ;
                    Long quantity_remain = pro.getQuantity_remain() - order.getOrderDetail().get(i).getQuantity();
                    pro.setQuantity_remain(quantity_remain);
                    productDetailRepository.save(pro);
                }

                orderEntity.setTotal_amount(totalMoney);

                ordDe.add(orderDetail);
            }
            orderEntity.setOrder_detail(ordDe);
            System.out.println(orderEntity.getTotal_amount());
            orderRepository.save(orderEntity);
            return true;
        } catch(Exception e){
            System.out.println("Error service create");
            System.out.println(e);
            return false;
        }

    }

    @Override
    public List<OrderResponse> showAllOrderByUser(Long id) {
        try {
            List<OrderEntity> orderEntity = orderRepository.findByUserId(id , Sort.by(Sort.Order.desc("id") ));

            List<OrderResponse> orderResponses = new ArrayList<>();
            for(int i = 0 ; i < orderEntity.size() ; i++){
                //OrderResponse orderResponse = modelMapper.map(orderEntity.get(i), OrderResponse.class) ;
                OrderResponse orderResponse = new OrderResponse();
                orderResponse.setId( orderEntity.get(i).getId() );
                orderResponse.setTotal_money( orderEntity.get(i).getTotal_amount() );
                orderResponse.setStatus( orderEntity.get(i).getStatus() );

                UserResponse userResponse = new UserResponse();
                userResponse.setId(orderEntity.get(i).getUser().getId());
                userResponse.setEmail(orderEntity.get(i).getUser().getEmail());
                userResponse.setAddress(orderEntity.get(i).getUser().getAddress());
                userResponse.setFull_name(orderEntity.get(i).getUser().getFull_name());
                userResponse.setPassword(orderEntity.get(i).getUser().getPassword());
                userResponse.setPhoneNumber(orderEntity.get(i).getUser().getPhoneNumber());
                RoleResponse roleResponse = new RoleResponse();
                roleResponse.setId(orderEntity.get(i).getUser().getRole().getId());
                roleResponse.setName(orderEntity.get(i).getUser().getRole().getName());
                userResponse.setRole(roleResponse);
                orderResponse.setUser(userResponse);

                List<OrderDetailResponse> orr = new ArrayList<>();
                for(int j = 0 ; j < orderEntity.get(i).getOrder_detail().size() ; j++ ){
                    // Order Response
                    OrderDetailResponse ordetailDetailResponse = new OrderDetailResponse();
                    ordetailDetailResponse.setId(orderEntity.get(i).getOrder_detail().get(j).getId());
                    ordetailDetailResponse.setQuantity(orderEntity.get(i).getOrder_detail().get(j).getQuantity());
                    ordetailDetailResponse.setInto_money(orderEntity.get(i).getOrder_detail().get(j).getInto_money());
                    ordetailDetailResponse.setDate_note(orderEntity.get(i).getOrder_detail().get(j).getDate_note());
                    ordetailDetailResponse.setColor(orderEntity.get(i).getOrder_detail().get(j).getColor());
                    String dateAsString = ordetailDetailResponse.getDateNoteAsString();
                    // ProductDetail Response            trong                OrderDetail Response
                    ProductDetailResponse productDetailResponse = new ProductDetailResponse();
                    productDetailResponse.setId(orderEntity.get(i).getOrder_detail().get(j).getProduct_detail().getId());
                    productDetailResponse.setDescription(orderEntity.get(i).getOrder_detail().get(j).getProduct_detail().getDescription());
                    productDetailResponse.setName(orderEntity.get(i).getOrder_detail().get(j).getProduct_detail().getName());
                    productDetailResponse.setImage(orderEntity.get(i).getOrder_detail().get(j).getProduct_detail().getImage());
                    productDetailResponse.setPrice(orderEntity.get(i).getOrder_detail().get(j).getProduct_detail().getPrice());
                    productDetailResponse.setVideo(orderEntity.get(i).getOrder_detail().get(j).getProduct_detail().getVideo());
                    productDetailResponse.setQuantity_remain( orderEntity.get(i).getOrder_detail().get(j).getProduct_detail().getQuantity_remain() );

                    ordetailDetailResponse.setProduct_detail(productDetailResponse);
                    orr.add(ordetailDetailResponse);
                }
                orderResponse.setOrder_detail(orr);
                orderResponses.add(orderResponse);
            }
            return orderResponses;
        } catch(Exception e){
            System.out.println("Error service order: List<OrderResponse>");
            System.out.println(e);
            return null;
        }

    }
}

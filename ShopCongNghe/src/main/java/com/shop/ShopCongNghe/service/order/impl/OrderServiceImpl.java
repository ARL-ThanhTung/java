package com.shop.ShopCongNghe.service.order.impl;

import com.shop.ShopCongNghe.dto.order_detail.OrderDetailResponse;
import com.shop.ShopCongNghe.dto.productdetail.ProductDetailResponse;
import com.shop.ShopCongNghe.dto.user.UserResponse;
import com.shop.ShopCongNghe.entity.order.OrderEntity;
import com.shop.ShopCongNghe.entity.user.UserEntity;
import com.shop.ShopCongNghe.repository.order.OrderRepository;
import com.shop.ShopCongNghe.service.order.OrderService;
import com.shop.ShopCongNghe.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import com.shop.ShopCongNghe.dto.order.OrderRequest;
import com.shop.ShopCongNghe.dto.order.OrderResponse;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderRepository orderRepository;

//    @Autowired
//    public OrderServiceImpl(ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//    }


    @Override
    public Boolean saveOrder(OrderRequest order) {
        try {
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setId(order.getId());
            orderEntity.setStatus(order.getStatus());
            orderEntity.setTotal_amount(order.getTotal_amount());
            UserEntity userEntity = userService.showUserEntiy(order.getUser_id());
            orderEntity.setUser(userEntity);
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
            List<OrderEntity> orderEntity = orderRepository.findByUserId(id);

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

                orderResponse.setUser(userResponse);

                List<OrderDetailResponse> orr = new ArrayList<>();
                for(int j = 0 ; j < orderEntity.get(i).getOrder_detail().size() ; j++ ){
                    OrderDetailResponse ordetailDetailResponse = new OrderDetailResponse();
                    ordetailDetailResponse.setId(orderEntity.get(i).getOrder_detail().get(j).getId());
                    ordetailDetailResponse.setQuantity(orderEntity.get(i).getOrder_detail().get(j).getQuantity());
                    ordetailDetailResponse.setInto_money(orderEntity.get(i).getOrder_detail().get(j).getInto_money());
                    ordetailDetailResponse.setDate_note(orderEntity.get(i).getOrder_detail().get(j).getDate_note());

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

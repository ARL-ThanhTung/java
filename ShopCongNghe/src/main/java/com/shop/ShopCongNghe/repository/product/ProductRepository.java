package com.shop.ShopCongNghe.repository.product;
import org.springframework.data.domain.Sort;
import com.shop.ShopCongNghe.entity.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    List<ProductEntity> findByCategoryId(Long categoryId , Sort sort );


//    @Query("SELECT pro FROM ProductEntity  pro , ProductDetailEntity  prode WHERE pro.id = prode.product.id " +
//            "and pro.name like %:name% and prode.price >= :minPrice " +
//            "and prode.price <= :maxPrice")
//    List<ProductEntity> findUsersByNameMinPriceMaxPrice(@Param("name") String name ,
//                                                        @Param("minPrice") Float minPrice ,
//                                                        @Param("maxPrice") Float maxPrice);
    @Query("SELECT pro FROM ProductEntity  pro  WHERE pro.branch.name like %:name% ")
    List<ProductEntity> findUsersByNameCateid(@Param("name") String name );

}

package com.shop.ShopCongNghe.service.product.impl;

import com.shop.ShopCongNghe.dto.detail.card.CardResponse;
import com.shop.ShopCongNghe.dto.detail.color.ColorResponse;
import com.shop.ShopCongNghe.dto.detail.os.OsResponse;
import com.shop.ShopCongNghe.dto.detail.ram.RamResponse;
import com.shop.ShopCongNghe.dto.detail.rom.RomResponse;
import com.shop.ShopCongNghe.dto.productdetail.ProductDetailResponse;
import com.shop.ShopCongNghe.entity.branch.BranchEntity;
import com.shop.ShopCongNghe.entity.category.CategoryEntity;
import com.shop.ShopCongNghe.entity.product.ProductEntity;

import com.shop.ShopCongNghe.repository.product.ProductRepository;

import com.shop.ShopCongNghe.service.branch.BranchService;
import com.shop.ShopCongNghe.service.category.CategoryService;
import com.shop.ShopCongNghe.service.product.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.shop.ShopCongNghe.dto.category.CategoryResponse;
import com.shop.ShopCongNghe.dto.product.ProductResponse;
import com.shop.ShopCongNghe.dto.branch.BranchResponse;

import com.shop.ShopCongNghe.dto.product.ProductRequest ;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BranchService branchService;

    @Autowired
    private CategoryService categoryService;

    @Override
    public ProductEntity saveProduct(ProductRequest productRequest) {

        try {
            ProductEntity product = new ProductEntity();
            product.setTitle(productRequest.getTitle());
            product.setName(productRequest.getName());
            product.setDescription((productRequest.getDescription()));
            product.setImage(productRequest.getImage());
            product.setOrigin(productRequest.getOrigin());


            BranchEntity exist_branch = branchService.getBranch(productRequest.getBranch_id());
            CategoryEntity exist_category = categoryService.getCategory(productRequest.getBranch_id());
            if( exist_branch != null ){
                product.checkBranch(exist_branch);
            }
            if( exist_category != null ){
                product.checkCategory(exist_category);
            }
            return productRepository.save(product);
        } catch (Exception e){
            System.out.println(e);
            System.out.println("Error API Product create");
        }
        return null ;
        //return productRepository.save(product);
    }

    @Override
    public ProductEntity getProduct(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<ProductResponse> showAllProduct() {
        List<ProductResponse> productResponses = new ArrayList<>();
        List<ProductEntity> productEntity = productRepository.findAll();
        for( int i = 0 ; i < productEntity.size() ; i++ ){
            ProductResponse proRes = new ProductResponse();
            proRes.setId(productEntity.get(i).getId());
            proRes.setTitle( productEntity.get(i).getTitle() );
            proRes.setName( productEntity.get(i).getName() ) ;
            proRes.setDescription( productEntity.get(i).getDescription() );
            proRes.setImage( productEntity.get(i).getImage() );
            proRes.setOrigin(productEntity.get(i).getOrigin());

            if (productEntity.get(i).getBranch() != null){
                BranchResponse branch = new BranchResponse();
                branch.setId( productEntity.get(i).getBranch().getId() );
                branch.setName( productEntity.get(i).getBranch().getName() );
                proRes.setBranch( branch );
            }
            if ( productEntity.get(i).getCategory() != null ){
                CategoryResponse category = new CategoryResponse();
                category.setId( productEntity.get(i).getCategory().getId() );
                category.setName( productEntity.get(i).getCategory().getName() );
                proRes.setCategory( category );
            }


            productResponses.add(proRes);
        }
        return productResponses ;
    }

    @Override
    public ProductResponse showProductById(Long id) {
        ProductEntity productEntity = productRepository.findById(id).get();
        ProductResponse proRes = new ProductResponse();
        proRes.setId(productEntity.getId());
        proRes.setTitle( productEntity.getTitle() );
        proRes.setName( productEntity.getName() ) ;
        proRes.setDescription( productEntity.getDescription() );
        proRes.setImage( productEntity.getImage() );
        proRes.setOrigin(productEntity.getOrigin());

        if (productEntity.getBranch() != null){
            BranchResponse branch = new BranchResponse();
            branch.setId( productEntity.getBranch().getId() );
            branch.setName( productEntity.getBranch().getName() );
            proRes.setBranch( branch );
        }
        if ( productEntity.getCategory() != null ){
            CategoryResponse category = new CategoryResponse();
            category.setId( productEntity.getCategory().getId() );
            category.setName( productEntity.getCategory().getName() );
            proRes.setCategory( category );
        }
        List<ProductDetailResponse> productDetailResponses = new ArrayList<>();
        for( int i = 0 ; i < productEntity.getProductDetails().size() ; i++ ){
            ProductDetailResponse productDetail = new ProductDetailResponse();
            productDetail.setId(productEntity.getProductDetails().get(i).getId() );
            productDetail.setDescription(productEntity.getProductDetails().get(i).getDescription());
            productDetail.setQuantity_remain(productEntity.getProductDetails().get(i).getQuantity_remain());
            productDetail.setVideo(productEntity.getProductDetails().get(i).getVideo());
            productDetail.setImage(productEntity.getProductDetails().get(i).getImage());
            productDetail.setPrice(productEntity.getProductDetails().get(i).getPrice());
            productDetail.setCamera(productEntity.getProductDetails().get(i).getCamera());
            productDetail.setCameraSelf(productEntity.getProductDetails().get(i).getCameraSelf());
            productDetail.setBattery(productEntity.getProductDetails().get(i).getBattery());
            productDetail.setChip(productEntity.getProductDetails().get(i).getChip());
            productDetail.setScreen(productEntity.getProductDetails().get(i).getScreen());

            RamResponse a = new RamResponse();
            a.setId(productEntity.getProductDetails().get(i).getRam().getId());
            a.setName(productEntity.getProductDetails().get(i).getRam().getName());
            RomResponse b = new RomResponse();
            b.setId(productEntity.getProductDetails().get(i).getRom().getId());
            b.setName(productEntity.getProductDetails().get(i).getRom().getName());
            ColorResponse c = new ColorResponse();
            c.setId(productEntity.getProductDetails().get(i).getColor().getId());
            c.setName(productEntity.getProductDetails().get(i).getColor().getName());
            OsResponse d = new OsResponse();
            d.setId(productEntity.getProductDetails().get(i).getOs().getId());
            d.setName(productEntity.getProductDetails().get(i).getOs().getName());
            CardResponse e = new CardResponse();
            e.setId(productEntity.getProductDetails().get(i).getCard().getId());
            e.setName(productEntity.getProductDetails().get(i).getCard().getName());
            productDetail.setRam(a);
            productDetail.setRom(b);
            productDetail.setColor(c);
            productDetail.setOs(d);
            productDetail.setCard(e);

            productDetailResponses.add(productDetail);
        }
        proRes.setProduct_detail(productDetailResponses);
        return proRes ;
    }


}

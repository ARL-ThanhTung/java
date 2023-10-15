package com.shop.ShopCongNghe.service.product.impl;


import com.shop.ShopCongNghe.dto.branch.BranchResponse;
import com.shop.ShopCongNghe.dto.category.CategoryResponse;
import com.shop.ShopCongNghe.dto.detail.card.CardResponse;
import com.shop.ShopCongNghe.dto.detail.color.ColorResponse;
import com.shop.ShopCongNghe.dto.detail.image.ImageResponse;
import com.shop.ShopCongNghe.dto.detail.os.OsResponse;
import com.shop.ShopCongNghe.dto.detail.ram.RamResponse;
import com.shop.ShopCongNghe.dto.detail.rom.RomResponse;
import com.shop.ShopCongNghe.dto.product.ProductResponse;
import com.shop.ShopCongNghe.dto.productdetail.ProductDetailRequest;
import com.shop.ShopCongNghe.entity.product.ProductDetailEntity;
import com.shop.ShopCongNghe.entity.product.ProductEntity;
import com.shop.ShopCongNghe.entity.product.detail.*;
import com.shop.ShopCongNghe.repository.product.ProductDetailRepository;
import com.shop.ShopCongNghe.service.product.ProductDetailService;
import com.shop.ShopCongNghe.service.product.ProductService;
import com.shop.ShopCongNghe.service.product.detail.*;
import com.shop.ShopCongNghe.dto.productdetail.ProductDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private RamService ramService;

    @Autowired
    private RomService romService;

    @Autowired
    private OSService osService;

    @Autowired
    private ColorService colorService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private CardService cardService;

    @Override
    public Boolean saveProductDetail(ProductDetailRequest productDetailRequest) {
        try{
            ProductDetailEntity productDetail = new ProductDetailEntity();
            //productDetail.setId(productDetailRequest.getId());
            productDetail.setPrice(productDetailRequest.getPrice());
            productDetail.setCamera(productDetailRequest.getCamera());
            productDetail.setCameraSelf(productDetailRequest.getCameraSelf());
            productDetail.setBattery(productDetailRequest.getBattery());
            productDetail.setDescription(productDetailRequest.getDescription());
            productDetail.setVideo(productDetailRequest.getVideo() );
            productDetail.setImage(productDetailRequest.getImage());
            productDetail.setQuantity_remain(productDetailRequest.getQuantity_remain());

            ProductEntity check_product = productService.getProduct(productDetailRequest.getProduct_id());
            RamEntity check_ram = ramService.getRam(productDetailRequest.getRam_id());
            RomEntity check_rom = romService.getRom(productDetailRequest.getRom_id());
            OSEntity check_os = osService.getOS(productDetailRequest.getOs_id());
            ColorEntity check_color = colorService.getColor(productDetailRequest.getColor_id());
            //ImageEntity check_image = imageService.getImage(productDetailRequest.getImage_id());
            CardEntity check_card = cardService.getCard(productDetailRequest.getCard_id());
            if ( check_product != null ){
                productDetail.setProduct( check_product );
            }
            if ( check_ram != null ){
                productDetail.setRam( check_ram );
            }
            if ( check_rom != null ){
                productDetail.setRom( check_rom );
            }
            if ( check_os != null ){
                productDetail.setOs( check_os );
            }
            if ( check_color != null ){
                productDetail.setColor( check_color );
            }
//            if ( check_image != null ){
//                productDetail.setImage( check_image );
//            }
            if ( check_card != null ){
                productDetail.setCard( check_card );
            }
            ProductDetailEntity check_create = productDetailRepository.save(productDetail);
            if (check_create == null){
                return false;
            }
            return true;
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public List<ProductDetailResponse> showAllProductDetail() {
        try {
            List<ProductDetailEntity> productDetailEntities = productDetailRepository.findAll();
            //productDetailEntities = productDetailRepository.findAll();
            List<ProductDetailResponse> productDetailResponses = new ArrayList<>();
            for( int i = 0 ; i < productDetailEntities.size() ; i++ ){
                ProductDetailResponse productDetail = new ProductDetailResponse();
                // ram
                RamResponse ramResponse = new RamResponse();
                ramResponse.setId(productDetailEntities.get(i).getRam().getId());
                ramResponse.setName(productDetailEntities.get(i).getRam().getName());
                productDetail.setRam(ramResponse);
                // rom
                RomResponse romResponse = new RomResponse();
                romResponse.setId(productDetailEntities.get(i).getRom().getId());
                romResponse.setName(productDetailEntities.get(i).getRom().getName());
                productDetail.setRom(romResponse);
                // image
//                ImageResponse imageResponse = new ImageResponse();
//                imageResponse.setId(productDetailEntities.get(i).getImage().getId());
//                imageResponse.setName(productDetailEntities.get(i).getImage().getName());
//                productDetail.setImage(imageResponse);
                // card
                CardResponse cardResponse = new CardResponse();
                cardResponse.setId(productDetailEntities.get(i).getCard().getId());
                cardResponse.setName(productDetailEntities.get(i).getCard().getName());
                productDetail.setCard(cardResponse);
                // os
                OsResponse osResponse = new OsResponse();
                osResponse.setId(productDetailEntities.get(i).getOs().getId());
                osResponse.setName(productDetailEntities.get(i).getOs().getName());
                productDetail.setOs(osResponse);

                // color
                ColorResponse colorResponse = new ColorResponse();
                colorResponse.setId(productDetailEntities.get(i).getColor().getId());
                colorResponse.setName(productDetailEntities.get(i).getColor().getName());
                productDetail.setColor(colorResponse);
                // product
                ProductResponse product = new ProductResponse();
                product.setId(productDetailEntities.get(i).getProduct().getId());
                product.setTitle(productDetailEntities.get(i).getProduct().getTitle());
                product.setName(productDetailEntities.get(i).getProduct().getName());
                product.setImage(productDetailEntities.get(i).getProduct().getImage());
                product.setDescription(productDetailEntities.get(i).getProduct().getDescription());
                product.setChip(productDetailEntities.get(i).getProduct().getChip());
                product.setScreen(productDetailEntities.get(i).getProduct().getScreen());
                BranchResponse branchResponse = new BranchResponse();
                branchResponse.setId(productDetailEntities.get(i).getProduct().getBranch().getId());
                branchResponse.setName(productDetailEntities.get(i).getProduct().getBranch().getName());
                product.setBranch(branchResponse);
                CategoryResponse categoryResponse = new CategoryResponse();
                categoryResponse.setId(productDetailEntities.get(i).getProduct().getCategory().getId());
                categoryResponse.setName(productDetailEntities.get(i).getProduct().getCategory().getName());
                product.setCategory(categoryResponse);
                productDetail.setProduct(product);

                productDetail.setId(productDetailEntities.get(i).getId());
                productDetail.setDescription(productDetailEntities.get(i).getDescription());
                productDetail.setImage(productDetailEntities.get(i).getImage());
                productDetail.setVideo(productDetailEntities.get(i).getVideo());
                productDetail.setPrice(productDetailEntities.get(i).getPrice());
                productDetail.setCamera(productDetailEntities.get(i).getCamera());
                productDetail.setCameraSelf(productDetailEntities.get(i).getCameraSelf());
                productDetail.setBattery(productDetailEntities.get(i).getBattery());
                productDetail.setQuantity_remain( productDetailEntities.get(i).getQuantity_remain() );
                productDetailResponses.add(productDetail);

            }
            return productDetailResponses;
        } catch(Exception e){
            System.out.println(e);
        }
        return null;

    }

    public ProductDetailResponse showProductDetail(Long id){
        try {
            ProductDetailEntity productDetailEntities = productDetailRepository.findById(id).get();
            if (productDetailEntities == null){
                return null;
            }
            ProductDetailResponse productDetail = new ProductDetailResponse();
            // ram
            RamResponse ramResponse = new RamResponse();
            ramResponse.setId(productDetailEntities.getRam().getId());
            ramResponse.setName(productDetailEntities.getRam().getName());
            productDetail.setRam(ramResponse);
            // rom
            RomResponse romResponse = new RomResponse();
            romResponse.setId(productDetailEntities.getRom().getId());
            romResponse.setName(productDetailEntities.getRom().getName());
            productDetail.setRom(romResponse);
            // image
//            ImageResponse imageResponse = new ImageResponse();
//            imageResponse.setId(productDetailEntities.getImage().getId());
//            imageResponse.setName(productDetailEntities.getImage().getName());
//            productDetail.setImage(imageResponse);
            // card
            CardResponse cardResponse = new CardResponse();
            cardResponse.setId(productDetailEntities.getCard().getId());
            cardResponse.setName(productDetailEntities.getCard().getName());
            productDetail.setCard(cardResponse);
            // os
            OsResponse osResponse = new OsResponse();
            osResponse.setId(productDetailEntities.getOs().getId());
            osResponse.setName(productDetailEntities.getOs().getName());
            productDetail.setOs(osResponse);

            // color
            ColorResponse colorResponse = new ColorResponse();
            colorResponse.setId(productDetailEntities.getColor().getId());
            colorResponse.setName(productDetailEntities.getColor().getName());
            productDetail.setColor(colorResponse);
            // product
            ProductResponse product = new ProductResponse();
            product.setId(productDetailEntities.getProduct().getId());
            product.setTitle(productDetailEntities.getProduct().getTitle());
            product.setName(productDetailEntities.getProduct().getName());
            product.setImage(productDetailEntities.getProduct().getImage());
            product.setDescription(productDetailEntities.getProduct().getDescription());
            product.setChip(productDetailEntities.getProduct().getChip());
            product.setScreen(productDetailEntities.getProduct().getScreen());

            BranchResponse branchResponse = new BranchResponse();
            branchResponse.setId(productDetailEntities.getProduct().getBranch().getId());
            branchResponse.setName(productDetailEntities.getProduct().getBranch().getName());
            product.setBranch(branchResponse);
            CategoryResponse categoryResponse = new CategoryResponse();
            categoryResponse.setId(productDetailEntities.getProduct().getCategory().getId());
            categoryResponse.setName(productDetailEntities.getProduct().getCategory().getName());
            product.setCategory(categoryResponse);
            productDetail.setProduct(product);

            productDetail.setId(productDetailEntities.getId());
            productDetail.setDescription(productDetailEntities.getDescription());
            productDetail.setImage(productDetailEntities.getImage());
            productDetail.setVideo(productDetailEntities.getVideo());
            productDetail.setPrice(productDetailEntities.getPrice());
            productDetail.setCamera(productDetailEntities.getCamera());
            productDetail.setCameraSelf(productDetailEntities.getCameraSelf());
            productDetail.setBattery(productDetailEntities.getBattery());
            productDetail.setQuantity_remain( productDetailEntities.getQuantity_remain() );

            if (productDetail == null){
                return null;
            }
            return productDetail;
        } catch(Exception e){
            System.out.println("Error Get by Id ProductDetail");
            System.out.println(e);
        }

        return null;
    }



}

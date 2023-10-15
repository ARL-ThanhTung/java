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
    public ProductDetailEntity saveProductDetail(ProductDetailRequest productDetailRequest) {
        try{
            ProductDetailEntity productDetail = productDetailRequest.getProductDetailEntity();
            ProductEntity check_product = productService.getProduct(productDetailRequest.getProduct_id());
            RamEntity check_ram = ramService.getRam(productDetailRequest.getRam_id());
            RomEntity check_rom = romService.getRom(productDetailRequest.getRom_id());
            OSEntity check_os = osService.getOS(productDetailRequest.getOs_id());
            ColorEntity check_color = colorService.getColor(productDetailRequest.getColor_id());
            ImageEntity check_image = imageService.getImage(productDetailRequest.getImage_id());
            CardEntity check_card = cardService.getCard(productDetailRequest.getCard_id());
            if ( check_product != null ){
                productDetail.checkProduct( check_product );
            }
            if ( check_ram != null ){
                List<RamEntity> rams = new ArrayList<>();
                rams.add(check_ram);
                productDetail.checkRam( rams );
            }
            if ( check_rom != null ){
                List<RomEntity> roms = new ArrayList<>();
                roms.add(check_rom);
                productDetail.checkRom( roms );
            }
            if ( check_os != null ){
                List<OSEntity> oss = new ArrayList<>();
                oss.add(check_os);
                productDetail.checkOS( oss );
            }
            if ( check_color != null ){
                List<ColorEntity> colors = new ArrayList<>();
                colors.add(check_color);
                productDetail.checkColor( colors );
            }
            if ( check_image != null ){
                List<ImageEntity> images = new ArrayList<>();
                images.add(check_image);
                productDetail.checkImage( images );
            }
            if ( check_card != null ){
                List<CardEntity> cards = new ArrayList<>();
                cards.add(check_card);
                productDetail.checkCard( cards );
            }
            return productDetailRepository.save(productDetail);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
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
                List<RamResponse> ram = new ArrayList<>();
                for(int j = 0 ; j < productDetailEntities.get(i).getRams().size() ; j++){
                    RamResponse ramResponse = new RamResponse();
                    ramResponse.setId(productDetailEntities.get(i).getRams().get(j).getId());
                    ramResponse.setName(productDetailEntities.get(i).getRams().get(j).getName());
                    ram.add(ramResponse);
                }
                // rom
                List<RomResponse> rom = new ArrayList<>();
                for(int j = 0 ; j < productDetailEntities.get(i).getRoms().size() ; j++){
                    RomResponse romResponse = new RomResponse();
                    romResponse.setId(productDetailEntities.get(i).getRoms().get(j).getId());
                    romResponse.setName(productDetailEntities.get(i).getRoms().get(j).getName());
                    rom.add(romResponse);
                }
                // image
                List<ImageResponse> image = new ArrayList<>();
                for(int j = 0 ; j < productDetailEntities.get(i).getImages().size() ; j++){
                    ImageResponse imageResponse = new ImageResponse();
                    imageResponse.setId(productDetailEntities.get(i).getImages().get(j).getId());
                    imageResponse.setName(productDetailEntities.get(i).getImages().get(j).getName());
                    image.add(imageResponse);
                }
                // card
                List<CardResponse> card = new ArrayList<>();
                for(int j = 0 ; j < productDetailEntities.get(i).getCards().size() ; j++){
                    CardResponse cardResponse = new CardResponse();
                    cardResponse.setId(productDetailEntities.get(i).getCards().get(j).getId());
                    cardResponse.setName(productDetailEntities.get(i).getCards().get(j).getName());
                    card.add(cardResponse);
                }
                // os
                List<OsResponse> os = new ArrayList<>();
                for(int j = 0 ; j < productDetailEntities.get(i).getOss().size() ; j++){
                    OsResponse osResponse = new OsResponse();
                    osResponse.setId(productDetailEntities.get(i).getOss().get(j).getId());
                    osResponse.setName(productDetailEntities.get(i).getOss().get(j).getName());
                    os.add(osResponse);
                }
                // color
                List<ColorResponse> color = new ArrayList<>();
                for(int j = 0 ; j < productDetailEntities.get(i).getColors().size() ; j++){
                    ColorResponse colorResponse = new ColorResponse();
                    colorResponse.setId(productDetailEntities.get(i).getColors().get(j).getId());
                    colorResponse.setName(productDetailEntities.get(i).getColors().get(j).getName());
                    color.add(colorResponse);
                }
                // product
                ProductResponse product = new ProductResponse();
                product.setId(productDetailEntities.get(i).getProduct().getId());
                product.setTitle(productDetailEntities.get(i).getProduct().getTitle());
                product.setName(productDetailEntities.get(i).getProduct().getName());
                product.setImage(productDetailEntities.get(i).getProduct().getImage());
                product.setDescription(productDetailEntities.get(i).getProduct().getDescription());
                BranchResponse branchResponse = new BranchResponse();
                branchResponse.setId(productDetailEntities.get(i).getProduct().getBranch().getId());
                branchResponse.setName(productDetailEntities.get(i).getProduct().getBranch().getName());
                product.setBranch(branchResponse);
                CategoryResponse categoryResponse = new CategoryResponse();
                categoryResponse.setId(productDetailEntities.get(i).getProduct().getCategory().getId());
                categoryResponse.setName(productDetailEntities.get(i).getProduct().getCategory().getName());
                product.setCategory(categoryResponse);

                productDetail.setColor(color);
                productDetail.setImage(image);
                productDetail.setProduct(product);
                productDetail.setCard(card);
                productDetail.setOs(os);
                productDetail.setRom(rom);
                productDetail.setRam(ram);
                productDetail.setId(productDetailEntities.get(i).getId());
                productDetail.setDescription(productDetailEntities.get(i).getDescription());
                productDetail.setPrice(productDetailEntities.get(i).getPrice());
                productDetail.setCamera(productDetailEntities.get(i).getCamera());
                productDetail.setCameraSelf(productDetailEntities.get(i).getCameraSelf());
                productDetail.setBattery(productDetailEntities.get(i).getBattery());
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
            List<RamResponse> ram = new ArrayList<>();
            for(int j = 0 ; j < productDetailEntities.getRams().size() ; j++){
                RamResponse ramResponse = new RamResponse();
                ramResponse.setId(productDetailEntities.getRams().get(j).getId());
                ramResponse.setName(productDetailEntities.getRams().get(j).getName());
                ram.add(ramResponse);
            }
            // rom
            List<RomResponse> rom = new ArrayList<>();
            for(int j = 0 ; j < productDetailEntities.getRoms().size() ; j++){
                RomResponse romResponse = new RomResponse();
                romResponse.setId(productDetailEntities.getRoms().get(j).getId());
                romResponse.setName(productDetailEntities.getRoms().get(j).getName());
                rom.add(romResponse);
            }
            // image
            List<ImageResponse> image = new ArrayList<>();
            for(int j = 0 ; j < productDetailEntities.getImages().size() ; j++){
                ImageResponse imageResponse = new ImageResponse();
                imageResponse.setId(productDetailEntities.getImages().get(j).getId());
                imageResponse.setName(productDetailEntities.getImages().get(j).getName());
                image.add(imageResponse);
            }
            // card
            List<CardResponse> card = new ArrayList<>();
            for(int j = 0 ; j < productDetailEntities.getCards().size() ; j++){
                CardResponse cardResponse = new CardResponse();
                cardResponse.setId(productDetailEntities.getCards().get(j).getId());
                cardResponse.setName(productDetailEntities.getCards().get(j).getName());
                card.add(cardResponse);
            }
            // os
            List<OsResponse> os = new ArrayList<>();
            for(int j = 0 ; j < productDetailEntities.getOss().size() ; j++){
                OsResponse osResponse = new OsResponse();
                osResponse.setId(productDetailEntities.getOss().get(j).getId());
                osResponse.setName(productDetailEntities.getOss().get(j).getName());
                os.add(osResponse);
            }
            // color
            List<ColorResponse> color = new ArrayList<>();
            for(int j = 0 ; j < productDetailEntities.getColors().size() ; j++){
                ColorResponse colorResponse = new ColorResponse();
                colorResponse.setId(productDetailEntities.getColors().get(j).getId());
                colorResponse.setName(productDetailEntities.getColors().get(j).getName());
                color.add(colorResponse);
            }
            // product
            ProductResponse product = new ProductResponse();
            product.setId(productDetailEntities.getProduct().getId());
            product.setTitle(productDetailEntities.getProduct().getTitle());
            product.setName(productDetailEntities.getProduct().getName());
            product.setImage(productDetailEntities.getProduct().getImage());
            product.setDescription(productDetailEntities.getProduct().getDescription());
            BranchResponse branchResponse = new BranchResponse();
            branchResponse.setId(productDetailEntities.getProduct().getBranch().getId());
            branchResponse.setName(productDetailEntities.getProduct().getBranch().getName());
            product.setBranch(branchResponse);
            CategoryResponse categoryResponse = new CategoryResponse();
            categoryResponse.setId(productDetailEntities.getProduct().getCategory().getId());
            categoryResponse.setName(productDetailEntities.getProduct().getCategory().getName());
            product.setCategory(categoryResponse);

            productDetail.setColor(color);
            productDetail.setImage(image);
            productDetail.setProduct(product);
            productDetail.setCard(card);
            productDetail.setOs(os);
            productDetail.setRom(rom);
            productDetail.setRam(ram);
            productDetail.setId(productDetailEntities.getId());
            productDetail.setDescription(productDetailEntities.getDescription());
            productDetail.setPrice(productDetailEntities.getPrice());
            productDetail.setCamera(productDetailEntities.getCamera());
            productDetail.setCameraSelf(productDetailEntities.getCameraSelf());
            productDetail.setBattery(productDetailEntities.getBattery());
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

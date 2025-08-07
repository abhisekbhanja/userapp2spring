package com.example.userprofile.mapper;

import com.example.userprofile.dto.ProductDTO;
import com.example.userprofile.model.Category;
import com.example.userprofile.model.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-08T00:41:44+0530",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.40.0.v20241112-0530, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setCategoryName( productCategoryCategoryName( product ) );
        productDTO.setName( product.getName() );
        productDTO.setDescription( product.getDescription() );
        if ( product.getPrice() != null ) {
            productDTO.setPrice( product.getPrice().doubleValue() );
        }
        productDTO.setQuantity( product.getQuantity() );

        return productDTO;
    }

    @Override
    public Product toEntity(ProductDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setCategory( productDTOToCategory( dto ) );
        product.setName( dto.getName() );
        product.setDescription( dto.getDescription() );
        product.setPrice( BigDecimal.valueOf( dto.getPrice() ) );
        product.setQuantity( dto.getQuantity() );

        return product;
    }

    @Override
    public List<ProductDTO> toDtoList(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>( products.size() );
        for ( Product product : products ) {
            list.add( toDto( product ) );
        }

        return list;
    }

    private String productCategoryCategoryName(Product product) {
        if ( product == null ) {
            return null;
        }
        Category category = product.getCategory();
        if ( category == null ) {
            return null;
        }
        String categoryName = category.getCategoryName();
        if ( categoryName == null ) {
            return null;
        }
        return categoryName;
    }

    protected Category productDTOToCategory(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setCategoryName( productDTO.getCategoryName() );

        return category;
    }
}

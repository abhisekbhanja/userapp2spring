package com.example.userprofile.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.userprofile.dto.ProductDTO;
import com.example.userprofile.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "category.categoryName", target = "categoryName")
    ProductDTO toDto(Product product);
    
    @Mapping(source = "categoryName", target = "category.categoryName")
    Product toEntity(ProductDTO dto);



    List<ProductDTO> toDtoList(List<Product> products);
}

package com.productexseption.model.product;

import com.productexseption.model.user.User;
import com.productexseption.model.user.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductPayload payload);
    UserResponse toDtoList(User user);
}

package br.com.redesenhe.leap.adapter.in.mapper;

import br.com.redesenhe.leap.adapter.in.dto.CreateUserRequest;
import br.com.redesenhe.leap.adapter.in.dto.UserAcessResponse;
import br.com.redesenhe.leap.adapter.out.repository.entity.UserEntity;
import br.com.redesenhe.leap.application.core.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.Date;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "request.name")
    @Mapping(target = "email", source = "request.email")
    @Mapping(target = "password", source = "request.password")
    User toUser(CreateUserRequest request);

    UserAcessResponse toUserAcessResponse(User user, String token, Date expiration);


}

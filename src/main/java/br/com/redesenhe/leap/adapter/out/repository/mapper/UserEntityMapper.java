package br.com.redesenhe.leap.adapter.out.repository.mapper;
import br.com.redesenhe.leap.adapter.out.repository.entity.UserEntity;
import br.com.redesenhe.leap.application.core.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserEntityMapper {

//    @Mapping(target = "id", source = "user.id")
//    @Mapping(target = "name", source = "user.name")
//    @Mapping(target = "email", source = "user.email")
//    @Mapping(target = "password", source = "user.password")
//    @Mapping(target = "createAt", ignore = true)
//    @Mapping(target = "updateAt", ignore = true)
    UserEntity toUserEntity(User user);

    User toUser(UserEntity entity);
}

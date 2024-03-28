package br.com.redesenhe.leap.adapter.out.repository.mapper;

import br.com.redesenhe.leap.adapter.out.repository.entity.BookEntity;
import br.com.redesenhe.leap.adapter.out.repository.entity.UserEntity;
import br.com.redesenhe.leap.application.core.domain.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookEntityMapper {

    @Mapping(target = "createAt", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    @Mapping(target = "user.id", source = "book.user.id")
    BookEntity toBookEntity(Book book);

    Book toBook(BookEntity entity);
}

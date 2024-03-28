package br.com.redesenhe.leap.adapter.in.mapper;


import br.com.redesenhe.leap.adapter.in.dto.BookResponse;
import br.com.redesenhe.leap.adapter.in.dto.CreateBookRequest;
import br.com.redesenhe.leap.adapter.out.repository.entity.BookEntity;
import br.com.redesenhe.leap.application.core.domain.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pages", ignore = true)
    @Mapping(target = "finish", ignore = true)
    @Mapping(target = "year", ignore = true)
    @Mapping(target = "desire", ignore = true)
    @Mapping(target = "imageLink", ignore = true)
    @Mapping(target = "readNotes", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "name", source = "request.name")
    @Mapping(target = "author", source = "request.author")
    Book toBook(CreateBookRequest request);

    BookResponse toBookResponse(Book book);
}

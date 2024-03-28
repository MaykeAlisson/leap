package br.com.redesenhe.leap.adapter.out;

import br.com.redesenhe.leap.adapter.out.client.GoogleBookClient;
import br.com.redesenhe.leap.adapter.out.client.model.GoogleBook;
import br.com.redesenhe.leap.adapter.out.repository.BookRepository;
import br.com.redesenhe.leap.adapter.out.repository.entity.UserEntity;
import br.com.redesenhe.leap.adapter.out.repository.mapper.BookEntityMapper;
import br.com.redesenhe.leap.adapter.out.repository.mapper.UserEntityMapper;
import br.com.redesenhe.leap.application.core.domain.exception.BusinessExceptionHandler;
import br.com.redesenhe.leap.application.core.domain.model.Book;
import br.com.redesenhe.leap.application.core.domain.model.User;
import br.com.redesenhe.leap.application.ports.out.InsertBookOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static br.com.redesenhe.leap.adapter.security.User.getUserContext;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static java.util.Objects.requireNonNullElse;

@Component
public class InsertBookAdapter implements InsertBookOutputPort {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookEntityMapper mapper;

    @Autowired
    private UserEntityMapper userMapper;

    @Autowired
    private GoogleBookClient googleBookClient;

    @Override
    public Book execute(Book book) {
        var idUserRequest = requireNonNull(getUserContext()).getUserId();
        var queryString = format("%s+inauthor:%s", book.getName(), book.getAuthor());

        GoogleBook googleBook = this.googleBookClient.findByName(queryString);
        if (Objects.isNull(googleBook.getItems()))
            throw new BusinessExceptionHandler(
                    format("Livro com o nome %s e author %s não encontrado.", book.getName(), book.getAuthor()));

        var item = googleBook.getItems().stream().findFirst()
                .orElseThrow(() ->
                        new BusinessExceptionHandler(
                                format("Livro com o nome %s e author %s não encontrado.", book.getName(), book.getAuthor())));

        var author = item.volumeInfo().authors().stream().map(String::valueOf)
                .collect(Collectors.joining(" /"));

        var imageLink = Objects.isNull(item.volumeInfo().imageLinks())
                ? ""
                : item.volumeInfo().imageLinks().smallThumbnail();
        var pages = requireNonNullElse(item.volumeInfo().pageCount(), 0);

        book.setName(item.volumeInfo().title());
        book.setAuthor(author);
        book.setImageLink(imageLink);
        book.setPages(pages);
        book.setUser(new User(idUserRequest, null, null, null));

        this.bookRepository.findByNameAndAuthorAndUserId(book.getName(), book.getAuthor(), idUserRequest)
                .ifPresent(
                        entity -> {
                            throw new BusinessExceptionHandler(
                                    format("Livro com o nome %s e author %s já cadatrado", book.getName(), book.getAuthor()));
                        }
                );

        var created = this.bookRepository.save(this.mapper.toBookEntity(book));

        return mapper.toBook(created);
    }
}

package br.com.redesenhe.leap.adapter.out.repository;

import br.com.redesenhe.leap.adapter.out.repository.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {

    Optional<BookEntity> findByNameAndAuthorAndUserId(String name, String author, Integer userId);
}

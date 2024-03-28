package br.com.redesenhe.leap.adapter.out.repository;

import br.com.redesenhe.leap.adapter.out.repository.entity.BookNoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookNoteRepository extends JpaRepository<BookNoteEntity, Integer> {
}

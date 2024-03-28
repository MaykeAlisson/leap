package br.com.redesenhe.leap.application.ports.out;

import br.com.redesenhe.leap.application.core.domain.model.Book;

public interface InsertBookOutputPort {

    Book execute(Book goal);
}

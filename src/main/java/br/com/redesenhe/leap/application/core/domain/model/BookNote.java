package br.com.redesenhe.leap.application.core.domain.model;

import java.io.Serializable;

public class BookNote implements Serializable {

    public BookNote(Integer id, String note, Book book) {
        this.id = id;
        this.note = note;
        this.book = book;
    }

    private Integer id;
    private String note;
    private Book book;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}

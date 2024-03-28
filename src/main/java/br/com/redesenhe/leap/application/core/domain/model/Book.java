package br.com.redesenhe.leap.application.core.domain.model;

import java.io.Serializable;
import java.time.Year;
import java.util.List;

public class Book implements Serializable {

    public Book(Integer id, String name, String author, Integer pages, Boolean finish, Year year, Boolean desire, String imageLink, List<BookNote> readNotes, User user) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.finish = finish;
        this.year = year;
        this.desire = desire;
        this.imageLink = imageLink;
        this.readNotes = readNotes;
        this.user = user;
    }

    private Integer id;
    private String name;
    private String author;
    private Integer pages;
    private Boolean finish;
    private Year year;
    private Boolean desire;
    private String imageLink;
    private List<BookNote> readNotes;
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Boolean getFinish() {
        return finish;
    }

    public void setFinish(Boolean finish) {
        this.finish = finish;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Boolean getDesire() {
        return desire;
    }

    public void setDesire(Boolean desire) {
        this.desire = desire;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public List<BookNote> getReadNotes() {
        return readNotes;
    }

    public void setReadNotes(List<BookNote> readNotes) {
        this.readNotes = readNotes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

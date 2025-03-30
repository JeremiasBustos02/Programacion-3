package ProgramacionIII.TP2_1_Arboles;

import java.util.ArrayList;

public class Book {
    private long id;
    private String title;
    private String author;
    private ArrayList<String> genres;
    private int year;
    private int examples;

    public Book(long id, String title, String author, int year, int examples) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genres = new ArrayList<String>();
        this.year = year;
        this.examples = examples;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(String genre) {
        this.genres.add(genre);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getExamples() {
        return examples;
    }

    public void setExamples(int examples) {
        this.examples = examples;
    }
}

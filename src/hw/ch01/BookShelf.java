package hw.ch01;

import java.util.Iterator;

public class BookShelf implements Iterable<Book> {
    private Book[] books;
    private int last = 0;

    public BookShelf(int maxsize) {
        this.books = new Book[maxsize];
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    public void appendBook(Book book) {
        this.books[last] = book;
        last++;
    }

    public int getLength() {
        return last;
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }

    //장르/연도 Iterator는 별도 클래스로 구현
    public Iterator<Book> iteratorByGenre(String genre) {
        return new BookShelfGenreIterator(this, genre);
    }

    public Iterator<Book> iteratorByYear() {
        return new BookShelfYearIterator(this);
    }
}

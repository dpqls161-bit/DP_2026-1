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

    //추가
    //장르/연도 Iterator는 별도 클래스로 구현

    //특정 장르의 책만 순회할 수 있는 Iterator 반환 메서드
    public Iterator<Book> iteratorByGenre(String genre) {
        return new BookShelfGenreIterator(this, genre); //this : 현재 Bookshelf 객체(책장)
    }

    //출판연도 기준으로 책을 꺼내는 Iterator를 반환하는 메서드
    public Iterator<Book> iteratorByYear() {
        return new BookShelfYearIterator(this);
    }
}

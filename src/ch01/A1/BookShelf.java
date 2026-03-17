package ch01.A1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookShelf implements Iterable<Book> {
    private List<Book> books; //Arraylist 사용한것. 부모타입으로 books
    //List 는 인터페이스.

    public BookShelf(int initialsize) {
        this.books = new ArrayList<>(initialsize);  //처음엔 초기값만 만들어지고 나중에 추가적으로 필요시 생성됨
    }   //다른 점 :: 배열과 달리 (크기 고정) 필요에 따라 크기가 자동으로 늘어남

    public Book getBookAt(int index) {
        return books.get(index);
    }

    public void appendBook(Book book) {
        books.add(book);
    }

    public int getLength() {
        return books.size();
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }
}

package practice.ch01;

import java.util.Iterator;

public class BookShelf implements Iterable<Book> {
//public class BookShelf{
    private Book[] books; //배열 선언만. 책을 배열로 관리
    private int last = 0; //책의 마지막 위치

    public BookShelf(int maxsize) {
        this.books = new Book[maxsize]; //배열 생성. 책 배열  maxsize로 최대 크기
    }

    public Book getBookAt(int index) { //책을 가져오는 메소드
        return books[index];
    }

    public void appendBook(Book book) { //책을 추가하는 메소드
        this.books[last] = book; //인자로 책 받아서 배열에 추가
        last++; //책 다음 위치 이동
    }

    public int getLength() { //현재 책의 개수 반환 메소드
        return last;
    }

    @Override
    public Iterator<Book> iterator() { //자기 자신(현재 책꽂이의) Iterator를 생성해서 반환하는 메소드
        return new BookShelfIterator(this); //this : 현재 객체(책꽂이)를 가리킴
    }
}

//컨트롤 / 하면 드래그한 부분 다 주석처리

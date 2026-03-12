package practice.ch01;

import java.util.Iterator; //JDK가 제공하는 Iterator 인터페이스 사용
import java.util.NoSuchElementException;

public class BookShelfIterator implements Iterator<Book> { //generic이라 BOOK 타입으로 선언
    private BookShelf bookShelf; //북쉘프아이터레이터가 북쉘프를 가지고 있음 (마름모 관계)
    private int index; //책꽂이에서 현재 위치를 나타내는 변수

    public BookShelfIterator(BookShelf bookShelf) { //생성자. 책꽂이를 인자로 받아 bookshelf에 저장
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    //iterator는 hasNext()와 next() 메소드를 구현해야 함!!!
    @Override
    public boolean hasNext() { //책꽂이에서 꺼내올 다음 책이 있는지 확인하는 메소드 있으면 true 없으면 false 불린형
        if (index < bookShelf.getLength()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Book next() { //책꽂이에서 다음 책을 꺼내오는 메소드/ 리턴 타입 Book 
        if (!hasNext()) { //hasNext가 False= 없으면
            throw new NoSuchElementException(); //throw는 예외 발생시키는 키워드 // NosuchElementException은 더 이상 꺼내올 책이 없을 때 발생하는 예외 클래스
        }
        Book book = bookShelf.getBookAt(index); //책꽂이에서 현재 위치의 책을 가져옴
        index++;
        return book;
    }
}

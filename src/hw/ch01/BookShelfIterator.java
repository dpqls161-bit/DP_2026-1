package hw.ch01;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BookShelfIterator implements Iterator<Book> {
    private BookShelf bookShelf;
    private int index;
    
    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0; //Iterator의 시작 위치 초기화. 나중에 어디까지 읽었는지 기억하도록
    }


    //방법 1 이용할 땐 아래 두 오버라이드 안 써도 됨
    //부모가 가지고 있는 메소드를 자식이 재정의(오버라이드)한다. @ >> 컴파일러 지시어라고 함
    @Override
    public boolean hasNext() {
        if (index < bookShelf.getLength()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}

//장르 Iterator 생성자에서 장르 정보 받아서 저장해두고 hasNext()에서 해당 장르의 책이 남아있는지 확인,
//  next()에서 해당 장르의 책을 반환하도록 구현
class BookShelfGenreIterator implements Iterator<Book> {
    private BookShelf bookShelf;
    private String genre;
    private int index;

    public BookShelfGenreIterator(BookShelf bookShelf, String genre) {
        this.bookShelf = bookShelf;
        this.genre = genre;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        for (int i = index; i < bookShelf.getLength(); i++) {
            if (bookShelf.getBookAt(i).getGenre().equals(genre)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Book next() {
        while (index < bookShelf.getLength()) {
            Book book = bookShelf.getBookAt(index);
            index++;
            if (book.getGenre().equals(genre)) {
                return book;
            }
        }
        throw new NoSuchElementException();
    }
}

//연도 Iterator 생성자에서 책장에 있는 책들을 연도 순으로 정렬해서 저장해두고 
// hasNext()에서 남아있는 책이 있는지 확인,
class BookShelfYearIterator implements Iterator<Book> {
    private Book[] sortedBooks;
    private int index;

    public BookShelfYearIterator(BookShelf bookShelf) {
        sortedBooks = new Book[bookShelf.getLength()];

        for (int i = 0; i < bookShelf.getLength(); i++) {
            sortedBooks[i] = bookShelf.getBookAt(i);
        }

        for (int i = 0; i < sortedBooks.length - 1; i++) {
            for (int j = i + 1; j < sortedBooks.length; j++) {
                if (sortedBooks[i].getYear() < sortedBooks[j].getYear()) {
                    Book temp = sortedBooks[i];
                    sortedBooks[i] = sortedBooks[j];
                    sortedBooks[j] = temp;
                }
            }
        }

        index = 0;
    }

    @Override
    public boolean hasNext() {
        if (index < sortedBooks.length) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Book book = sortedBooks[index];
        index++;
        return book;
    }
}

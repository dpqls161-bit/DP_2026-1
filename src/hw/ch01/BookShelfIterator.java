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
    private BookShelf bookShelf; //책장 정보 저장
    private String genre;  //필터링할 장르 정보 저장
    private int index;      //현재 위치를 나타내는 인덱스. hasNext()와 next()에서 어디까지 읽었는지 기억하도록

    public BookShelfGenreIterator(BookShelf bookShelf, String genre) {
        this.bookShelf = bookShelf;
        this.genre = genre;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        for (int i = index; i < bookShelf.getLength(); i++) {
            //현재 위치부터 책장 끝까지 탐색하면서 해당 장르의 책이 있는지 확인
            if (bookShelf.getBookAt(i).getGenre().equals(genre)) { //해당 장르의 책이 있으면 true 반환
            //GetGenre()는 현재 책 장르 가져옴.  genre는 생성자에서 저장해둔 값, equals로 인자 genre값이 소설이면  true
                return true;
            }
        }
        return false;
    }

    @Override
    public Book next() { //책 한 권을 꺼내서 반환하는 함수
        while (index < bookShelf.getLength()) {
            Book book = bookShelf.getBookAt(index); //현재 위치의 책 하나 꺼냄
            index++; //다음 책 위치로
            if (book.getGenre().equals(genre)) { //book.getGenre()인 현재 책 장르에서 생성자에게 받은값 genre와 같은지 비교해서 같으면 해당 책 반환
                return book; //조건 맞으면 (소설 책이면) 책 반환
            }
        }
        throw new NoSuchElementException(); //조건에 맞는 책 없다
    }
}

//연도 Iterator 생성자에서 책장에 있는 책들을 연도 순으로 정렬해서 저장해두고 
// hasNext()에서 남아있는 책이 있는지 확인,
class BookShelfYearIterator implements Iterator<Book> {
    private Book[] sortedBooks; //정렬해서 쓸 책 배열
    private int index; //현재 몇 번째 책을 보고 있는지 저장

    public BookShelfYearIterator(BookShelf bookShelf) {
        sortedBooks = new Book[bookShelf.getLength()]; //책장 크기만큼 배열 생성

        for (int i = 0; i < bookShelf.getLength(); i++) {
            sortedBooks[i] = bookShelf.getBookAt(i); //원래 책장의 책들을 새 배열인 sortedBooks에 복사
        }

        //정렬
        for (int i = 0; i < sortedBooks.length - 1; i++) { 
            for (int j = i + 1; j < sortedBooks.length; j++) {
                if (sortedBooks[i].getYear() < sortedBooks[j].getYear()) {
                    //앞 책과 뒤 책의 출판연도 비교해서 앞이 더 오래됐으면 서로 위치를 바꿈
                    Book temp = sortedBooks[i];
                    sortedBooks[i] = sortedBooks[j];
                    sortedBooks[j] = temp;
                }
            }
        }

        index = 0; //첫 번째 책부터 시작하도록 index 초기화
    }

    @Override
    public boolean hasNext() {
        if (index < sortedBooks.length) {
            return true; //아직 안 꺼낸 책 남아 있을 때
        } else {
            return false;
        }
    }

    @Override
    public Book next() {
        if (!hasNext()) {//꺼낼 책이 더 이상 없을 때 
            throw new NoSuchElementException(); //요소 없다
        }
        Book book = sortedBooks[index];//꺼낼 책을 book 변수에 저장
        index++;//꺼낼 책이 남아 있을 때 index를 다음으로 이동시킴
        return book; //꺼낸 책 반환
    }
}

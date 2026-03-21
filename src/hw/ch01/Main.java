package hw.ch01;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        System.out.println("학번 : 20240892, 이름 : 김예빈" );
        System.out.println();

        BookShelf bookShelf = new BookShelf(10); // 책장 크기를 설정하고 아래에 책을 추가
        bookShelf.appendBook(new Book("클린코드", "기술", 2008, 30000));
        bookShelf.appendBook(new Book("해리포터와 마법사의 돌", "소설", 1997, 15000));
        bookShelf.appendBook(new Book("사피엔스", "역사", 2011, 18000));
        bookShelf.appendBook(new Book("이펙티브 자바", "기술", 2018, 36000));
        bookShelf.appendBook(new Book("객체지향의 사실과 오해", "기술", 2015, 20000));
        bookShelf.appendBook(new Book("레미제라블", "소설", 1862, 12000));
        bookShelf.appendBook(new Book("총균쇠", "역사", 1997, 22000));
        bookShelf.appendBook(new Book("리팩터링", "기술", 2018, 34000));
        bookShelf.appendBook(new Book("로마인 이야기", "역사", 1992, 25000));
        bookShelf.appendBook(new Book("어린왕자", "소설", 1943, 9000));

        System.out.println("[소설 장르 책 목록]");
        Iterator<Book> genreIterator = bookShelf.iteratorByGenre("소설");
        //Iterator<Book> 타입의 변수 genreIterator를 선언하고 
        //bookShelf의 iteratorByGenre 메서드를 호출하여 "소설" 장르만 순회하는 Iterator 객체를 생성
        //bookShelf.iteratorByGenre("소설")를 호출하면, BookShelfGenreIterator 생성자가 호출됨
        //BookShelfGenreIterator로 이동

        while (genreIterator.hasNext()) {
        //이 while문의 조건은 다음에 꺼낼 소설 책이 남아 있는 동안 반복한다는 것
        //hasNext()는 다음 원소가 있는지 조사하는 메서드
            Book book = genreIterator.next();
            //조건에 맞는 다음 책 한권을 꺼내서 book 변수에 저장한다는 것
            //next()는 책을 반환하고 위치를 다음으로 이동시킴.
            printBook(book);
            //꺼낸 책의 제목/장르/출판연도/가격 출력
        }
        System.out.println();

        System.out.println("[출판연도 역순 Iterator]");
        BookShelf novelShelf = new BookShelf(bookShelf.getLength());//새 책장 생성(원래 책장길이만큼) 소설만 담아둘 임시 책장
        Iterator<Book> novelIterator = bookShelf.iteratorByGenre("소설"); //원래 책장에서 소설만 꺼내는 Iterator 생성
        while (novelIterator.hasNext()) {
            novelShelf.appendBook(novelIterator.next());
        } //소설 책이 남아 있는 동안 1개씩 꺼내 nobelShelf에 추가

        //>>novelShelf에는 소설 책만 담겨 있음

        Iterator<Book> yearIterator = novelShelf.iteratorByYear();
        //이제 novelShelf에서 출판연도 역순으로 책을 꺼내는 Iterator 생성
        //iteratorByYear()는 단지 최신순 정렬 메서드이지만 novelshelf에는 소설만 있어서 소설만 최신순으로 꺼냄
        //최신순 꺼내는 문법은 BookShelfYearIterator에서
        while (yearIterator.hasNext()) { //출판연도 역순으로 꺼낼 책이 남아 있는 동안 반복
            Book book = yearIterator.next(); //다음 책을 꺼내서 book 변수에 저장
            printBook(book);//꺼낸 책 정보 출력
        }
    }

    public static void printBook(Book book) { //책 한 권을 받아서
        System.out.println(
            "제목: " + book.getName()
            + ", 장르: " + book.getGenre()
            + ", 출판연도: " + book.getYear()
            + ", 가격: " + (int) book.getPrice()
        );
    }
}

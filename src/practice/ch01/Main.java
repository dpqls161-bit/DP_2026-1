package practice.ch01;

import java.util.Iterator;

public class Main { //메인 클래스
    public static void main(String[] args) { //메인 메소드
        Book book = new Book("Java Programming"); //책 객체 생성, 책 이름은 "자바의 정석"
        System.out.println("Book name : " + book.getName()); //책 이름 출력
    
        //책장 테스트
        BookShelf bookShelf = new BookShelf(5); //책장 객체 생성, 최대 크기는 4
        bookShelf.appendBook(new Book("Java Programming")); //책장에 책 추가
        bookShelf.appendBook(new Book( "Design Patterns")); //책장에 책 추가
        bookShelf.appendBook(new Book( "Effective Java")); //책장에 책 추가

        //책장에 있는 책 출력

        //방법1 : 클라이언트가 책꽂이에 직접 접근하여 책을 가져오는 방법
        for (int i= 0; i < bookShelf.getLength(); i++) { //책장에 있는 책의 개수만큼 반복
            System.out.println("Book " + (i+1) + ": " + bookShelf.getBookAt(i).getName()); //책 이름 출력
        }

        //방법2 : Iterator를 통해서 책꽂이에 책을 꺼내오는 방법
        //iterator를 얻어옴
        Iterator<Book> it = bookShelf.iterator(); //책꽂이에서 iterator를 얻어옴
        while(it.hasNext()) { //iterator에 다음 책이 있는 동안 반복
            System.out.println("Book: " + it.next().getName()); //책 이름 출력
        }

        //확장for문을 이용한 방법
        //이게 가능한 이유는 BookShelf가 Iterable 인터페이스를 구현했기 때문. Iterable 인터페이스는 iterator() 메소드를 가지고 있어서 확장 for문에서 사용할 수 있음
        for (Book b : bookShelf) { //형식 : for (요소타입 변수명 : 컬렉션) { //컬렉션에서 요소를 하나씩 꺼내와서 변수에 저장하고 반복
            System.out.println("Book: " + b.getName()); //책 이름 출력
        }
    }
}
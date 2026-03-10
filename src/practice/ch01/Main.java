package practice.ch01;

public class Main { //메인 클래스
    public static void main(String[] args) { //메인 메소드
        Book book = new Book(name : "Java Programming"); //책 객체 생성, 책 이름은 "자바의 정석"
        System.out.println("Book name : " +book.getName()); //책 이름 출력
    }
}
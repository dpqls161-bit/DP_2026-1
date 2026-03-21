package hw.ch01;

public class Book {
    private String name;
    private String genre;
    private int year;
    private double price;


    public Book(String name) {
        this.name = name;
        this.genre = "";
        this.year = 0;
        this.price = 0.0;
        /* 기존 Book(String name) 생성자를 유지하면서,
        새로 추가된 필드(genre, year, price)를 기본값으로 초기화
        이는 기존 코드와의 호환성을 유지하면서 객체의 일관된 상태를 보장하기 위함*/
    }

    public Book(String name, String genre, int year, double price) {
    /* 전체 정보를 입력받는 생성자. 책의 모든 정보를 한 번에 초기화*/
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    //아래로 추가한 필드들에 대한 getter 메서드 구현
    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

}

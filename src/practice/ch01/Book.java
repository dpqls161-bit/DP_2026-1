package practice.ch01; //경로대로 써 있어야 함. ch01.sample하면 안됨

public class Book { //책 클래스
    private String name;

    public Book(String name) { //책의 이름 받아서 넣음
        this.name = name; //this는 자기 자신을 가리킴. this.name은 멤버변수 name, name은 매개변수 name. 매개변수 이름이 멤버변수 이름과 같을 때 구분하기 위해 this를 붙임
    }

    public String getName() {
        return name; //책 이름 리턴됨
    }
}

package practice.ch02.inheritance;

public class Main {
    public static void main(String[] args) {
        Banner banner = new Banner("Hello, World!");
        banner.showWithParen();
        banner.showWithAster();
    
    //어댑터 이용하기
    System.out.println("===어댑터 이용하기===");
    Print print = new PrintBannerAdater01("Hello, World!"); 
    //Hello world를 받는 생성자가 존재해야함. 
    // 부모 Banner로 가면 public Banner(String string) 생성자 존재
    print.printWeak();
    print.printStrong();
    }

}

package practice.ch02.inheritance;

//클라이언트가 원하는 인터페이스. 필요로하는 인터페이스. = Target 인터페이스. 이건 어댑터 아님!
public interface Print {
    public abstract void printWeak();   //벤더클래스 말고 이 이름 사용하고 싶을때
    public abstract void printStrong(); 
    //showWithParen,showWithAster 말고 이 이름들(타겟 인터페이스) 사용하고 싶을 때
}

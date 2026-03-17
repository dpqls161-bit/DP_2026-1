package practice.ch02.inheritance;

// 클라이언트가 원하는 인터페이스를 구현한 어댑터 클래스. 어댑터는 클라이언트가 사용함.
public class PrintBannerAdater01 extends Banner implements Print { //이 Print에 클라이언트가 원하는게 구현돼있으니 제공해야함
//extends Banner 이거 적으면 PrintB~얘는 Banner의 메소드들을 상속받음.
//실제 일은 부모인 Banner가 함. 
    @Override
    public void printWeak() {
        showWithParen(); //얘는 메소드라서 항상 객체.메소드로 써야함. 
    }

    @Override
    public void printStrong() {
        showWithAster();
    } 
    
}

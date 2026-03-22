package practice.ch02.delegation;

//어댑터
// Print가 인터페이스가 아니라 추상클래스이므로 implements가 아니라 extends로 상속받아야함.
//public class PrintBannerAdapter02 extends Print, Banner { //상속 이용한 어댑터 패턴은  배너를 구현해야함
    //자바에서는 다중 상속이 불가능함.  (부모가 둘 이상은 허용 안 됨) 
    //따라서 이 코드는 틀린 것. Banner 상속 못 받음 >> 위임 이용해야함
   
}
public class PrintBannerAdapter02 extends Print { //상속 이용한 어댑터 패턴은  배너를 구현해야함
    //자바에서는 다중 상속이 불가능함.  (부모가 둘 이상은 허용 안 됨)
    private Banner banner;

    public PrintBannerAdapter02(String text) { //생성될 때 텍스트 받아서
        this.banner = new Banner(text); //배너 하나 만듦. 그러면 배너를 가지게 됨
    }

    @Override
    public void printWeak() {
        banner.showWithParen(); //배너. 으로 배너 메소드 대신 시킬 수 있음
        //위임 == 배너를 가지고 있다가 배너에게 일 시키기. 배너 상속받는게 아님.
    }

    @Override
    public void printStrong() {
        banner.showWithAster(); //배너 클래스의 메서드를 호출해서 기능 수행 = 위임
    }
}

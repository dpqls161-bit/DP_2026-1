package hw.ch02;

//어댑터
//Charger 인터페이스 구현, 위임
public class KoreanOutletAdapter implements Charger {
    private KoreanOutlet koreanOutlet; //어댑티를 속성으로 가짐

    public KoreanOutletAdapter(KoreanOutlet koreanOutlet) { //생성자를 통해 어댑티를 받음
        this.koreanOutlet = koreanOutlet;
    }

    //클라이언트가 호출하는 메소드 (target 인터페이스)
    @Override
    public int charge() {
        //실제 작업은 어댑티인 코리안아웃렛에게 위임 여기가 어댑터패턴 핵심
        return koreanOutlet.provide();
    }
}

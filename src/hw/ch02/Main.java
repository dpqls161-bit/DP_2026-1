package hw.ch02;
public class Main {
    public static void main(String[] args) {
        Charger charger = new KoreanOutletAdapter(new KoreanOutlet());
        //KoreanOutletAdapter 객체 생성, KoreanOutlet 객체를 생성자로 전달
        Smartphone smartphone = new Smartphone(charger);
        //SmartPhone 객체 생성, Charger 인터페이스를 구현한 KoreanOutletAdapter 객체를 생성자로 전달
        smartphone.charge();
        //Smartphone의 charge 메소드 호출, 내부적으로 KoreanOutletAdapter의 charge 메소드가 호출되고,
        //다시 KoreanOutlet의 provide 메소드가 호출되어 220V AC를 제공
    }
}
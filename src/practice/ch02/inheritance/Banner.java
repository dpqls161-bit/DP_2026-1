package practice.ch02.inheritance;

//이미 존재하는 클래스=Vendor 클래스. 강아지(멍멍() 제공). 수정 불가!!
public class Banner {   
    private String string;

    //생성자
    public Banner(String string) {
        this.string = string; 
    }

    public void showWithParen() {   //이런 api(인터페이스) 이름들이 마음에 안 들 때!! >> 어댑터
        System.out.println("(" + string + ")");
    }

    public void showWithAster() {   //showWithAster이런 함수이름 마음에 안 들 때 !! >> 어댑터
        System.out.println("*" + string + "*");
    }
}

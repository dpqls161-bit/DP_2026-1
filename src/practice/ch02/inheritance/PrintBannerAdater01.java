package practice.ch02.inheritance;
//@@@@@상속 이용한 Adapter 패턴@@@@@@

// 클라이언트가 원하는 인터페이스를 구현한 어댑터 클래스. 어댑터는 클라이언트가 사용함.
public class PrintBannerAdater01 extends Banner implements Print { //이 Print에 클라이언트가 원하는게 구현돼있으니 제공해야함
//extends Banner 이거 적으면 PrintB~얘는 Banner의 메소드들을 상속받음.
//실제 일은 부모인 Banner가 함. 

/*생성자 사용 법 !!!!!!!!!!!!
1) 인자 없는 생성자는 안 만들어도 자동으로 생성됨 -> 호출 가능
2) 생성자는 상속되지 않음!!!!!!
>>>>> PrintBannerAdater01 생성자를 생성해줘야함
*/

    public PrintBannerAdater01(String text) {
        super(text); //부모 클래스의 생성자 호출. 부모 클래스의 생성자에 string이 필요하니까 string을 넣어줌.
    } //super는 부모 클래스의 생성자 호출하는 키워드. 
    // Banner 생성자가 호출됨 . text값이 String string에 저장됨


//banner 클래스 상속받아서 자기 메소드처럼 사용할 수 있음
    @Override
    public void printWeak() {
        showWithParen(); //얘는 메소드라서 항상 객체.메소드로 써야함. 
        //this.이 생략된 것 (객체.)
    }

    @Override
    public void printStrong() {
        showWithAster();
    } 
    
}

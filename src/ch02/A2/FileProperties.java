package ch02.A2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

//어댑터
public class FileProperties implements FileIO { //타겟 인터페이스 (어댑터를 구현)
    Properties property = new Properties(); //어댑티를(properties) 속성으로 가짐. 나중에 일 시키려고
    //properties는 어댑티. property는 어댑티를 가리키는 참조변수. 어댑티를 가지고 있다가 일 시키는 방식이 위임. 상속이 아님.

    @Override
    public void readFromFile(String filename) throws IOException {
        property.load(new FileReader(filename));//어댑티에게 위임 
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        property.store(new FileWriter(filename), "written by FileProperties");
        //어댑티에게 위임
    }


    @Override
    public void setValue(String key, String value) {
        property.setProperty(key, value); //어댑티에게 위임
    }

    @Override
    public String getValue(String key) {
        return property.getProperty(key, ""); //어댑티에게 위임
    }
}

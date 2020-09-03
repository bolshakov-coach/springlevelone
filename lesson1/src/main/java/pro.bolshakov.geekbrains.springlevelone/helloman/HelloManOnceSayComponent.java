package pro.bolshakov.geekbrains.springlevelone.helloman;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("helloSayAnno")
public class HelloManOnceSayComponent implements HelloMan {
    @Value("VasiliyAnno")
    private String name;

    public HelloManOnceSayComponent() {
    }

    public HelloManOnceSayComponent(String name) {
        this.name = name;
    }

    @Override
    public void helloSay() {
        System.out.println("Hello, " + name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}

package pro.bolshakov.geekbrains.springlevelone;

import org.springframework.stereotype.Component;

@Component("coffee")
public class Coffee implements Drink {
    @Override
    public void testing() {
        System.out.println("trying coffee");
    }
}
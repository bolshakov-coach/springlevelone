package pro.bolshakov.geekbrains.springlevelone;

import org.springframework.stereotype.Component;

@Component("cupDrink")
public class Tea implements Drink {
    @Override
    public void testing() {
        System.out.println("trying tea");
    }
}

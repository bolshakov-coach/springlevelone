package pro.bolshakov.geekbrains.springlevelone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("cupComponent")
@Scope("prototype")
public class CupComponentImpl implements Cup {

    private Drink drink;
    @Value("false")
    private boolean broken;

    public void doDrink() {
        if (broken) {
            System.out.println("Cup is BROKEN!!!");
            return;
        }
        System.out.println("Hip - hip");
        drink.testing();
    }

    public Drink getDrink() {
        return drink;
    }

    @Autowired
    @Qualifier("coffee")
    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    @Override
    public void breaking() {
        this.broken = true;
    }

    @Override
    public boolean isBroken() {
        return broken;
    }
}

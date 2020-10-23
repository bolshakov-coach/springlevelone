package pro.bolshakov.geekbrains.springlevelone;

import pro.bolshakov.geekbrains.springlevelone.Cup;
import pro.bolshakov.geekbrains.springlevelone.Drink;

public class CupImpl implements Cup{
    private Drink drink;

    public CupImpl() {
    }

    public CupImpl(Drink drink) {
        this.drink = drink;
    }

    public void doDrink(){
        System.out.println("hlip - hlip");
        drink.testing();
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    @Override
    public void breaking() {

    }

    @Override
    public boolean isBroken() {
        return false;
    }
}

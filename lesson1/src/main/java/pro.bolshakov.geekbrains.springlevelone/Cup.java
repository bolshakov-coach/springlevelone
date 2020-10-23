package pro.bolshakov.geekbrains.springlevelone;

public interface Cup {
    void doDrink();
    Drink getDrink();
    void setDrink(Drink drink);
    void breaking();
    boolean isBroken();
}

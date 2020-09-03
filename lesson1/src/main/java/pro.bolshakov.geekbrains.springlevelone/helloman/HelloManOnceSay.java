package pro.bolshakov.geekbrains.springlevelone.helloman;

public class HelloManOnceSay implements HelloMan {
    private String name;

    public HelloManOnceSay() {
    }

    public HelloManOnceSay(String name) {
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

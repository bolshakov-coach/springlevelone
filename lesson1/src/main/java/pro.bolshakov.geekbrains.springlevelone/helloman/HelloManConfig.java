package pro.bolshakov.geekbrains.springlevelone.helloman;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("pro.bolshakov.geekbrains.springlevelone.helloman")
public class HelloManConfig {

    @Bean(name = "helloManJC")
    public HelloMan helloMan(@Value("VasiliyJavaConfig") String name){
        HelloManOnceSay helloMan = new HelloManOnceSay(name);
//        helloMan.setName(name);
        return helloMan;
    }
}

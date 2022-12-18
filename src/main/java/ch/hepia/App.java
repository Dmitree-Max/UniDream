package ch.hepia;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * DTO for Data Transrer Object
 * This is not a Domain Object, just a reprensentation of something transferable.
 * json-marshaller convert automatically to JSON. All getters will be translate 
 * to a JSON field
 * 
 * Don't use DTO for your business model
 */
class DtoToto {
    private final int i;
    private final String owner;
    public DtoToto(int i, String owner) {
        this.i = i;
        this.owner = owner;
    }
    public int getId(){ return this.i; }
    public String getOwner(){ return this.owner; }
    public List<String> getXs() { return List.of("Houhou", "Haha"); }
}

@SpringBootApplication
@RestController
public class App {

    @RequestMapping("/toto")
    public DtoToto greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new DtoToto(2, "Marcus Miller");
    }
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
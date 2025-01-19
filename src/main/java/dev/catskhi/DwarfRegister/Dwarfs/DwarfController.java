package dev.catskhi.DwarfRegister.Dwarfs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DwarfController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}

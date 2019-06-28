package io.williamwu.springdb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping(value = "/")
    public String index() {
        return "This is the landing page (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧";
    }
}

package io.williamwu.springdb.serviceschool.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {

    @GetMapping(value = "/")
    public String schoolDirect() {
        return "(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ Go visit school/teacher or school/subject!";
    }

}

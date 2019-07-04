package io.williamwu.springdb.web;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorHandleController implements ErrorController {

    @GetMapping(value = "/error")
    public String error() {
        return "Awww you messed up big time! (⋟﹏⋞)";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}

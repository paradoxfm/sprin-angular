package ru.megazlo.springtest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * iv - 04.09.2015
 */
@RestController
public class RestHomeController {

    @RequestMapping("/company/contacts")
    @ResponseBody
    public String getCompanyAddress() {
        return "";
    }
}

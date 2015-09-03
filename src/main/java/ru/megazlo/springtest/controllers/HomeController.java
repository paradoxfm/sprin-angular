package ru.megazlo.springtest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author paradoxfm - 02.09.2015
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/header")
    public String header() {
        return "header";
    }

    @RequestMapping("/contacts")
    public String contacts() {
        return "contacts";
    }

    @RequestMapping("/views/contactsView")
    public String contactsView() {
        return "home/contacts";
    }


}

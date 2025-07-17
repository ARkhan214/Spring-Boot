package com.emranhss.progect.restcontroller;


import com.emranhss.progect.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/division")
public class DivisionRestController {

    @Autowired
    private DivisionService divisionService;
}

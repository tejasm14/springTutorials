package com.demo.firstSpring.tutorial;

import org.springframework.stereotype.Service;

public class ProdDB implements DB {
    @Override
    public String getData() {
        return "Prod Data";
    }
}

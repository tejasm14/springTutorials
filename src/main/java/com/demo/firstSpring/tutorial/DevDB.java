package com.demo.firstSpring.tutorial;

import org.springframework.stereotype.Service;

public class DevDB implements DB {
    @Override
    public String getData() {
        return "DEV Data";
    }
}

package com.sudeepcv;

import org.springframework.stereotype.Service;

@Service("HomeAddress")
public class HomeAddress implements  Address{
    @Override
    public void printAddress() {
        System.out.println("home address");
    }
}

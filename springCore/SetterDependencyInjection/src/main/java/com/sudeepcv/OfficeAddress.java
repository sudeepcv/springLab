package com.sudeepcv;

import org.springframework.stereotype.Service;

@Service("OfficeAddress")
public class OfficeAddress implements Address {
    @Override
    public void printAddress() {
        System.out.println("Office Address");
    }
}

package com.sandbox.service;

import static java.lang.System.out;

public class BOMServiceImpl implements BOMService {
    public String action() {
        out.println("BOMService");
        return "service";
    }
}

package com.naya.personbd.services;

import com.naya.mainmethodstarter.Main;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */

public class MyService {
    @Main
    public void doWork(){
        System.out.println("WORKING.......");
    }
}

package com.dressup.demo.utils;

import org.springframework.stereotype.Component;

@Component
public class RandomImage {
    public String getImageURL(){
        return "https://picsum.photos/200/300";
    }
}

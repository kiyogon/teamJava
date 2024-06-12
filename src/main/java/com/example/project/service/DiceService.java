package com.example.project.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DiceService {
    private final Random random = new Random();

    public int roll() {
        return random.nextInt(6) + 1;
    }
}
// src/main/java/com/example/project/controller/DiceController.java

package com.example.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
public class DiceController {

    // @GetMapping("/dice")
    // public ModelAndView dicePage() {
    //    return new ModelAndView("dice");
    // }

    @GetMapping("/roll-dice")
    @ResponseBody
    public Map<String, Object> rollDice() {
        Random random = new Random();
        int playerRoll = random.nextInt(6) + 1;
        int opponentRoll = random.nextInt(6) + 1;

        String result;
        if (playerRoll > opponentRoll) {
            result = "あなたの勝ち!";
        } else if (playerRoll < opponentRoll) {
            result = "あなたの負け!";
        } else {
            result = "引き分け!";
        }

        Map<String, Object> response = new HashMap<>();
        response.put("playerRoll", playerRoll);
        response.put("opponentRoll", opponentRoll);
        response.put("result", result);

        return response;
    }
}
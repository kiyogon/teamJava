package com.example.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer diceRoll;
    private String policy;
    private String diceResult; // このフィールドを追加

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDiceRoll() {
        return diceRoll;
    }

    public void setDiceRoll(Integer diceRoll) {
        this.diceRoll = diceRoll;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getDiceResult() {
        return diceResult;
    }

    public void setDiceResult(String diceResult) {
        this.diceResult = diceResult;
    }
}
package com.example.project.controller;

import com.example.project.model.Memo;
import com.example.project.repository.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/memos")
public class MemoController {

    @Autowired
    private MemoRepository memoRepository;

    @GetMapping
    public String listMemos(Model model) {
        model.addAttribute("memos", memoRepository.findAll());
        return "memoList";
    }

    @GetMapping("/new")
    public String newMemo(Model model) {
        model.addAttribute("memo", new Memo());
        return "memoForm";
    }

    @PostMapping
    public String saveMemo(@ModelAttribute Memo memo) {
        memoRepository.save(memo);
        return "redirect:/memos";
    }

    @GetMapping("/edit/{id}")
    public String editMemo(@PathVariable Long id, Model model) {
        Memo memo = memoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid memo Id:" + id));
        model.addAttribute("memo", memo);
        return "memoForm";
    }

    @PostMapping("/delete/{id}")
    public String deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return "redirect:/memos";
    }

    @PostMapping("/{id}")
    public String updateMemo(@PathVariable Long id, @ModelAttribute Memo memo) {
        memo.setId(id);
        memoRepository.save(memo);
        return "redirect:/memos";
    }
}
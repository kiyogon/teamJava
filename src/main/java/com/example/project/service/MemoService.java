package com.example.project.service;

import com.example.project.model.Memo;
import com.example.project.repository.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemoService {

    @Autowired
    private MemoRepository memoRepository;

    public List<Memo> getAllMemos() {
        return memoRepository.findAll();
    }

    public Optional<Memo> getMemoById(Long id) {
        return memoRepository.findById(id);
    }

    public Memo saveMemo(Memo memo) {
        return memoRepository.save(memo);
    }

    public void deleteMemo(Long id) {
        memoRepository.deleteById(id);
    }

    public Memo updateMemo(Long id, Memo memoDetails) {
        Memo memo = memoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid memo Id:" + id));

        memo.setDescription(memoDetails.getDescription());
        memo.setDiceRoll(memoDetails.getDiceRoll());
        memo.setPolicy(memoDetails.getPolicy());
        memo.setDiceResult(memoDetails.getDiceResult()); // 修正部分

        return memoRepository.save(memo);
    }
}
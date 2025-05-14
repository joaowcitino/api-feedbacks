package com.example.feedback.service;

import com.example.feedback.exception.ResourceNotFoundException;
import com.example.feedback.model.Feedback;
import com.example.feedback.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    private final FeedbackRepository repo;

    public FeedbackService(FeedbackRepository repo) {
        this.repo = repo;
    }

    public Feedback create(Feedback f) {
        return repo.save(f);
    }

    public List<Feedback> findAll() {
        return repo.findAll();
    }

    public void deleteById(String id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Feedback não encontrado com id: " + id);
        }
        repo.deleteById(id);
    }
}
package com.insper.cursos.service;

import com.insper.cursos.exception.ResourceNotFoundException;
import com.insper.cursos.model.Feedback;
import com.insper.cursos.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    private final FeedbackRepository repo;

    public FeedbackService(FeedbackRepository repo) {
        this.repo = repo;
    }

    public Feedback criar(Feedback feedback) {
        return repo.save(feedback);
    }

    public List<Feedback> listar() {
        return repo.findAll();
    }

    public void excluir(String id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Feedback não encontrado: " + id);
        }
        repo.deleteById(id);
    }
}
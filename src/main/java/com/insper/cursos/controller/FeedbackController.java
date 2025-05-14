package com.insper.cursos.controller;

import com.insper.cursos.dto.FeedbackRequest;
import com.insper.cursos.dto.FeedbackResponse;
import com.insper.cursos.model.Feedback;
import com.insper.cursos.service.FeedbackService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    private final FeedbackService service;

    public FeedbackController(FeedbackService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FeedbackResponse criar(
            @AuthenticationPrincipal Jwt jwt,
            @Valid @RequestBody FeedbackRequest req
    ) {
        String email = jwt.getClaim("https://musica-insper.com/email");
        Feedback entity = req.toEntity();
        entity.setEmailCriador(email);

        Feedback saved = service.criar(entity);
        return FeedbackResponse.from(saved);
    }

    @GetMapping
    public List<FeedbackResponse> listar() {
        return service.listar().stream()
                .map(FeedbackResponse::from)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public void excluir(@PathVariable String id) {
        service.excluir(id);
    }
}

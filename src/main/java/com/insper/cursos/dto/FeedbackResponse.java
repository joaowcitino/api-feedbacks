// src/main/java/com/insper/feedbacks/dto/FeedbackResponse.java
package com.insper.cursos.dto;

import com.insper.cursos.model.Feedback;

public class FeedbackResponse {

    private String id;
    private String titulo;
    private String descricao;
    private Integer nota;
    private String emailCriador;

    public FeedbackResponse(String id,
                            String titulo,
                            String descricao,
                            Integer nota,
                            String emailCriador) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.nota = nota;
        this.emailCriador = emailCriador;
    }

    public static FeedbackResponse from(Feedback f) {
        return new FeedbackResponse(
            f.getId(),
            f.getTitulo(),
            f.getDescricao(),
            f.getNota(),
            f.getEmailCriador()
        );
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getNota() {
        return nota;
    }

    public String getEmailCriador() {
        return emailCriador;
    }
}
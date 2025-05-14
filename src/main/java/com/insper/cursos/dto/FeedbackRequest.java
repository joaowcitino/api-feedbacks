// src/main/java/com/insper/feedbacks/dto/FeedbackRequest.java
package com.insper.cursos.dto;

import com.insper.cursos.model.Feedback;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FeedbackRequest {

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    @NotNull
    @Min(0)
    @Max(10)
    private Integer nota;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    /**
     * Converte este DTO em entidade Feedback. 
     * O campo emailCriador deve ser preenchido no controller.
     */
    public Feedback toEntity() {
        Feedback f = new Feedback();
        f.setTitulo(this.titulo);
        f.setDescricao(this.descricao);
        f.setNota(this.nota);
        return f;
    }
}

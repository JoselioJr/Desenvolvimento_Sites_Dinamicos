package com.cursos.controller;

import com.cursos.model.Aluno;
import com.cursos.model.Curso;
import com.cursos.service.AlunoCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlunoCursoController {

    @Autowired
    private AlunoCursoService service;

    @PostMapping("/cursos")
    public Curso criarCurso(@RequestParam String nome) {
        return service.criarCurso(nome);
    }

    @PostMapping("/alunos")
    public Aluno criarAluno(@RequestParam String nome, @RequestParam Long cursoId) {
        return service.criarAluno(nome, cursoId);
    }

    @GetMapping("/alunos")
    public List<Aluno> listarAlunos() {
        return service.listarAlunos();
    }

    @GetMapping("/cursos")
    public List<Curso> listarCursos() {
        return service.listarCursos();
    }
}

package com.cursos.service;

import com.cursos.model.Aluno;
import com.cursos.model.Curso;
import com.cursos.repository.AlunoRepository;
import com.cursos.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoCursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    public Curso criarCurso(String nome) {
        Curso curso = new Curso();
        curso.setNome(nome);
        return cursoRepository.save(curso);
    }

    public Aluno criarAluno(String nome, Long cursoId) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setCurso(curso);
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }
}

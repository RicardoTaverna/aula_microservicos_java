package com.example.servico11;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluno")
public class AlunoResource {

    @GetMapping("/consulta/{id}")
    public Aluno consulta(@PathVariable("id") int id){
        Aluno a = new Aluno(id, "Ricardo", "1234");
        return a;
    }

    @PostMapping()
    public Aluno incluir(@RequestBody Aluno aluno){
        return aluno;
    }




}

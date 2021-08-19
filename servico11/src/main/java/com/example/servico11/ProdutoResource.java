package com.example.servico11;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/produto")
public class ProdutoResource {

    @GetMapping("/consulta/{id}")
    public Produto consulta(@PathVariable("id") int id) {
        Produto produto = new Produto(id, "ssd", 299.90);
        return produto;
    }

    @GetMapping("/consulta")
    public ArrayList<Produto> consulta_todos(){
        ArrayList<Produto> produtos = new ArrayList();
        Produto produto1 = new Produto(1, "ssd", 299.90);
        Produto produto2 = new Produto(2, "hd", 199.90);
        produtos.add(produto1);
        produtos.add(produto2);

        return produtos;
    }

    @PostMapping()
    public Produto incluir(@RequestBody Produto produto){
        return produto;
    }

    @PutMapping("/atualizar/{id}")
    public Produto atualizar(@PathVariable("id") int id, @RequestBody Produto produto){
        Produto produto_atualizado = produto;
        produto_atualizado.setId(id);

        String nome;
        Double preco;

        if (produto.getNome().equals("")){
            nome = produto_atualizado.getNome();
        } else {
            nome = produto.getNome();
        }
        produto_atualizado.setNome(nome);

        if (produto.getPreco() == null){
            preco = produto_atualizado.getPreco();
        } else {
            preco = produto.getPreco();
        }
        produto_atualizado.setNome(nome);


        return produto_atualizado;
    }

    @DeleteMapping("/deletar/{id}")
    public String deletar(@PathVariable("id")  int id){
        return "Produto " + id + " deletado";
    }


}

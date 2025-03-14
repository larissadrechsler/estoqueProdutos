/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.exemplothymeleaf.controller;

import com.senac.exemplothymeleaf.model.Produto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author laris
 */
@Controller
    public class ProdutoController {

        private List<Produto> produtos = new ArrayList();

        @GetMapping("/exibir-produto")
            public String exibirTarefa(Model model) {
                // Definindo o valor da variável "nome" 
                String nome = "Lucas";
                // Criando uma nova instância da classe "Produto" com os valores especificados 
                Produto produto = new Produto(1, "Camiseta Oversized", "P", 5, 25.5);
                // Adicionando a variável "nome" ao modelo para ser usada na visualização (view) 
                model.addAttribute("nome", nome);
                // Adicionando o objeto "produto" ao modelo para ser usado na visualização (view) 
                model.addAttribute("produto", produto);
                // Retornando o nome da visualização (view) que será renderizada 
                return "exibir-produto";
            }
            
        @GetMapping("/lista-produtos") 
            public String listaTarefas(Model model) { 
                // Criação de objetos Produto e adição à coleção produtos 
                produtos.add(new Produto(1, "Camiseta Oversized", "M", 15, 25.5));
                produtos.add(new Produto(1, "Camiseta Oversized", "G", 8, 25.5));
                produtos.add(new Produto(1, "Camiseta Oversized", "GG", 12, 25.5));
                // Adição da coleção tarefas ao modelo 
                model.addAttribute("produtos", produtos); 
                // Retorna o nome da página que será renderizada 
                return "lista-produtos"; 
            }
            
        @GetMapping("/cadastro") 
            public String exibirFormulario(Model model) { 
                // Cria uma nova instância da classe Produto e a adiciona ao modelo 
                model.addAttribute("produto", new Produto()); 
                // Retorna o nome do template "cadastro" para exibir o formulário 
                return "cadastro"; 
        } 
        @PostMapping("/cadastro") 
            public String processarFormulario(@ModelAttribute Produto produto, Model model) { 
                // Define a propriedade "completa" da tarefa como "false" 
                // Adiciona o produto à lista de produtos (supondo que "produtos" seja uma lista já existente) 
                produtos.add(produto); 
                // Adiciona o produto ao modelo para ser exibida no template "exibir-produto" 
                model.addAttribute("produto", produto); 
                // Retorna o nome do template "exibir-tarefa" para exibir os detalhes do produto 
                return "exibir-produto"; 
            }
    }

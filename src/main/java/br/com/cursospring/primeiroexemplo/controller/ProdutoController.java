package br.com.cursospring.primeiroexemplo.controller;

import br.com.cursospring.primeiroexemplo.model.Produto;
import br.com.cursospring.primeiroexemplo.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * toda vez que eu incluo a anotação @RestController eu estou
 * dizendo para o Spring que ele é o Controlador
 * eu vou incluir a rota que ele estiver ouvindo
 * @RequestMapping("/api/produtos") / api porque quero que essa api restiful
 * funcione como uma api, ou seja dizer que está dentro de um
 * controller de api.
 * /produto por que estou dentro do controller referente a produtos
 * eu posso alterar, deletar...
 */
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;
    /**
     * quando alguém fizer qualquer consulta chame o método obterTodos
     * eu uso a anotattion GetMapping
     * eu estou dizendo o seguinte, quando alguém fizer uma consulta
     * para /produto eu quero que chame obterTodos
     * */
    @GetMapping//esse método é uma consulta
    public List<Produto> obterTodos(){
        return  produtoService.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Produto> obterPorId(@PathVariable Integer id){//path:caminho variable é de variavel ele sabe que isso "/{id}" é uma variavel que está no caminho, ele tenta transformar em uma variavel, ou seja ele te devolve um inteiro
        return produtoService.obterPorId(id);
    }

//Para dizer que é um método para adicionar no verbo http é POST
    @PostMapping
    public Produto adicionar(@RequestBody Produto produto){//request body ele pega os dados do Json e converte em um produto
        return produtoService.adicionar(produto);
    }
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id){//transforme essa id num inteiro e faça exatamente
            produtoService.deletar(id);
            return "Produto com id:" + id + "foi deletado com sucesso!";
        }
        @PutMapping("/{id}")
        public Produto atualizar(@RequestBody Produto produto, @PathVariable Integer id){
        //@RequestBody Produto produto recebo o corpo e estou convertendo em produto
            //e estou recebendo o id na url @PathVariable Integer id e estou convertendo numa id inteiro
            return produtoService.atualizar(id, produto);
        }
}

package br.com.cursospring.primeiroexemplo.services;


import br.com.cursospring.primeiroexemplo.model.Produto;
import br.com.cursospring.primeiroexemplo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
/*
 *Quando usamos @service estamos dizendo para o spring que isso é uma classe de serviço
 *e estamos injentando essa dependencia pra dentro do spring e quando
 * eu precisar o spring devolve através da inversão de controle
 * o produto service vai depender do repositorio service
 */
public class ProdutoService {
    /**Autowired significa que você está invertendo o controle
     * */
    @Autowired
    private ProdutoRepository produtoRepository;//aqui ele devolve uma instancia pronta

    /**
     * Metodo para retornar uma lista de Produtos
     * @return Lista de Produtos.
     * */
    public List<Produto> obterTodos(){

        return produtoRepository.obterTodos();
    }

    /**
     *Metodo que retorna o produto encontrada pelo o seu Id
     * @param id  do produto que será localizado
     * @return  retorna um produto caso tenha encontrado
     *
     */

    public Optional<Produto> obterPorId(Integer id){

        return  produtoRepository.obterPorId(id);
    }

    /**
     * Metodo para adicionar produto na lista
     * @param produto que sera adicionado
     * @return  retorna o produto que foi adicionado na lista
     */
    public Produto adicionar(Produto produto){

        // Poderia ter alguma regra de negócio para validar o produto
        return produtoRepository.adicionar(produto);
    }

    /**
     * Metodo para deletar o produto por id.
     * @param id do produto a ser deletado
     */
    public void deletar(Integer id){
    //aqui poderia ter alguma lógica de validação

        produtoRepository.deletar(id);
    }

    /**
     * Metodo para atualizar o produto na lista
     * @param produto que será atualizado
     * @param id do produto
     * @return retorna o produto após atualizar a lista
     */


    public Produto atualizar(Integer id, Produto produto){
    //poderia ter alguma validação
        produto.setId(id);

        return  produtoRepository.atualizar(produto);

    }








}

package br.com.zup.controller;

import br.com.zup.dto.input.EntradaCategoriaDTO;
import br.com.zup.dto.input.EntradaProdutoDTO;
import br.com.zup.dto.output.SaidaCategoriaDTO;
import br.com.zup.dto.output.SaidaProdutoDTO;
import br.com.zup.model.Categoria;
import br.com.zup.model.Produto;
import br.com.zup.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("produtos/")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SaidaProdutoDTO salvar(@RequestBody @Valid EntradaProdutoDTO entradaProdutoDTO){
        Produto produto = produtoService.cadastrarProdutoNovo(entradaProdutoDTO.converterDTOParaModel());
        return SaidaProdutoDTO.converterDTOParaModel(produto);
    }
}

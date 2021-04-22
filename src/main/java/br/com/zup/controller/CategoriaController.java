package br.com.zup.controller;

import br.com.zup.configuration.mapper.CategoriaMapper;
import br.com.zup.dto.input.EntradaCategoriaDTO;
import br.com.zup.dto.output.SaidaCategoriaDTO;
import br.com.zup.model.Categoria;
import br.com.zup.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RestController
@RequestMapping("categorias/")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private CategoriaMapper categoriaMapper;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SaidaCategoriaDTO salvar(@RequestBody @Valid EntradaCategoriaDTO entradaCategoriaDTO){
        Categoria categoria = categoriaService.salvar(entradaCategoriaDTO.converterDTO());
        return SaidaCategoriaDTO.converterModeloParaDTO(categoria);
    }


}
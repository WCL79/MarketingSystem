package br.com.zup.controller;

import br.com.zup.dto.input.EntradaContatoDTO;
import br.com.zup.dto.output.SaidaContatoDTO;
import br.com.zup.model.Contato;
import br.com.zup.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("contatos/")
public class ContatoController {

    private final ContatoService contatoService;

    @Autowired
    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SaidaContatoDTO registrarContato(@RequestBody @Valid EntradaContatoDTO entradaContatoDTO){
            Contato contato = contatoService.registrarContato(entradaContatoDTO.converterDtoParaModelo());
            return SaidaContatoDTO.converterDTOParaModelo(contato);
        }
    }


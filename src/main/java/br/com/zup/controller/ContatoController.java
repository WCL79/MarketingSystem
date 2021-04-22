package br.com.zup.controller;

import br.com.zup.dto.input.AtualizarContatoDTO;
import br.com.zup.dto.input.EntradaContatoDTO;
import br.com.zup.dto.output.SaidaContatoDTO;
import br.com.zup.model.Contato;
import br.com.zup.service.ContatoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;


@RestController
@RequestMapping("contatos/")
public class ContatoController {

    private final ContatoService contatoService;

    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SaidaContatoDTO registrarContato(@RequestBody @Valid EntradaContatoDTO entradaContatoDTO) {
        Contato contato = contatoService.registrarContato(entradaContatoDTO.converterDtoParaModelo());
        return SaidaContatoDTO.converterDTOParaModelo(contato);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<SaidaContatoDTO> mostrarTodosContatos() {
        return SaidaContatoDTO.converterListaModeloParaListaDto(contatoService.buscarTodosContatos());
    }

    @DeleteMapping("{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Contato removerContato(@PathVariable Integer id) {
        return contatoService.deletarContato(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<SaidaContatoDTO> atualizarContatos(@PathVariable Integer id, @RequestBody AtualizarContatoDTO contatoDTO){
        if(contatoService.verificarContatoPorId(id)){
          Contato atualizarContato = contatoService.atualizarContato(contatoDTO.converterDtoParaModelo(id));
          return ResponseEntity.noContent().build();
        }
        Contato contato = contatoService.registrarContato(contatoDTO.converterDtoParaModelo(null));
        return ResponseEntity.status(204).body(SaidaContatoDTO.converterDTOParaModelo(contato));
        }


}


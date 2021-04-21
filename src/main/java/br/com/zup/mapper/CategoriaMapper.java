package br.com.zup.mapper;

import br.com.zup.dto.input.EntradaCategoriaDTO;
import br.com.zup.model.Categoria;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Categoria converterInputDTOParaModel(EntradaCategoriaDTO entradaCategoriaDTO){
        return modelMapper.map(entradaCategoriaDTO, Categoria.class);
    }
}

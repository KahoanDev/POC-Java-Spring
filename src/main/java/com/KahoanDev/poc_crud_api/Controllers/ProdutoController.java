package com.KahoanDev.poc_crud_api.Controllers;

import com.KahoanDev.poc_crud_api.Controllers.dto.ProdutoDTO;
import com.KahoanDev.poc_crud_api.Controllers.mappers.ProdutoMapper;
import com.KahoanDev.poc_crud_api.Model.Produto;
import com.KahoanDev.poc_crud_api.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController implements GenericController{

    private final ProdutoMapper mapper;
    private final ProdutoService service;

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody @Valid ProdutoDTO dto){
        var produto = mapper.toEntity(dto);
        service.salvar(produto);
        URI location = gerarHeaderLoction(produto.getId());

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> pesquisar(){
        List<Produto> resultado = service.pesquisar();
        List<ProdutoDTO> lista = resultado
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }
}

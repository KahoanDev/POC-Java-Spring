package com.KahoanDev.poc_crud_api.Controllers;

import com.KahoanDev.poc_crud_api.Controllers.dto.ProdutoDTO;
import com.KahoanDev.poc_crud_api.Controllers.mappers.ProdutoMapper;
import com.KahoanDev.poc_crud_api.Model.Produto;
import com.KahoanDev.poc_crud_api.Service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
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
    public ResponseEntity<List<ProdutoDTO>> pesquisarTudo(){
        List<Produto> resultado = service.pesquisarTudo();
        List<ProdutoDTO> lista = resultado
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> pesquisar(@PathVariable Long id){

        return service.pesquisar(id).map(produto -> {
            ProdutoDTO dto = mapper.toDTO(produto);
            return ResponseEntity.ok(dto);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody @Valid ProdutoDTO dto){
        Optional<Produto> produtoOptional = service.pesquisar(id);

        if (produtoOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        var produto = produtoOptional.get();
        produto.setDescricao(dto.descricao());
        produto.setTipo(dto.tipo());
        produto.setQuantidade(dto.quantidade());

        service.atualizar(produto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        Optional<Produto> produtoOptional = service.pesquisar(id);

        if (produtoOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

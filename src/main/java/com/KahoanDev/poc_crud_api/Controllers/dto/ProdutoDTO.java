package com.KahoanDev.poc_crud_api.Controllers.dto;

import com.KahoanDev.poc_crud_api.Model.enums.TipoProduto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProdutoDTO(
        Long id,
        @NotBlank(message = "campo obrigatório!")
        @Size(min = 2, max = 200, message = "campo fora do tamanho padrão")
        String descricao,
        TipoProduto tipo,
        Long quantidade
) {
}

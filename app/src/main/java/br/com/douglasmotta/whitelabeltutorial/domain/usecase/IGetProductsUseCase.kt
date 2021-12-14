package br.com.douglasmotta.whitelabeltutorial.domain.usecase

import br.com.douglasmotta.whitelabeltutorial.domain.model.Product

interface IGetProductsUseCase {

    suspend operator fun invoke(): List<Product>
}
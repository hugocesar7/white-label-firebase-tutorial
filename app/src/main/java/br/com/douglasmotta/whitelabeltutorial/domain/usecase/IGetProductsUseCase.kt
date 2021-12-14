package br.com.douglasmotta.whitelabeltutorial.domain.usecase

import br.com.douglasmotta.whitelabeltutorial.domain.model.Product
import br.com.douglasmotta.whitelabeltutorial.domain.type.ResultType

interface IGetProductsUseCase {

    suspend operator fun invoke(): ResultType<List<Product>>
}
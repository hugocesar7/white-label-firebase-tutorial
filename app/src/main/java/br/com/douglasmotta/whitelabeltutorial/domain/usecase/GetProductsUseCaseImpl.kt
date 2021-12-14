package br.com.douglasmotta.whitelabeltutorial.domain.usecase

import br.com.douglasmotta.whitelabeltutorial.data.ProductRepository
import br.com.douglasmotta.whitelabeltutorial.domain.ErrorHandler
import br.com.douglasmotta.whitelabeltutorial.domain.model.Product
import br.com.douglasmotta.whitelabeltutorial.domain.type.ResultType
import java.lang.Exception
import javax.inject.Inject

class GetProductsUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository,
    private val errorHandler: ErrorHandler
) : IGetProductsUseCase {

    override suspend fun invoke(): ResultType<List<Product>> {
        return try {
            val products = productRepository.getProducts()
            ResultType.Success(products)
        } catch (throwable: Throwable) {
            val error = errorHandler.getError(throwable)
            ResultType.Error(error)
        }
    }
}
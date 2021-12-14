package br.com.douglasmotta.whitelabeltutorial.domain.usecase

import android.net.Uri
import br.com.douglasmotta.whitelabeltutorial.domain.model.Product

interface ICreateProductUseCase {

    suspend operator fun invoke(description: String, price: Double, imageUri: Uri): Product
}
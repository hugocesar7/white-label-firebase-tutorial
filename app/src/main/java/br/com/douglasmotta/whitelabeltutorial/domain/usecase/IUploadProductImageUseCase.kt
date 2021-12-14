package br.com.douglasmotta.whitelabeltutorial.domain.usecase

import android.net.Uri

interface IUploadProductImageUseCase {

    suspend operator fun invoke(imageUri: Uri): String
}
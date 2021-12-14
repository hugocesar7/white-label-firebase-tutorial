package br.com.douglasmotta.whitelabeltutorial.domain

import br.com.douglasmotta.whitelabeltutorial.domain.type.ErrorType

interface ErrorHandler {

    fun getError(throwable: Throwable): ErrorType
}
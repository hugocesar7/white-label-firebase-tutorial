package br.com.douglasmotta.whitelabeltutorial.domain.type

sealed class ErrorType {
    object AccessDenid: ErrorType()
    object Unknown: ErrorType()
}

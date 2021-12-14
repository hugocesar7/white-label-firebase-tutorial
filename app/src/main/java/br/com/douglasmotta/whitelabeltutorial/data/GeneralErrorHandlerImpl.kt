package br.com.douglasmotta.whitelabeltutorial.data

import br.com.douglasmotta.whitelabeltutorial.domain.ErrorHandler
import br.com.douglasmotta.whitelabeltutorial.domain.type.ErrorType
import com.google.firebase.firestore.FirebaseFirestoreException
import javax.inject.Inject

class GeneralErrorHandlerImpl @Inject constructor() : ErrorHandler {

    override fun getError(throwable: Throwable): ErrorType {
        return when (throwable) {
            is FirebaseFirestoreException -> {
                if (throwable.code == FirebaseFirestoreException.Code.PERMISSION_DENIED) {
                    return ErrorType.AccessDenid
                } else return ErrorType.Unknown
            }
            else -> ErrorType.Unknown
        }
    }
}
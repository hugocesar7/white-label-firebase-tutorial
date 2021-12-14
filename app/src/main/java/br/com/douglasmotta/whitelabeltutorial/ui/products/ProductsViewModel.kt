package br.com.douglasmotta.whitelabeltutorial.ui.products

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.douglasmotta.whitelabeltutorial.R
import br.com.douglasmotta.whitelabeltutorial.config.IConfig
import br.com.douglasmotta.whitelabeltutorial.domain.model.Product
import br.com.douglasmotta.whitelabeltutorial.domain.type.ErrorType
import br.com.douglasmotta.whitelabeltutorial.domain.type.ResultType
import br.com.douglasmotta.whitelabeltutorial.domain.usecase.IGetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProductsUseCase: IGetProductsUseCase,
    config: IConfig
) : ViewModel() {

    private val _viewStateData = MutableLiveData<ViewState>()
    val viewStateData: LiveData<ViewState> = _viewStateData

    private val _addButtonVisibilityData = MutableLiveData(config.addButtonVisibility)
    val addButtonVisibilityData: LiveData<Int> = _addButtonVisibilityData

    fun getProducts() = viewModelScope.launch {
        _viewStateData.value = when(val result = getProductsUseCase()){
            is ResultType.Success -> ViewState.ShowProducts(result.data)
            is ResultType.Error -> {
                ViewState.ShowError(
                    when(result.error){
                        is ErrorType.AccessDenid -> R.string.products_error_access_denied
                        else -> R.string.products_error_unknown
                    }
                )
            }
        }
    }

    sealed class ViewState {
        class ShowProducts(val products: List<Product>): ViewState()
        class ShowError(val messageResId: Int): ViewState()
    }
}
package br.com.douglasmotta.whitelabeltutorial.config

import android.view.View
import javax.inject.Inject

class ConfigImpl @Inject constructor() : IConfig {

    override val addButtonVisibility: Int = View.VISIBLE
}
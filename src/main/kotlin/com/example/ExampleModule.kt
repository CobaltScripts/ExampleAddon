package com.example

import org.cobalt.api.module.Module
import org.cobalt.api.module.setting.Setting

class ExampleModule : Module() {

  override fun getSettings(): List<Setting<*>> {
    return emptyList()
  }

  override fun onInitialize() {
    println("HELLO WORLD!")
  }

}

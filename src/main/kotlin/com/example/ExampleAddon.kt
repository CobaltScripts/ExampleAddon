package com.example

import com.example.command.ExampleCommand
import com.example.module.ExampleModule
import org.cobalt.api.addon.Addon
import org.cobalt.api.command.CommandManager
import org.cobalt.api.module.ModuleManager

object ExampleAddon : Addon() {

  const val CATEGORY = "Example"

  override fun onInitialize() {
    ModuleManager.addModules(ExampleModule)
    CommandManager.register(ExampleCommand)

    println("ExampleAddon initialized!")
  }

}

package com.mighty

import com.mighty.command.MightyCommand
import com.mighty.module.MightyModule
import org.cobalt.api.addon.Addon
import org.cobalt.api.command.CommandManager
import org.cobalt.api.module.Module

object MightyAddon : Addon() {

  // i wanna add a path renderer (thats why there is a /clear subcommand) but im too dumb rn

  override fun onLoad() {
    CommandManager.register(MightyCommand)

    println("[AutoRat] Ratting retard...")
  }

  override fun onUnload() {
    println("[AutoRat] Unratting retard...")
  }

  override fun getModules(): List<Module> {
    return listOf(MightyModule)
  }
}

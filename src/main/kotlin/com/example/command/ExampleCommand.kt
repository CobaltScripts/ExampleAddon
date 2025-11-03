package com.example.command

import org.cobalt.api.command.Command
import org.cobalt.api.command.annotation.DefaultHandler
import org.cobalt.api.command.annotation.SubCommand

object ExampleCommand : Command(
  name = "example",
  aliases = arrayOf("exampleaddon", "ea"),
) {

  @DefaultHandler
  fun main() {
    println("ExampleAddon default handler!")
  }

  @SubCommand
  fun hello(name: String) {
    println("Hello, $name!")
  }

}

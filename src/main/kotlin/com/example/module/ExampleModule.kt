package com.example.module

import com.example.ExampleAddon
import java.awt.Color
import org.cobalt.api.module.Module
import org.cobalt.api.module.setting.impl.*
import org.lwjgl.glfw.GLFW

object ExampleModule : Module(
  name = "Example Module",
  category = ExampleAddon.CATEGORY
) {

  val checkbox by CheckboxSetting("Checkbox", "Example checkbox setting", true)
  val color by ColorSetting("Color", "Example color setting", Color.WHITE.rgb)
  val keyBind by KeyBindSetting("KeyBind", "Example keybind setting", GLFW.GLFW_KEY_ESCAPE)
  val mode by ModeSetting("Mode", "Example mode setting", 0, arrayOf("Mode1", "Mode2", "Mode3"))
  val range by RangeSetting("Range", "Example range setting", Pair(3.0, 5.0), 0.0, 10.0)
  val slider by SliderSetting("Slider", "Example slider setting", 3.0, 1.0, 10.0)
  val text by TextSetting("Text", "Example text setting", "Hello")

  override fun onEnable() {
    println("Enabled")
  }

  override fun onDisable() {
    println("Disabled")
  }

}

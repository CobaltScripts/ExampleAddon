package com.mighty.command

import com.mighty.pathfinder.Pathfinder
import com.mighty.pathfinder.helper.Node
import com.mighty.pathfinder.helper.NodeData
import net.minecraft.client.MinecraftClient
import net.minecraft.util.math.BlockPos
import org.cobalt.api.command.Command
import org.cobalt.api.command.annotation.DefaultHandler
import org.cobalt.api.command.annotation.SubCommand
import org.cobalt.api.util.ChatUtils
import kotlin.concurrent.thread

object MightyCommand : Command(
  name = "mighty",
  aliases = arrayOf("mighty")
) {
  private val mc = MinecraftClient.getInstance()
  private var cachedPath: List<Node>? = null

  @DefaultHandler
  fun main() {
    ChatUtils.sendMessage("what does bro want?")
  }

  @SubCommand
  fun to(x: Int, y: Int, z: Int) {
    val player = mc.player ?: run {
      ChatUtils.sendMessage("§cPlayer not found!")
      return
    }

    val startPos = BlockPos(
      player.x.toInt(),
      player.y.toInt() - 1,
      player.z.toInt()
    )
    val endPos = BlockPos(x, y - 2, z)

    ChatUtils.sendMessage(
      "§aCalculating path from §e${startPos.x}, ${startPos.y + 2}, ${startPos.z}§a to §e${x}, ${y}, ${z}§a..."
    )

    thread {
      try {
        val startData = NodeData(startPos, 0.0, false)
        val endData = NodeData(endPos, 0.0, false)

        val pathfinder = Pathfinder(startData, endData)
        val path = pathfinder.calculatePath()

        mc.execute {
          if (path != null && path.isNotEmpty()) {
            cachedPath = path
            ChatUtils.sendMessage(
              "§aPath found! §e${path.size}§a (final) nodes"
            )

            ChatUtils.sendMessage("(Pretend you're walking to the nodes listed below)")

            for (node in path)
            {
              ChatUtils.sendMessage(
                "${node.data.pos}"
              )
            }
          } else {
            ChatUtils.sendMessage("§cNo path found to target location :(")
          }
        }
      } catch (e: Exception) {
        mc.execute {
          ChatUtils.sendMessage("§cError calculating path: ${e.message}")
          e.printStackTrace()
        }
      }
    }
  }

  @SubCommand
  fun clear() {
    if (cachedPath != null) {
      cachedPath = null
      ChatUtils.sendMessage("§aPath cleared!")
    } else {
      ChatUtils.sendMessage("§cNo path to clear!")
    }
  }

  fun getCachedPath(): List<Node>? = cachedPath
}

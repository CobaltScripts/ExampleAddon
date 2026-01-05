package com.mighty.pathfinder.helper

import net.minecraft.util.math.BlockPos

class NodeData(
  val pos: BlockPos,
  val movement: Double,
  val isCustomNode: Boolean
) {
  var parent: BlockPos? = null
  var isJumpTarget: Boolean = false

  fun setCustomParent(pos: BlockPos) {
    this.parent = pos
  }
}

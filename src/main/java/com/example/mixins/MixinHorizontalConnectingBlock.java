package com.example.mixins;

import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalConnectingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.StainedGlassPaneBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(HorizontalConnectingBlock.class)
public class MixinHorizontalConnectingBlock {

  @Inject(method = "getOutlineShape", at = @At("HEAD"), cancellable = true)
  private void getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context, CallbackInfoReturnable<VoxelShape> cir) {
    if (((Object) this) instanceof StainedGlassPaneBlock) {
      cir.setReturnValue(VoxelShapes.fullCube());
    }
  }

}

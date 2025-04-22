package harou.small_netherite_beacons.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BeaconBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BeaconBlockEntity.class)
public class BeaconBlockEntityMixin {

	@Inject(at = @At("HEAD"), method = "updateLevel", cancellable = true)
	private static void updateLevel(World world, int x, int y, int z, CallbackInfoReturnable<Integer> cir) {
		BlockPos pos = new BlockPos(x, y, z);
		int level = getNetheriteBaseLevel(world, pos);
		if (level > 0) {
			cir.setReturnValue(level);
		}
	}

	private static int getNetheriteBaseLevel(World world, BlockPos pos) {
		if (isNetheriteBase(world, pos.down())) return 4;
		return 0;
	}

	private static boolean isNetheriteBase(World world, BlockPos basePos) {
		for (int x = -1; x <= 1; x++) {
			for (int z = -1; z <= 1; z++) {
				BlockPos pos = basePos.add(x, 0, z);
				if (!world.getBlockState(pos).isOf(Blocks.NETHERITE_BLOCK)) {
					return false;
				}
			}
		}
		return true;
	}
}

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

	@Inject(at = @At("RETURN"), method = "updateLevel", cancellable = true)
	private static void updateLevel(World world, int x, int y, int z, CallbackInfoReturnable<Integer> cir) {
		int beaconLevel = cir.getReturnValue();
		if (beaconLevel <= 0) return;

		BlockPos pos = new BlockPos(x, y, z);
		if (world.getBlockState(pos.down()).isOf(Blocks.NETHERITE_BLOCK)) {
			cir.setReturnValue(4); 
		}
	}
}

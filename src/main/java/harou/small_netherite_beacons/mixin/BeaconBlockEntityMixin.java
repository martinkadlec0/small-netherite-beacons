package harou.small_netherite_beacons.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BeaconBlockEntity.class)
public class BeaconBlockEntityMixin {

	@Inject(at = @At("RETURN"), method = "updateBase", cancellable = true)
	private static void updateLevel(Level world, int x, int y, int z, CallbackInfoReturnable<Integer> cir) {
		int beaconLevel = cir.getReturnValue();
		if (beaconLevel <= 0) return;

		BlockPos pos = new BlockPos(x, y, z);
		if (world.getBlockState(pos.below()).is(Blocks.NETHERITE_BLOCK)) {
			cir.setReturnValue(4); 
		}
	}
}

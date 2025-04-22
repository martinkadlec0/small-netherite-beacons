package harou.small_netherite_beacons;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmallNetheriteBeacons implements ModInitializer {
	public static final String MOD_ID = "small-netherite-beacons";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("SmallNetheriteBeacons initiated!");
	}
}
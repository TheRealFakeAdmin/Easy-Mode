package xyz.trfa.easymode;

import net.fabricmc.api.ClientModInitializer;
import xyz.trfa.easymode.config.TrainerConfig;

public class EasyModeClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		// You can perform other client-specific initialization here if needed.
		TrainerConfig.load();
	}
}

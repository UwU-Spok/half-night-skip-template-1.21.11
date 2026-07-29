package net.spok.halfnightskip;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





public class HalfNightSkip implements ModInitializer {
	public static final String MOD_ID = "half-night-skip";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



	public boolean insomnia = false;		//spawn des fantomes pour les batman
	public static double percentage = 0.5;			//la proportion de dormeurs necessaires pour skip la nuit
	public static boolean floor = true;		//arrondi a l'exces ou pas
	public static int plus = 1;				//value to add to the number of player needed to sleep 




	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");




	}

	
}

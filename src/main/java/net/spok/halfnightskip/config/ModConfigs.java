package net.spok.halfnightskip.config;


import com.mojang.datafixers.util.Pair;

import net.spok.halfnightskip.HalfNightSkip;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static int PLUS;
    public static double PERCENTAGE;
    public static boolean FLOOR;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(HalfNightSkip.MOD_ID + "config").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("plus", 1), "number of player that need to sleep + the aproximation can be whatever you want, the mod won't display a number higher than the number of players connected");
        configs.addKeyValuePair(new Pair<>("percentage", 0.5), "Control the percentage of player that need to be sleeping to skip the night should be betwin ]0 to 1[ ");
        configs.addKeyValuePair(new Pair<>("floor", true), "A boolean that control wether the aproximation of the number of player that need to sleep should be a floor or a ceil (sry for my bad english) ");
    }

    private static void assignConfigs() {
        PLUS = CONFIG.getOrDefault("plus", 1);
        PERCENTAGE = CONFIG.getOrDefault("percentage", 0.5d);
        FLOOR = CONFIG.getOrDefault("floor", true);

        System.out.println("All " + configs.getConfigsList().size() + " have been set properly");
    }
}
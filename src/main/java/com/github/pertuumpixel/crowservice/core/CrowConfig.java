package com.github.pertuumpixel.crowservice.core;

import net.minecraftforge.common.ForgeConfigSpec;

public class CrowConfig {

	private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	
	public static final General GENERAL = new General(BUILDER);
	public static final ForgeConfigSpec spec = BUILDER.build();
	
	public static class General {
		public final ForgeConfigSpec.ConfigValue<Boolean> TestConfBool;
		public final ForgeConfigSpec.ConfigValue<Integer> TestConfInt;
		
		public General(ForgeConfigSpec.Builder builder) {
			builder.push("General");
			TestConfBool = builder
                    .comment("Enables/Disables the whole Mod [false/true|default:true]")
                    .translation("enable.ocdtorcher.config")
                    .define("enableMod", true);
            TestConfInt = builder
                    .comment("sets the Reach of the Torcher [0..50|default:20]")
                    .translation("distance.ocdtorcher.config")
                    .defineInRange("TorcherDistance", 20, 0,50);
            builder.pop();
		}
	}
	
	
}

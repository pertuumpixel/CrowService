package com.github.pertuumpixel.crowservice.setup;

import com.github.pertuumpixel.crowservice.CrowService;
import com.github.pertuumpixel.crowservice.core.init.BlockInit;
import com.github.pertuumpixel.crowservice.core.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {

	
	
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			CrowService.MOD_ID);

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			CrowService.MOD_ID);

	
	public static void register() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		
		
		//Registering blocks and item registers to the bus
		BLOCKS.register(modEventBus);
		ITEMS.register(modEventBus);
		
		
		BlockInit.register();
		ItemInit.register();
		
		
		//Config Setup
		 ModLoadingContext.get().registerConfig(net.minecraftforge.fml.config.ModConfig.Type.COMMON,
				 com.github.pertuumpixel.crowservice.core.CrowConfig.spec);

	}
	
	
}

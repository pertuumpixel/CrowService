package com.github.pertuumpixel.crowservice.setup;

import com.github.pertuumpixel.crowservice.CrowService;
import com.github.pertuumpixel.crowservice.core.init.*;

import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class Registration {




	public static final DeferredRegister<Block> BLOCKS = create(ForgeRegistries.BLOCKS);
	public static final DeferredRegister<ContainerType<?>> CONTAINERS = create(ForgeRegistries.CONTAINERS);
	public static final DeferredRegister<Item> ITEMS = create(ForgeRegistries.ITEMS);
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = create(ForgeRegistries.TILE_ENTITIES);
	public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = create(ForgeRegistries.RECIPE_SERIALIZERS);

	public static void register() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		
		
		//Registering blocks and item registers to the bus
		BLOCKS.register(modEventBus);
		ITEMS.register(modEventBus);
		CONTAINERS.register(modEventBus);
		TILE_ENTITIES.register(modEventBus);
		RECIPE_SERIALIZERS.register(modEventBus);
		
		BlockInit.register();
		ItemInit.register();
		TileEntityTypesInit.register();
		ContainerTypesInit.register();
		RecipesInit.register();

		
		//Config Setup
		 ModLoadingContext.get().registerConfig(net.minecraftforge.fml.config.ModConfig.Type.COMMON,
				 com.github.pertuumpixel.crowservice.core.CrowConfig.spec);

	}

	//Deferred Register creation
	private static <T extends IForgeRegistryEntry<T>> DeferredRegister<T> create(IForgeRegistry<T> registry) {
		return DeferredRegister.create(registry, CrowService.MOD_ID);
	}


}

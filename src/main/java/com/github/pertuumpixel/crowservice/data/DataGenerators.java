package com.github.pertuumpixel.crowservice.data;

import com.github.pertuumpixel.crowservice.CrowService;
import com.github.pertuumpixel.crowservice.data.client.ModBlockStateProvider;
import com.github.pertuumpixel.crowservice.data.client.ModBlockTagsProvider;
import com.github.pertuumpixel.crowservice.data.client.ModItemModelProvider;
import com.github.pertuumpixel.crowservice.data.client.ModItemTagsProvider;
import com.github.pertuumpixel.crowservice.data.client.ModLootTableProvider;
import com.github.pertuumpixel.crowservice.data.client.ModRecipeProvider;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;



@Mod.EventBusSubscriber(modid = CrowService.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataGenerators {
	private DataGenerators() {}
	
	
	
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
		
		
		//Blocks and items
		
		gen.addProvider(new ModBlockStateProvider(gen, existingFileHelper));
		gen.addProvider(new ModItemModelProvider(gen, existingFileHelper));
		
		
		//Tags
		
		ModBlockTagsProvider blockTags = new ModBlockTagsProvider(gen, existingFileHelper);
		gen.addProvider(blockTags);
		gen.addProvider(new ModItemTagsProvider(gen, blockTags, existingFileHelper));
		
		//Loot Tables
		
		gen.addProvider(new ModLootTableProvider(gen));
		
		//Recipes
		
		gen.addProvider(new ModRecipeProvider(gen));
		
	}
	
}

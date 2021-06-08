package com.github.pertuumpixel.crowservice.data.client;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.github.pertuumpixel.crowservice.core.init.BlockInit;

import com.github.pertuumpixel.crowservice.setup.Registration;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;

import net.minecraft.loot.*;
import net.minecraft.loot.LootTable.Builder;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

public class ModLootTableProvider extends LootTableProvider {

	public ModLootTableProvider(DataGenerator dataGenerator) {
		super(dataGenerator);
	}
	
	@Override
	protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootParameterSet>> getTables() {
		return ImmutableList.of(
				Pair.of(ModBlockLootTables::new, LootParameterSets.BLOCK)
				);
				
	
	}
	
	@Override
	protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) {
		map.forEach((p_218436_2_, p_218436_3_) -> LootTableManager.validate(validationtracker, p_218436_2_, p_218436_3_));
	}
	
	public static class ModBlockLootTables extends BlockLootTables {
		
		@Override
		protected void addTables() {
			dropSelf(BlockInit.COPPER_ORE.get());
			dropSelf(BlockInit.COPPER_BLOCK.get());
			dropSelf(BlockInit.SILVER_ORE.get());
			dropSelf(BlockInit.SILVER_BLOCK.get());
			dropSelf(BlockInit.MAILBOX.get());
			dropSelf(BlockInit.COIN_PRESS.get());
		}
		
		@Override
		protected Iterable<Block> getKnownBlocks() {
			return Registration.BLOCKS.getEntries().stream()
					.map(RegistryObject::get)
					.collect(Collectors.toList());
		}
	}

	
	

}

package com.github.pertuumpixel.crowservice.data.client;

import com.github.pertuumpixel.crowservice.CrowService;
import com.github.pertuumpixel.crowservice.core.init.BlockInit;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider  extends BlockStateProvider{

	public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, CrowService.MOD_ID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		simpleBlock(BlockInit.SILVER_BLOCK.get());
		simpleBlock(BlockInit.SILVER_ORE.get());
		
		simpleBlock(BlockInit.COPPER_BLOCK.get());
		simpleBlock(BlockInit.COPPER_ORE.get());
		
		simpleBlock(BlockInit.MAILBOX.get());
		simpleBlock(BlockInit.COIN_PRESS.get());
		
		
	}
	
	

}

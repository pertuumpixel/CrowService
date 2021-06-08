package com.github.pertuumpixel.crowservice.data.client;

import com.github.pertuumpixel.crowservice.CrowService;
import com.github.pertuumpixel.crowservice.core.init.BlockInit;
import com.github.pertuumpixel.crowservice.setup.ModTags;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.Tags;

public class ModBlockTagsProvider extends BlockTagsProvider {

	public ModBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
		super(generatorIn, CrowService.MOD_ID, existingFileHelper);
	}
	
	@Override
	protected void addTags() {
		
		tag(ModTags.Blocks.ORES_SILVER).add(BlockInit.SILVER_ORE.get());
		tag(Tags.Blocks.ORES).addTag(ModTags.Blocks.ORES_SILVER);
		
		tag(ModTags.Blocks.STORAGE_BLOCKS_SILVER).add(BlockInit.SILVER_BLOCK.get());
		tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS_SILVER);
		
	}


}

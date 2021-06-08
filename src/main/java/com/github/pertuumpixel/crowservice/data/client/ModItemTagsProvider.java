package com.github.pertuumpixel.crowservice.data.client;

import com.github.pertuumpixel.crowservice.CrowService;
import com.github.pertuumpixel.crowservice.core.init.ItemInit;
import com.github.pertuumpixel.crowservice.setup.ModTags;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider {

	public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagsProvider,
			ExistingFileHelper existingFileHelper) {
		super(dataGenerator, blockTagsProvider, CrowService.MOD_ID, existingFileHelper);
		
	}
	
	
	@Override
	protected void addTags() {
		copy(ModTags.Blocks.ORES_SILVER, ModTags.Items.ORES_SILVER);
		copy(Tags.Blocks.ORES, Tags.Items.ORES);
		copy(ModTags.Blocks.STORAGE_BLOCKS_SILVER, ModTags.Items.STORAGE_BLOCKS_SILVER);
		copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
		
		tag(ModTags.Items.INGOTS_SILVER).add(ItemInit.SILVER_INGOT.get());
		tag(Tags.Items.INGOTS).addTag(ModTags.Items.INGOTS_SILVER);
	}
	

}

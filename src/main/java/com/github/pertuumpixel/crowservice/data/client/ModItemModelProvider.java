package com.github.pertuumpixel.crowservice.data.client;

import com.github.pertuumpixel.crowservice.CrowService;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

	public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, CrowService.MOD_ID, existingFileHelper);
		// TODO Auto-generated constructor stub
	}

	
	
	
	@Override
	protected void registerModels() {
		
		
		withExistingParent("copper_block", modLoc("block/copper_block"));
		withExistingParent("copper_ore", modLoc("block/copper_ore"));
		
		
		withExistingParent("silver_block", modLoc("block/silver_block"));
		withExistingParent("silver_ore", modLoc("block/silver_ore"));
		
		withExistingParent("coin_press", modLoc("block/coin_press"));
		withExistingParent("mailbox", modLoc("block/mailbox"));
		
		ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
		
		
		
		
	
		builder(itemGenerated, "copper_ingot");
		builder(itemGenerated, "silver_ingot");
		builder(itemGenerated, "empty_envelope");
		builder(itemGenerated, "sealed_envelope");
		builder(itemGenerated, "copper_coin");
		builder(itemGenerated, "silver_coin");
		builder(itemGenerated, "gold_coin");
		
	}




	private void builder(ModelFile itemGenerated, String name) { 
		getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
	}

}

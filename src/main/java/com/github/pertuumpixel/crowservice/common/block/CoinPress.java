package com.github.pertuumpixel.crowservice.common.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class CoinPress extends Block {

	public CoinPress() {
		super(AbstractBlock.Properties
				.of(Material.HEAVY_METAL)
				.sound(SoundType.ANVIL)
				.harvestTool(ToolType.PICKAXE)
				.harvestLevel(3)
				.strength(15f, 20f));

	}
	
	

}

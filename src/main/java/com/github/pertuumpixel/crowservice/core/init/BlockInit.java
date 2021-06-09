package com.github.pertuumpixel.crowservice.core.init;

import java.util.function.Supplier;

import com.github.pertuumpixel.crowservice.CrowService;
import com.github.pertuumpixel.crowservice.common.block.coin_press.CoinPressBlock;
import com.github.pertuumpixel.crowservice.common.block.Mailbox;
import com.github.pertuumpixel.crowservice.setup.Registration;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

public class BlockInit {

	public static void register() {}
	
	
	
	
	public static final RegistryObject<Block> MAILBOX = register("mailbox", () -> new Mailbox());
	
	public static final RegistryObject<CoinPressBlock> COIN_PRESS = register("coin_press", () -> new CoinPressBlock());
	
	
	public static final RegistryObject<Block> COPPER_ORE = register("copper_ore", 
			() -> new Block(AbstractBlock.Properties
					.of(Material.STONE)
					.harvestTool(ToolType.PICKAXE)
					.harvestLevel(2)
					.strength(3, 10)
					.sound(SoundType.STONE)
					));
	
	public static final RegistryObject<Block> COPPER_BLOCK = register("copper_block", 
			() -> new Block(AbstractBlock.Properties
					.of(Material.METAL)
					.harvestTool(ToolType.PICKAXE)
					.strength(3, 10)
					.sound(SoundType.METAL)
					));
	
	
	
	
	public static final RegistryObject<Block> SILVER_ORE = register("silver_ore", 
			() -> new Block(AbstractBlock.Properties
					.of(Material.STONE)
					.harvestTool(ToolType.PICKAXE)
					.harvestLevel(2)
					.strength(3, 10)
					.sound(SoundType.STONE)
					));
	
	public static final RegistryObject<Block> SILVER_BLOCK = register("silver_block", 
			() -> new Block(AbstractBlock.Properties
					.of(Material.METAL)
					.harvestTool(ToolType.PICKAXE)
					.strength(3, 10)
					.sound(SoundType.METAL)
					));
	
	
	
	private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block){
		return Registration.BLOCKS.register(name, block);
	}
	
	private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block){
		RegistryObject<T> ret = registerNoItem(name, block);
		Registration.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().tab(CrowService.TAB_GROUP)));
		return ret;
	}
	
	
	

}

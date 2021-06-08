package com.github.pertuumpixel.crowservice.data.client;

import java.util.function.Consumer;
import java.util.stream.Stream;

import com.github.pertuumpixel.crowservice.CrowService;
import com.github.pertuumpixel.crowservice.core.init.BlockInit;
import com.github.pertuumpixel.crowservice.core.init.ItemInit;

import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.Ingredient.IItemList;
import net.minecraft.item.crafting.Ingredient.SingleItemList;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CompoundIngredient;

public class ModRecipeProvider extends RecipeProvider {

	public ModRecipeProvider(DataGenerator dataGenerator) {
		super(dataGenerator);
	}
	
	
	@Override
	protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {


		ShapelessRecipeBuilder.shapeless(ItemInit.SILVER_INGOT.get(), 9)
		.requires(BlockInit.SILVER_BLOCK.get())
		.unlockedBy("has_item", has(ItemInit.SILVER_INGOT.get()))
		.save(consumer);

		ShapelessRecipeBuilder.shapeless(ItemInit.COPPER_INGOT.get(), 9)
				.requires(BlockInit.COPPER_BLOCK.get())
				.unlockedBy("has_item", has(ItemInit.COPPER_INGOT.get()))
				.save(consumer);



		ShapedRecipeBuilder.shaped(BlockInit.SILVER_BLOCK.get())
		.define('#', ItemInit.SILVER_INGOT.get())
		.pattern("###")
		.pattern("###")
		.pattern("###")
		.unlockedBy("has_item", has(ItemInit.SILVER_INGOT.get()))
		.save(consumer);

		ShapedRecipeBuilder.shaped(BlockInit.COPPER_BLOCK.get())
				.define('#', ItemInit.COPPER_INGOT.get())
				.pattern("###")
				.pattern("###")
				.pattern("###")
				.unlockedBy("has_item", has(ItemInit.COPPER_INGOT.get()))
				.save(consumer);

		ShapedRecipeBuilder.shaped(BlockInit.MAILBOX.get())
				.define('#', ItemTags.PLANKS)
				.define('%', ItemInit.EMPTY_ENVELOPE.get())
				.pattern("###")
				.pattern("#%#")
				.pattern("###")
				.unlockedBy("has_item", has(ItemInit.EMPTY_ENVELOPE.get()))
				.save(consumer);

		ShapedRecipeBuilder.shaped(ItemInit.EMPTY_ENVELOPE.get())
				.define('#', Items.PAPER)
				.pattern(" # ")
				.pattern("# #")
				.pattern("###")
				.unlockedBy("has_item", has(Items.PAPER))
				.save(consumer);



		CookingRecipeBuilder.smelting(Ingredient.of(BlockInit.SILVER_ORE.get()),ItemInit.SILVER_INGOT.get(), 1.0f, 200)
			.unlockedBy("has_item", has(BlockInit.SILVER_ORE.get()))
			.save(consumer, modId("silver_ingot_smelting"));
		CookingRecipeBuilder.smelting(Ingredient.of(BlockInit.COPPER_ORE.get()),ItemInit.COPPER_INGOT.get(), 1.0f, 200)
				.unlockedBy("has_item", has(BlockInit.COPPER_ORE.get()))
				.save(consumer, modId("copper_ingot_smelting"));

		CookingRecipeBuilder.blasting(Ingredient.of(BlockInit.SILVER_ORE.get()),ItemInit.SILVER_INGOT.get(), 1.0f, 100)
			.unlockedBy("has_item", has(BlockInit.SILVER_ORE.get()))
			.save(consumer, modId("silver_ingot_blasting"));
		CookingRecipeBuilder.blasting(Ingredient.of(BlockInit.COPPER_ORE.get()),ItemInit.COPPER_INGOT.get(), 1.0f, 100)
				.unlockedBy("has_item", has(BlockInit.COPPER_ORE.get()))
				.save(consumer, modId("copper_ingot_blasting"));





	}


	private static ResourceLocation modId(String path) {

		return new ResourceLocation(CrowService.MOD_ID, path);
	}

}




































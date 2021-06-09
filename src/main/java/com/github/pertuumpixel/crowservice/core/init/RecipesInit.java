package com.github.pertuumpixel.crowservice.core.init;

import com.github.pertuumpixel.crowservice.CrowService;
import com.github.pertuumpixel.crowservice.common.item.crafting.recipe.PressingRecipe;
import com.github.pertuumpixel.crowservice.setup.Registration;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class RecipesInit {

    public static class Types {
        public static final IRecipeType<PressingRecipe> PRESSING = IRecipeType.register(CrowService.MOD_ID + "pressing");

        private Types(){}
    }

    public static class Serializers {

        public static final RegistryObject<IRecipeSerializer<?>> PRESSING = Registration.RECIPE_SERIALIZERS.register(
                "pressing", PressingRecipe.Serializer::new);

        private static <T extends IRecipe<?>>RegistryObject<IRecipeSerializer<T>> register(String name, Supplier<IRecipeSerializer<T>> serializer){
            return Registration.RECIPE_SERIALIZERS.register(name, serializer);
        }

        private Serializers(){}
    }

    public static void register() {}
}

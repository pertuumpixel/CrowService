package com.github.pertuumpixel.crowservice.core.init;


import com.github.pertuumpixel.crowservice.common.block.coin_press.CoinPressTileEntity;
import com.github.pertuumpixel.crowservice.setup.Registration;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

import java.util.Arrays;
import java.util.function.Supplier;

public class TileEntityTypesInit {

    public static final RegistryObject<TileEntityType<CoinPressTileEntity>> COIN_PRESS = register(
            "coin_press",
            CoinPressTileEntity::new,
            BlockInit.COIN_PRESS
    );


    public static void register() {}

    private static <T extends TileEntity> RegistryObject<TileEntityType<T>> register(String name, Supplier<T> factory, RegistryObject<? extends Block> block) {
        return Registration.TILE_ENTITIES.register(name, () -> {

            return TileEntityType.Builder.of(factory, block.get()).build(null);
        });
    }



}
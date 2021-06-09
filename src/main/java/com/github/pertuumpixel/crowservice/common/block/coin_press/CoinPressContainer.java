package com.github.pertuumpixel.crowservice.common.block.coin_press;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.IIntArray;

import javax.annotation.Nullable;

public class CoinPressContainer extends Container {


    public CoinPressContainer(int id, PlayerInventory playerInventory, CoinPressTileEntity tileEntity, IIntArray fields){
        super(ContainerType.FURNACE, 0);
    }


    @Override
    public boolean stillValid(PlayerEntity p_75145_1_) {
        return false;
    }
}

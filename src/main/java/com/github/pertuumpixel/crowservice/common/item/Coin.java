package com.github.pertuumpixel.crowservice.common.item;

import com.github.pertuumpixel.crowservice.CrowService;

import net.minecraft.item.Item;

public abstract class Coin extends Item {

	protected double value;
	
	
	public Coin(double value) {
		super(new Item.Properties().tab(CrowService.TAB_GROUP));
		this.value = value;
	}

	
	
}

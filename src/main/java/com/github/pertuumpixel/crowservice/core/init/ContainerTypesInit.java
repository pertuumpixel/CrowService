package com.github.pertuumpixel.crowservice.core.init;

import com.github.pertuumpixel.crowservice.CrowService;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerTypesInit {

	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPE = DeferredRegister
			.create(ForgeRegistries.CONTAINERS, CrowService.MOD_ID);

}

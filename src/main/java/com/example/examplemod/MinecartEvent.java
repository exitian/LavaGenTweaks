package com.example.examplemod;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.vehicle.Minecart;
import net.neoforged.neoforge.common.extensions.IAbstractMinecartExtension;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;

public class MinecartEvent {
    public static void minecartMoment(Mine){}

    public static void onMinecartTick(IAbstractMinecartExtension cart) {
        cart.getMaxCartSpeedOnRail();


    }

    public static void onMinecartSpawn(EntityJoinLevelEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof IAbstractMinecartExtension minecart) {
            minecart.setCurrentCartSpeedCapOnRail(200.0f);
        }
    }
}

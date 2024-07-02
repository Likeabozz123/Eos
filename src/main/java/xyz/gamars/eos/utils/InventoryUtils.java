package xyz.gamars.eos.utils;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;

public class InventoryUtils {


    public static boolean isInventoryFull(NonNullList<ItemStack> items) {
        for (ItemStack item : items) {
            if (item.isEmpty()) {
                return false;
            }
        }
        return true;
    }

}

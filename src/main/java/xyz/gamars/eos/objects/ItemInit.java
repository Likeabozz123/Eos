package xyz.gamars.eos.objects;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.gamars.eos.Eos;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, Eos.MOD_ID);

    public static final DeferredHolder<Item, Item> DEV_ITEM = ITEMS.register("dev_item", () -> new Item(new Item.Properties()));

}

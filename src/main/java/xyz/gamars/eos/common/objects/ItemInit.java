package xyz.gamars.eos.common.objects;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.objects.items.DevItem;
import xyz.gamars.eos.common.objects.items.PoseidonArmorItem;
import xyz.gamars.eos.common.objects.items.coolassstick.CoolAssStickItem;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, Eos.MOD_ID);


    public static final DeferredHolder<Item, Item> DEV_ITEM = ITEMS.register("dev_item", () -> new DevItem(new Item.Properties()));
    public static final DeferredHolder<Item, Item> PLUNGER = ITEMS.register("plunger", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> COOL_ASS_STICK = ITEMS.register("cool_ass_stick", () -> new CoolAssStickItem(new Item.Properties()));

    public static final DeferredHolder<Item, Item> POSEIDON_HELMET = ITEMS.register("poseidon_helmet",
            () -> new PoseidonArmorItem(ArmorMaterialsInit.POSEIDON_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredHolder<Item, Item> POSEIDON_CHESTPLATE = ITEMS.register("poseidon_chestplate",
            () -> new PoseidonArmorItem(ArmorMaterialsInit.POSEIDON_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredHolder<Item, Item> POSEIDON_LEGGINGS = ITEMS.register("poseidon_leggings",
            () -> new PoseidonArmorItem(ArmorMaterialsInit.POSEIDON_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredHolder<Item, Item> POSEIDON_BOOTS = ITEMS.register("poseidon_boots",
            () -> new PoseidonArmorItem(ArmorMaterialsInit.POSEIDON_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()));






    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}

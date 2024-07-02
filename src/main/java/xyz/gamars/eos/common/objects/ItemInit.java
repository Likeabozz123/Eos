package xyz.gamars.eos.common.objects;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.components.SizeComponent;
import xyz.gamars.eos.common.objects.items.*;
import xyz.gamars.eos.common.objects.items.coolassstick.CoolAssStickItem;
import xyz.gamars.eos.common.objects.items.wukongsstaff.WukongsStaffItem;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, Eos.MOD_ID);


    public static final DeferredHolder<Item, DevItem> DEV_ITEM = ITEMS.register("dev_item", () -> new DevItem(new Item.Properties()));
    public static final DeferredHolder<Item, PlungerItem> PLUNGER = ITEMS.register("plunger", () -> new PlungerItem(new Item.Properties()));

    public static final DeferredHolder<Item, CoolAssStickItem> COOL_ASS_STICK = ITEMS.register("cool_ass_stick", () -> new CoolAssStickItem(new Item.Properties()));

    public static final DeferredHolder<Item, PoseidonArmorItem> POSEIDON_HELMET = ITEMS.register("poseidon_helmet",
            () -> new PoseidonArmorItem(ArmorMaterialsInit.POSEIDON_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredHolder<Item, PoseidonArmorItem> POSEIDON_CHESTPLATE = ITEMS.register("poseidon_chestplate",
            () -> new PoseidonArmorItem(ArmorMaterialsInit.POSEIDON_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredHolder<Item, PoseidonArmorItem> POSEIDON_LEGGINGS = ITEMS.register("poseidon_leggings",
            () -> new PoseidonArmorItem(ArmorMaterialsInit.POSEIDON_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredHolder<Item, PoseidonArmorItem> POSEIDON_BOOTS = ITEMS.register("poseidon_boots",
            () -> new PoseidonArmorItem(ArmorMaterialsInit.POSEIDON_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredHolder<Item, PoseidonTridentItem> POSEIDON_TRIDENT = ITEMS.register("poseidon_trident",
            () -> new PoseidonTridentItem(new Item.Properties().attributes(PoseidonTridentItem.createAttributes())));

    public static final DeferredHolder<Item, TyrfingrSword> TYRFINGER_SWORD = ITEMS.register("tyrfingr_sword",
            () -> new TyrfingrSword(Tiers.NETHERITE, new Item.Properties().attributes(TyrfingrSword.createAttributes(Tiers.DIAMOND, 5, -2f))));

    public static final DeferredHolder<Item, Item> WUKONGS_STAFF = ITEMS.register("wukongs_staff", () -> new WukongsStaffItem(
            new Item.Properties().attributes(WukongsStaffItem.createAttributes())
                    .component(DataComponentsInit.SIZE.value(), new SizeComponent(1, WukongsStaffItem.MAX_SIZE))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}

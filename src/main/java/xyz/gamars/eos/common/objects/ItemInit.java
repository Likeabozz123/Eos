package xyz.gamars.eos.common.objects;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.components.SizeComponent;
import xyz.gamars.eos.common.objects.items.*;
import xyz.gamars.eos.common.objects.items.apollo.ApolloBowItem;
import xyz.gamars.eos.common.objects.items.coolassstick.CoolAssStickItem;
import xyz.gamars.eos.common.objects.items.poseidon.PoseidonArmorItem;
import xyz.gamars.eos.common.objects.items.poseidon.PoseidonChargeItem;
import xyz.gamars.eos.common.objects.items.poseidon.PoseidonTridentItem;
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

    public static final DeferredHolder<Item, PoseidonChargeItem> POSEIDON_CHARGE = ITEMS.register("poseidon_charge",
            () -> new PoseidonChargeItem(new Item.Properties()));

    public static final DeferredHolder<Item, TyrfingrSwordItem> TYRFINGER_SWORD = ITEMS.register("tyrfingr_sword",
            () -> new TyrfingrSwordItem(Tiers.NETHERITE, new Item.Properties().attributes(TyrfingrSwordItem.createAttributes(Tiers.DIAMOND, 5, -2f))));

    public static final DeferredHolder<Item, WukongsStaffItem> WUKONGS_STAFF = ITEMS.register("wukongs_staff", () -> new WukongsStaffItem(
            new Item.Properties().attributes(WukongsStaffItem.createAttributes())
                    .component(DataComponentsInit.SIZE.value(), new SizeComponent(1))));

    public static final DeferredHolder<Item, GodSlayerItem> GOD_SLAYER = ITEMS.register("god_slayer", () -> new GodSlayerItem(new Item.Properties()));
    public static final DeferredHolder<Item, BigBobItem> BIG_BOB = ITEMS.register("big_bob", () -> new BigBobItem(new Item.Properties().attributes(BigBobItem.createAttributes())));


    public static final DeferredHolder<Item, ApolloBowItem> APOLLO_BOW = ITEMS.register("apollo_bow", () -> new ApolloBowItem(
            new Item.Properties()));

    public static final DeferredHolder<Item, SpawnEggItem> STONE_EGG_SPAWN_EGG = ITEMS.register("stone_egg_spawn_egg",
            () -> new SpawnEggItem(EntityTypeInit.STONE_EGG.get(),
                    FastColor.ABGR32.color(1, 128, 128, 128),
                    FastColor.ABGR32.color(1, 50, 50, 50), new Item.Properties()));

    public static final DeferredHolder<Item, SpawnEggItem> MONKEY_SPAWN_EGG = ITEMS.register("monkey_spawn_egg",
            () -> new SpawnEggItem(EntityTypeInit.MONKEY.get(),
                    FastColor.ABGR32.color(1, 112, 65, 0),
                    FastColor.ABGR32.color(1, 74, 43, 0), new Item.Properties()));

    public static final DeferredHolder<Item, PunchingBagItem> PUNCHING_BAG_SPAWN_EGG = ITEMS.register("punching_bag_spawn_egg",
            () -> new PunchingBagItem(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}

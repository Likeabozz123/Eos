package xyz.gamars.eos.common.objects;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.gamars.eos.Eos;

import java.util.EnumMap;
import java.util.List;

public class ArmorMaterialsInit {

    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(BuiltInRegistries.ARMOR_MATERIAL, Eos.MOD_ID);

    public static final Holder<ArmorMaterial> POSEIDON_MATERIAL = ARMOR_MATERIALS.register("poseidon_material", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.LEGGINGS, 8);
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.BODY, 11);
            }),

            20,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            () -> Ingredient.EMPTY,
            List.of(
                    new ArmorMaterial.Layer(new ResourceLocation(Eos.MOD_ID, "poseidon"))
            ),
            3.0f,
            0.1f
    ));

    public static void register(IEventBus eventBus) {
        ARMOR_MATERIALS.register(eventBus);
    }


}

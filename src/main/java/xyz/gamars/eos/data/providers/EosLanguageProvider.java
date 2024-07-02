package xyz.gamars.eos.data.providers;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.objects.BlockInit;
import xyz.gamars.eos.common.objects.EnchantmentInit;
import xyz.gamars.eos.common.objects.ItemInit;

public class EosLanguageProvider extends LanguageProvider {

    public EosLanguageProvider(PackOutput output) {
        super(output, Eos.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(ItemInit.DEV_ITEM.get(), "Dev Item");
        add(ItemInit.PLUNGER.get(), "Plunger");
        add(ItemInit.POSEIDON_TRIDENT.get(), "Poseidon's Trident");
        add(ItemInit.POSEIDON_HELMET.get(), "Poseidon's Helmet");
        add(ItemInit.POSEIDON_CHESTPLATE.get(), "Poseidon's Chestplate");
        add(ItemInit.POSEIDON_LEGGINGS.get(), "Poseidon's Leggings");
        add(ItemInit.POSEIDON_BOOTS.get(), "Poseidon's Boots");
        add(ItemInit.TYRFINGER_SWORD.get(), "Tyrfinger Sword");

        add(ItemInit.COOL_ASS_STICK.get(), "Cool Ass Stick");
        add(ItemInit.WUKONGS_STAFF.get(), "Wukong's Staff");

        add(BlockInit.DEV_BLOCK.get(), "Dev Block");

        add(BlockInit.RAW_MARBLE.get(), "Raw Marble");
        add(BlockInit.MARBLE_BRICKS.get(), "Marble Bricks");
        add(BlockInit.LARGE_MARBLE_BRICKS.get(), "Large Marble Bricks");
        add(BlockInit.CRACKED_MARBLE_BRICKS.get(), "Cracked Marble Bricks");
        add(BlockInit.CHISELED_MARBLE.get(), "Chiseled Marble");
        add(BlockInit.CHISELED_MARBLE_2.get(), "Chiseled Marble");
        add(BlockInit.MARBLE_PILLAR.get(), "Marble Pillar");
        add(BlockInit.MARBLE_STAIRS.get(), "Marble Stairs");
        add(BlockInit.MARBLE_SLAB.get(), "Marble Slab");
        add(BlockInit.MARBLE_WALL.get(), "Marble Wall");

        add(EnchantmentInit.BANE_OF_PIGS.get(), "Bane of Pigs");
        add(EnchantmentInit.POSEIDON_LUCK.get(), "Poseidon Luck");


        add("curios.identifier.ear", "Ear");

        add("itemGroup." + Eos.MOD_ID + ".eos_tab", "Eos Tab");
    }

    @Override
    public String getName() {
        return "Taking over the world by creating names for our items...";
    }
}

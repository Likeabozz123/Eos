package xyz.gamars.eos.data.providers;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import xyz.gamars.eos.Eos;
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

        add(EnchantmentInit.BANE_OF_PIGS.get(), "Bane of Pigs");
        add(EnchantmentInit.POSEIDON_LUCK.get(), "Poseidon Luck");



        add("itemGroup." + Eos.MOD_ID + ".eos_tab", "Eos Tab");
    }

    @Override
    public String getName() {
        return "Taking over the world by creating names for our items...";
    }
}

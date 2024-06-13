package xyz.gamars.eos.data.providers;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.objects.ItemInit;

public class EosLanguageProvider extends LanguageProvider {

    public EosLanguageProvider(PackOutput output) {
        super(output, Eos.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(ItemInit.DEV_ITEM.get(), "Dev Item");
        add(ItemInit.PLUNGER.get(), "Plunger");
    }

    @Override
    public String getName() {
        return "Taking over the world by creating names for our items...";
    }
}

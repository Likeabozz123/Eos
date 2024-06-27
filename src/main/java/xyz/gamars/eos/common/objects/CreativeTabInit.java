package xyz.gamars.eos.common.objects;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.gamars.eos.Eos;

import java.util.function.Supplier;

public class CreativeTabInit {

    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, Eos.MOD_ID);

    public static final Supplier<CreativeModeTab> EOS_TAB = CREATIVE_MODE_TAB.register("eos_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + Eos.MOD_ID + ".eos_tab"))
                    .icon(() -> new ItemStack(ItemInit.PLUNGER.get()))
                    .displayItems((params, output) -> {

                        ItemInit.ITEMS.getEntries().forEach((item) -> {
                            output.accept(item.get());
                        } );

                    }).build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}

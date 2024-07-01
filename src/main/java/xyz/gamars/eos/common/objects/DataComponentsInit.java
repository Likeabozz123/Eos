package xyz.gamars.eos.common.objects;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.common.components.SizeComponent;

public class DataComponentsInit {

    public static final DeferredRegister.DataComponents DATA_COMPONENTS = DeferredRegister.createDataComponents(Eos.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<SizeComponent>> SIZE = DATA_COMPONENTS.registerComponentType(
            "size",
            builder -> builder
                    .persistent(SizeComponent.BASIC_CODEC)
                    .networkSynchronized(SizeComponent.BASIC_STREAM_CODEC)
    );


    public static void register(IEventBus eventBus) {
        DATA_COMPONENTS.register(eventBus);
    }




}

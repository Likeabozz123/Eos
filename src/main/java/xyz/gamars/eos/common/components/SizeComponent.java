package xyz.gamars.eos.common.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record SizeComponent(int size) {

    public static final Codec<SizeComponent> BASIC_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("size").forGetter(SizeComponent::size)
            ).apply(instance, SizeComponent::new)
    );

    public static final StreamCodec<ByteBuf, SizeComponent> BASIC_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, SizeComponent::size,
            SizeComponent::new
    );


}

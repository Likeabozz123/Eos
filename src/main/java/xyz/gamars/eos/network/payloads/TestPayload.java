package xyz.gamars.eos.network.payloads;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import xyz.gamars.eos.Eos;

public record TestPayload(String message) implements CustomPacketPayload {

    public static final CustomPacketPayload.Type<TestPayload> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, "test_payload"));

    public static final StreamCodec<ByteBuf, TestPayload> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8,
            TestPayload::message,
            TestPayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}

package xyz.gamars.eos.network.payloads;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import xyz.gamars.eos.Eos;

public record PullOutWukongStaffPayload(ItemStack itemStack, String identifier, int index) implements CustomPacketPayload {

    public static final CustomPacketPayload.Type<PullOutWukongStaffPayload> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, "pull_out_wukong_payload"));

    public static final StreamCodec<RegistryFriendlyByteBuf, PullOutWukongStaffPayload> STREAM_CODEC = StreamCodec.composite(
                    ItemStack.OPTIONAL_STREAM_CODEC,
            PullOutWukongStaffPayload::itemStack,
            ByteBufCodecs.STRING_UTF8,
            PullOutWukongStaffPayload::identifier,
            ByteBufCodecs.INT,
            PullOutWukongStaffPayload::index,
            PullOutWukongStaffPayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}

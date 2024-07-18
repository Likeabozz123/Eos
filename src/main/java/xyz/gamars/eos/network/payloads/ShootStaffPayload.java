package xyz.gamars.eos.network.payloads;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import xyz.gamars.eos.Eos;

public record ShootStaffPayload(ItemStack itemStack, float velocity, float inaccuracy) implements CustomPacketPayload {

    public static final CustomPacketPayload.Type<ShootStaffPayload> TYPE =
            new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(Eos.MOD_ID, "shoot_staff_payload"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ShootStaffPayload> STREAM_CODEC = StreamCodec.composite(
            ItemStack.OPTIONAL_STREAM_CODEC,
            ShootStaffPayload::itemStack,
            ByteBufCodecs.FLOAT,
            ShootStaffPayload::velocity,
            ByteBufCodecs.FLOAT,
            ShootStaffPayload::inaccuracy,
            ShootStaffPayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}

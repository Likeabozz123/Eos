package xyz.gamars.eos.network.handlers;

import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.network.payloads.TestPayload;

public class TestPayloadHandler {

    public static class ClientPayloadHandler {

        public static void handleData(TestPayload payload, IPayloadContext context) {

            context.enqueueWork(() -> {
                Eos.LOGGER.info("Received from server: " + payload.message());
            }).exceptionally(e -> {
                context.disconnect(Component.literal(e.getMessage()));
                return null;
            });

        }

    }

    public static class ServerPayloadHandler {

        public static void handleData(TestPayload payload, IPayloadContext context) {

            context.enqueueWork(() -> {
                Eos.LOGGER.info("Received from client: " + payload.message());
            }).exceptionally(e -> {
                context.disconnect(Component.literal(e.getMessage()));
                return null;
            });

        }

    }

}

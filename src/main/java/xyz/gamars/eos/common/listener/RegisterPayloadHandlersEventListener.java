package xyz.gamars.eos.common.listener;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler;
import net.neoforged.neoforge.network.handling.MainThreadPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import xyz.gamars.eos.Eos;
import xyz.gamars.eos.network.handlers.PullOutWukongStaffPayloadHandler;
import xyz.gamars.eos.network.handlers.SpawnEntityPayloadHandler;
import xyz.gamars.eos.network.handlers.TestPayloadHandler;
import xyz.gamars.eos.network.payloads.PullOutWukongStaffPayload;
import xyz.gamars.eos.network.payloads.ShootStaffPayload;
import xyz.gamars.eos.network.payloads.TestPayload;

@EventBusSubscriber(modid = Eos.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class RegisterPayloadHandlersEventListener {

    @SubscribeEvent
    public static void onRegisterPayloadHandlers(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar("1.0");

        registrar.playBidirectional(
                TestPayload.TYPE,
                TestPayload.STREAM_CODEC,
                new DirectionalPayloadHandler<>(
                        TestPayloadHandler.ClientPayloadHandler::handleData,
                        TestPayloadHandler.ServerPayloadHandler::handleData
                )

        );


        registrar.playToServer(
                PullOutWukongStaffPayload.TYPE,
                PullOutWukongStaffPayload.STREAM_CODEC,
                new MainThreadPayloadHandler<>(
                        PullOutWukongStaffPayloadHandler.ServerPayloadHandler::handleData
                )

        );

        registrar.playToServer(
                ShootStaffPayload.TYPE,
                ShootStaffPayload.STREAM_CODEC,
                new MainThreadPayloadHandler<>(
                        SpawnEntityPayloadHandler.ServerPayloadHandler::handleData
                )
        );

    }

}

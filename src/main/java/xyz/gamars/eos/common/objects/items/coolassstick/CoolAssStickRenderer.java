package xyz.gamars.eos.common.objects.items.coolassstick;

import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import xyz.gamars.eos.Eos;

public class CoolAssStickRenderer extends GeoItemRenderer<CoolAssStickItem> {

    public CoolAssStickRenderer() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(Eos.MOD_ID, "cool_ass_stick")));
    }


}

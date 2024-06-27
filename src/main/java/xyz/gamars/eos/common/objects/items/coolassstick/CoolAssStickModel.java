package xyz.gamars.eos.common.objects.items.coolassstick;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.model.GeoModel;
import xyz.gamars.eos.Eos;

public class CoolAssStickModel extends GeoModel<CoolAssStickItem> {


    @Override
    public ResourceLocation getModelResource(CoolAssStickItem animatable) {
        return new ResourceLocation(Eos.MOD_ID, "geo/item/cool_ass_stick.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CoolAssStickItem animatable) {
        return new ResourceLocation(Eos.MOD_ID, "texture/item/cool_ass_stick.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CoolAssStickItem animatable) {
        return null;
    }
}

package net.spok.halfnightskip.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.server.world.SleepManager;
import net.minecraft.util.math.MathHelper;
import net.spok.halfnightskip.config.ModConfigs;



@Mixin(SleepManager.class)
public abstract class SleepManagerMixin {

    @Shadow
    private int total;


    @Inject(method = "getNightSkippingRequirement", at = @At(value = "TAIL"), cancellable = true)       //DON'T TOUCH IT
    private void changingSleepingPercentage(int percentage, CallbackInfoReturnable<Integer> info){


        float estimation = (float) (((float)(this.total * percentage) / 100.0F) * ModConfigs.PERCENTAGE);


        if (ModConfigs.FLOOR) {      //arrondi a l'exces ou pas en fonction de la config du mod
            estimation = MathHelper.floor(estimation);
        }else{
            estimation = MathHelper.ceil(estimation);
        }


        if ((int)(estimation + ModConfigs.PLUS) > this.total){     //the if else is here just so you don't fuck up my mod with bad configuration
            info.setReturnValue(this.total);
        }else{
            info.setReturnValue( Math.max(1, (int)(estimation + ModConfigs.PLUS) ));
        }
        
    } 
    
}

package de.pfannekuchen.killtherng.mixins.redirect;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import de.pfannekuchen.killtherng.KillTheRng;
import de.pfannekuchen.killtherng.utils.WorldRandom;
import net.minecraft.block.BlockDispenser;

@Mixin(BlockDispenser.class)
public class RedirectBlockDispenser {

	@Shadow
	protected Random rand;
	
	@Inject(at = @At("RETURN"), method = "<init>")
	public void hackRandom(CallbackInfo ci) {
		if (!KillTheRng.ISDISABLED) rand = new WorldRandom();
	}
	
}

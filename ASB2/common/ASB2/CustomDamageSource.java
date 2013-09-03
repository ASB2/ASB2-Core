package ASB2;

import net.minecraft.util.DamageSource;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class CustomDamageSource extends DamageSource {

    public CustomDamageSource(String string) {
        super(string);
    }

    public CustomDamageSource setDeathMessage(String deathMessage) {
        
        LanguageRegistry.instance().addStringLocalization("death.attack." + this.damageType, deathMessage);
        return this;
    }

    @Override
    public DamageSource setDamageBypassesArmor() {
        
        return super.setDamageBypassesArmor();
    }

    @Override
    public DamageSource setDamageAllowedInCreativeMode() {
        
        return super.setDamageAllowedInCreativeMode();
    }

    @Override
    public DamageSource setFireDamage() {
        
        return super.setFireDamage();
    }
}

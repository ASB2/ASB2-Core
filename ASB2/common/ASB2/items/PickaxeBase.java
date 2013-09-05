package ASB2.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;

public class PickaxeBase extends ItemPickaxe {

    String iconLocation;
    
    public PickaxeBase(int id, EnumToolMaterial material, String iconLocation) {
        super(id, material);
        
        this.iconLocation = iconLocation;
        this.setUnlocalizedName(iconLocation);
    }

    @Override
    public void registerIcons(IconRegister iconRegister){

        itemIcon = iconRegister.registerIcon(iconLocation);
    }
}

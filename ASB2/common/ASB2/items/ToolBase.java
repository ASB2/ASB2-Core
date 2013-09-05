package ASB2.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemTool;

public class ToolBase extends ItemTool {

    String iconLocation;
    protected float speed = 1;
    
    public ToolBase(int id, float speed, EnumToolMaterial material, Block[] validBlocks, String iconLocation) {
        super(id, speed, material, validBlocks);

        this.iconLocation = iconLocation;
        this.setUnlocalizedName(iconLocation);
        this.speed = speed;
    }

    @Override
    public void registerIcons(IconRegister iconRegister){

        itemIcon = iconRegister.registerIcon(iconLocation);
    }
}

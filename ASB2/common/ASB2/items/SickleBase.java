package ASB2.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;

public class SickleBase extends ToolBase {

    public SickleBase(int id, float speed, EnumToolMaterial material, String iconLocation) {
        super(id, speed, material, new Block[0], iconLocation);
    }

    public float getStrVsBlock(ItemStack itemStack, Block block) {

        if(block.blockMaterial == Material.leaves || block.blockMaterial == Material.plants) {

            return this.speed;
        }
        return 1.0F;
    }
}

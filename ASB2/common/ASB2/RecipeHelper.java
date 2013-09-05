package ASB2;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeHelper {

    public static void addStorageBlock9(ItemStack block, ItemStack item) {

        block.stackSize = 1;
        item.stackSize = 1;
        
        GameRegistry.addRecipe(block, new Object[] {
                "III", 
                "III", 
                "III",            
                'I', item });        
        item.stackSize = 9;
        GameRegistry.addShapelessRecipe(item, block);
    }
}

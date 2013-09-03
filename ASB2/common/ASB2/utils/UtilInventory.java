package ASB2.utils;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class UtilInventory {

    public static boolean addItemStackToInventoryAndSpawnExcess(World world, IInventory destination, ItemStack itemStack, int x, int y, int z) {

        if (!UtilInventory.addItemStackToInventory(destination, itemStack, true)) {

            UtilBlock.spawnItemStackEntity(world, x, y, z, itemStack, 1);
        }
        return true;
    }

    public static boolean addItemStackToInventory(IInventory destination, ItemStack itemStack, boolean doWork) {

        if (itemStack != null) {

            for (int i = 0; i < destination.getSizeInventory(); i++) {

                if(UtilInventory.addItemStackToSlot(destination, itemStack, i, doWork)) {

                    return true;
                }
            }
        }
        return false;
    }

    public static boolean addItemStackToSlot(IInventory destination, ItemStack itemStack, int slot, boolean doWork) {

        if(destination != null && itemStack != null) {

            ItemStack stack = destination.getStackInSlot(slot);

            if (stack == null) {

                if(doWork)
                    destination.setInventorySlotContents(slot, itemStack);

                return true;
            } 
            else {

                if(stack.isItemEqual(itemStack)) {

                    if(doWork) {
                        
                        return UtilInventory.increaseSlotContents(destination, slot, itemStack.stackSize);
                    }
                    else {
                        
                        if(stack.stackSize + itemStack.stackSize <= destination.getInventoryStackLimit()) {
                            
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean removeItemStackFromInventory(IInventory destination, ItemStack itemStack, int amount, boolean doWork) {

        if (itemStack != null) {

            for (int i = 0; i < destination.getSizeInventory(); i++) {

                if(UtilInventory.removeItemStackFromSlot(destination, itemStack, i, amount, doWork)) {

                    return true;
                }
            }
        }
        return false;
    }

    public static boolean removeItemStackFromSlot(IInventory source, ItemStack itemStack, int slot, int amount, boolean doWork) {

        if(source != null && itemStack != null) {

            ItemStack stack = source.getStackInSlot(slot);

            if (stack == null) {
                
                return false;
            } 
            else {

                if(stack.isItemEqual(itemStack)) {

                    if(doWork) {
                        
                        return UtilInventory.decreaseSlotContentsBoolean(source, slot, amount);
                    }
                    else {
                        
                        if(stack.stackSize - itemStack.stackSize >= 0) {
                            
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean hasItemStack(IInventory inventory, ItemStack stack) {

        if (stack != null) {

            for (int i = 0; i < inventory.getInventoryStackLimit(); i++) {

                if (inventory.getStackInSlot(i) != null) {

                    if ((inventory.getStackInSlot(i).isItemEqual(stack))) {

                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean consumeItemStack(IInventory inventory, ItemStack itemStack, int amount) {

        if (itemStack != null) {

            for (int i = 0; i < inventory.getSizeInventory(); i++) {

                ItemStack slotStack = inventory.getStackInSlot(i).copy();

                if (slotStack != null) {

                    if (slotStack.isItemEqual(itemStack)) {

                        return UtilInventory.decreaseSlotContentsBoolean(inventory, i, amount);
                    }
                }
            }
        }
        return false;
    }

    public static boolean moveEntireInventory(IInventory source, IInventory destination) {

        boolean itWorked = false;

        for (int sourceSlot = 0; sourceSlot < source.getSizeInventory(); sourceSlot++) {

            if (source.getStackInSlot(sourceSlot) != null) {

                ItemStack sourceStack = source.getStackInSlot(sourceSlot).copy();
                
                for (int destinationSlot = 0; destinationSlot < destination.getSizeInventory(); destinationSlot++) {

                    if(UtilInventory.addItemStackToSlot(destination, sourceStack, destinationSlot, false) && UtilInventory.removeItemStackFromInventory(source, sourceStack, sourceStack.stackSize, false)) {

                        itWorked = UtilInventory.addItemStackToSlot(destination, sourceStack, destinationSlot, true) && UtilInventory.removeItemStackFromInventory(source, sourceStack, sourceStack.stackSize, true);
                    }
                }
            }
        }
        return itWorked;
    }

    public static boolean decreaseSlotContentsBoolean(IInventory inventory, int slot, int amount) {

        return UtilInventory.decreaseSlotContents(inventory, slot, amount) != null;
    }

    public static ItemStack decreaseSlotContents(IInventory inventory, int slot, int amount) {

        ItemStack stack = inventory.getStackInSlot(slot);

        if (stack != null) {

            int toLeave = stack.stackSize - amount;

            ItemStack temp = stack.copy();
            temp.stackSize = amount;

            ItemStack stackLeft = stack.copy();
            stackLeft.stackSize = toLeave;

            inventory.setInventorySlotContents(slot, stackLeft);

            if(stackLeft.stackSize <= 0)
                inventory.setInventorySlotContents(slot, null);

            return temp;
        }
        return null;
    }

    public static boolean increaseSlotContents(IInventory inventory, int slot, int amount) {

        ItemStack stack = inventory.getStackInSlot(slot);

        if (stack != null) {

            int newAmount = stack.stackSize + amount;

            if(newAmount <= inventory.getInventoryStackLimit() && newAmount <= stack.getMaxStackSize()) {

                ItemStack temp = stack.copy();
                temp.stackSize = newAmount;

                inventory.setInventorySlotContents(slot, temp);
                return true;
            }
        }
        return false;
    }
}

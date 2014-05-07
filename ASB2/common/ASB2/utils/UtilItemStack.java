package ASB2.utils;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class UtilItemStack {
    
    public static boolean damageItem(EntityLivingBase entity, ItemStack item, int damage) {
        
        if (!item.isItemStackDamageable()) return false;
        
        if (entity instanceof EntityPlayer && ((EntityPlayer) entity).capabilities.isCreativeMode) return true;
        
        if (item.getMaxDamage() - item.getItemDamage() >= damage) {
            
            item.setItemDamage(item.getItemDamage() + damage);
            return true;
        }
        else {
            
            if (item.getMaxDamage() - item.getItemDamage() == 0) {
                
                --item.stackSize;
                
                if (item.stackSize < 0) {
                    
                    item.stackSize = 0;
                }
            }
        }
        return false;
    }
    
    public static NBTTagCompound getTAGfromItemstack(ItemStack itemStack) {
        
        if (itemStack != null) {
            
            NBTTagCompound tag = itemStack.getTagCompound();
            
            if (tag == null) {
                
                tag = new NBTTagCompound();
                itemStack.setTagCompound(tag);
            }
            return tag;
        }
        return null;
    }
    
    public static void setNBTTagInt(ItemStack itemStack, String tag, int value) {
        
        NBTTagCompound nbtTagCompound = UtilItemStack.getTAGfromItemstack(itemStack);
        nbtTagCompound.setInteger(tag, value);
    }
    
    public static int getNBTTagInt(ItemStack itemStack, String tag) {
        
        NBTTagCompound nbtTagCompound = UtilItemStack.getTAGfromItemstack(itemStack);
        
        if (nbtTagCompound != null) {
            
            return nbtTagCompound.getInteger(tag);
        }
        return 0;
    }
    
    public static void setNBTTagDouble(ItemStack itemStack, String tag, double value) {
        
        NBTTagCompound nbtTagCompound = UtilItemStack.getTAGfromItemstack(itemStack);
        nbtTagCompound.setDouble(tag, value);
    }
    
    public static double getNBTTagDouble(ItemStack itemStack, String tag) {
        
        NBTTagCompound nbtTagCompound = UtilItemStack.getTAGfromItemstack(itemStack);
        
        if (nbtTagCompound != null) {
            
            return nbtTagCompound.getDouble(tag);
        }
        return 0;
    }
    
    public static void setNBTTagFloat(ItemStack itemStack, String tag, float value) {
        
        NBTTagCompound nbtTagCompound = UtilItemStack.getTAGfromItemstack(itemStack);
        nbtTagCompound.setFloat(tag, value);
    }
    
    public static float getNBTTagFloat(ItemStack itemStack, String tag) {
        
        NBTTagCompound nbtTagCompound = UtilItemStack.getTAGfromItemstack(itemStack);
        
        if (nbtTagCompound != null) {
            
            return nbtTagCompound.getFloat(tag);
        }
        return 0;
    }
    
    public static void setNBTTagBoolean(ItemStack itemStack, String tag, boolean value) {
        
        NBTTagCompound nbtTagCompound = UtilItemStack.getTAGfromItemstack(itemStack);
        nbtTagCompound.setBoolean(tag, value);
    }
    
    public static boolean getNBTTagBoolean(ItemStack itemStack, String tag) {
        
        NBTTagCompound nbtTagCompound = UtilItemStack.getTAGfromItemstack(itemStack);
        
        if (nbtTagCompound != null) {
            
            return nbtTagCompound.getBoolean(tag);
        }
        return false;
    }
    
    public static void setNBTTagString(ItemStack itemStack, String tag, String value) {
        
        NBTTagCompound nbtTagCompound = UtilItemStack.getTAGfromItemstack(itemStack);
        nbtTagCompound.setString(tag, value);
    }
    
    public static String getNBTTagString(ItemStack itemStack, String tag) {
        
        NBTTagCompound nbtTagCompound = UtilItemStack.getTAGfromItemstack(itemStack);
        
        if (nbtTagCompound != null) {
            
            return nbtTagCompound.getString(tag);
        }
        return "";
    }
}

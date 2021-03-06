package ASB2.vector;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class Vector3 implements Cloneable {
    
    public double x;
    public double y;
    public double z;
    
    public Vector3() {
        this(0, 0, 0);
    }
    
    public Vector3(int[] coords) {
        
        this.x = coords[0];
        this.y = coords[1];
        this.z = coords[2];
    }
    
    public Vector3(double x, double y, double z) {
        
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Vector3(Entity entity) {
        
        this.x = entity.posX;
        this.y = entity.posY;
        this.z = entity.posZ;
    }
    
    public Vector3(TileEntity tileEntity) {
        
        this.x = tileEntity.xCoord + .5;
        this.y = tileEntity.yCoord + .5;
        this.z = tileEntity.zCoord + .5;
    }
    
    public Vector3(Vec3 vec3) {
        
        this.x = vec3.xCoord;
        this.y = vec3.yCoord;
        this.z = vec3.zCoord;
    }
    
    public Vector3(MovingObjectPosition mop) {
        
        this.x = mop.blockX;
        this.y = mop.blockY;
        this.z = mop.blockZ;
    }
    
    public Vector3(ChunkCoordinates chunkCoordinates) {
        
        this.x = chunkCoordinates.posX;
        this.y = chunkCoordinates.posY;
        this.z = chunkCoordinates.posZ;
    }
    
    public Vector3(ForgeDirection direction) {
        
        this.x = direction.offsetX;
        this.y = direction.offsetY;
        this.z = direction.offsetZ;
    }
    
    public Vector3(Vector3 vector) {
        
        this.x = vector.x;
        this.y = vector.y;
        this.z = vector.z;
    }
    
    /**
     * Returns the coordinates as integers, ideal for block placement.
     */
    public int intX() {
        
        return (int) Math.floor(this.x);
    }
    
    public int intY() {
        
        return (int) Math.floor(this.y);
    }
    
    public int intZ() {
        
        return (int) Math.floor(this.z);
    }
    
    /**
     * Makes a new copy of this Vector. Prevents variable referencing problems.
     */
    @Override
    public Vector3 clone() {
        
        return new Vector3(this.x, this.y, this.z);
    }
    
    /**
     * Easy block access functions.
     * 
     * @param world
     * @return
     */
    public Block getBlock(IBlockAccess world) {
        
        return world.getBlock(this.intX(), this.intY(), this.intZ());
    }
    
    public Block getBlock(World world) {
        
        if (world.blockExists(this.intX(), this.intY(), this.intZ())) {
            
            return world.getBlock(this.intX(), this.intY(), this.intZ());
        }
        return null;
    }
    
    public int getBlockMetadata(IBlockAccess world) {
        
        return world.getBlockMetadata(this.intX(), this.intY(), this.intZ());
    }
    
    public TileEntity getTileEntity(IBlockAccess world) {
        
        return world.getTileEntity(this.intX(), this.intY(), this.intZ());
    }
    
    public TileEntity getTileEntity(World world) {
        
        if (world.blockExists(this.intX(), this.intY(), this.intZ())) {
            
            return world.getTileEntity(this.intX(), this.intY(), this.intZ());
        }
        else
            return null;
    }
    
    public Material getBlockMaterial(IBlockAccess world) {
        
        return world.getBlock(this.intX(), this.intY(), this.intZ()).getMaterial();
    }
    
    public Material getBlockMaterial(World world) {
        
        if (world.blockExists(this.intX(), this.intY(), this.intZ())) {
            
            return world.getBlock(this.intX(), this.intY(), this.intZ()).getMaterial();
        }
        else
            return null;
    }
    
    public boolean setBlock(World world, Block id, int metadata, int notify) {
        
        return world.setBlock(this.intX(), this.intY(), this.intZ(), id, metadata, notify);
    }
    
    public boolean setBlock(World world, Block id, int metadata) {
        
        return this.setBlock(world, id, metadata, 3);
    }
    
    public boolean setBlock(World world, Block id) {
        
        return this.setBlock(world, id, 0);
    }
    
    /**
     * Converts this Vector3 into a Vector2 by dropping the Y axis.
     */
    public Vector2 toVector2() {
        
        return new Vector2(this.x, this.z);
    }
    
    /**
     * Converts this vector three into a Minecraft Vec3 object
     */
    public Vec3 toVec3() {
        
        return Vec3.createVectorHelper(this.x, this.y, this.z);
    }
    
    public double getMagnitude() {
        
        return Math.sqrt(this.getMagnitudeSquared());
    }
    
    public double getMagnitudeSquared() {
        
        return x * x + y * y + z * z;
    }
    
    public Vector3 normalize() {
        
        double d = getMagnitude();
        
        if (d != 0) {
            
            multiply(1 / d);
        }
        return this;
    }
    
    /**
     * Gets the distance between two vectors
     * 
     * @return The distance
     */
    public static double distance(Vector3 par1, Vector3 par2) {
        
        double var2 = par1.x - par2.x;
        double var4 = par1.y - par2.y;
        double var6 = par1.z - par2.z;
        return MathHelper.sqrt_double(var2 * var2 + var4 * var4 + var6 * var6);
    }
    
    public double distanceTo(Vector3 vector3) {
        
        double var2 = vector3.x - this.x;
        double var4 = vector3.y - this.y;
        double var6 = vector3.z - this.z;
        return MathHelper.sqrt_double(var2 * var2 + var4 * var4 + var6 * var6);
    }
    
    public Vector3 distance(Vector3 vector) {
        
        return new Vector3(vector.x - this.x, vector.y - this.y, vector.z - this.z);
    }
    
    public Vector3 add(Vector3 par1) {
        
        this.x += par1.x;
        this.y += par1.y;
        this.z += par1.z;
        return this;
    }
    
    public Vector3 add(double par1) {
        
        this.x += par1;
        this.y += par1;
        this.z += par1;
        return this;
    }
    
    public Vector3 add(double x, double y, double z) {
        
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }
    
    public Vector3 add(ForgeDirection direction) {
        
        this.x += direction.offsetX;
        this.y += direction.offsetY;
        this.z += direction.offsetZ;
        return this;
    }
    
    public Vector3 add(ForgeDirection side, double amount) {
        
        switch (side) {
        
            case DOWN:
                this.y -= amount;
                break;
            case UP:
                this.y += amount;
                break;
            case NORTH:
                this.z -= amount;
                break;
            case SOUTH:
                this.z += amount;
                break;
            case WEST:
                this.x -= amount;
                break;
            case EAST:
                this.x += amount;
                break;
            default:
                break;
        }
        return this;
    }
    
    public Vector3 subtract(Vector3 amount) {
        
        this.x -= amount.x;
        this.y -= amount.y;
        this.z -= amount.z;
        return this;
    }
    
    /**
     * Multiplies the vector by negative one.
     */
    public Vector3 invert() {
        
        this.multiply(-1);
        return this;
    }
    
    public Vector3 multiply(double amount) {
        
        this.x *= amount;
        this.y *= amount;
        this.z *= amount;
        return this;
    }
    
    public Vector3 multiply(Vector3 vec) {
        
        this.x *= vec.x;
        this.y *= vec.y;
        this.z *= vec.z;
        return this;
    }
    
    public static Vector3 subtract(Vector3 vec1, Vector3 vec2) {
        
        return new Vector3(vec1.x - vec2.x, vec1.y - vec2.y, vec1.z - vec2.z);
    }
    
    public static Vector3 add(Vector3 par1, Vector3 par2) {
        
        return new Vector3(par1.x + par2.x, par1.y + par2.y, par1.z + par2.z);
    }
    
    public static Vector3 add(Vector3 par1, double par2) {
        
        return new Vector3(par1.x + par2, par1.y + par2, par1.z + par2);
    }
    
    public static Vector3 multiply(Vector3 vec1, Vector3 vec2) {
        
        return new Vector3(vec1.x * vec2.x, vec1.y * vec2.y, vec1.z * vec2.z);
    }
    
    public static Vector3 multiply(Vector3 vec1, double vec2) {
        
        return new Vector3(vec1.x * vec2, vec1.y * vec2, vec1.z * vec2);
    }
    
    public Vector3 round() {
        
        return new Vector3(Math.round(this.x), Math.round(this.y), Math.round(this.z));
    }
    
    public Vector3 ceil() {
        
        return new Vector3(Math.ceil(this.x), Math.ceil(this.y), Math.ceil(this.z));
    }
    
    public Vector3 floor() {
        
        return new Vector3(Math.floor(this.x), Math.floor(this.y), Math.floor(this.z));
    }
    
    /**
     * Gets all entities inside of this position in block space.
     */
    @SuppressWarnings("unchecked")
    public List<Entity> getEntitiesWithin(World worldObj, Class<? extends Entity> entityClass) {
        
        return worldObj.getEntitiesWithinAABB(entityClass, AxisAlignedBB.getBoundingBox(this.intX(), this.intY(), this.intZ(), this.intX() + 1, this.intY() + 1, this.intZ() + 1));
    }
    
    public Vector3 modifyPositionFromSide(ForgeDirection side) {
        
        this.add(side, 1);
        return this;
    }
    
    /**
     * Loads a Vector3 from an NBT compound.
     */
    public static Vector3 readFromNBT(NBTTagCompound tag) {
        
        Vector3 tempVector = new Vector3();
        tempVector.x = tag.getDouble("x");
        tempVector.y = tag.getDouble("y");
        tempVector.z = tag.getDouble("z");
        return tempVector;
    }
    
    /**
     * Saves this Vector3 to disk
     * 
     * @param prefix
     *            - The prefix of this save. Use some unique string.
     * @param tag
     *            - The NBT compound object to save the data in
     */
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        
        tag.setDouble("x", this.x);
        tag.setDouble("y", this.y);
        tag.setDouble("z", this.z);
        return tag;
    }
    
    @Override
    public int hashCode() {
        
        return ("X:" + this.x + "Y:" + this.y + "Z:" + this.z).hashCode();
    }
    
    @Override
    public boolean equals(Object object) {
        
        if (object instanceof Vector3) {
            
            Vector3 vector3 = (Vector3) object;
            return this.x == vector3.x && this.y == vector3.y && this.z == vector3.z;
        }
        return false;
    }
    
    public boolean intEquals(Vector3 vec) {
        return vec != null ? (this.intX() == vec.intX() && this.intY() == vec.intY() && this.intZ() == vec.intZ()) : false;
    }
    
    public boolean intEquals(TileEntity vec) {
        return vec != null ? (this.intX() == vec.xCoord && this.intY() == vec.yCoord && this.intZ() == vec.zCoord) : false;
    }
    
    @Override
    public String toString() {
        
        return "Vector3 [ X: " + this.x + ", Y: " + this.y + ", Z: " + this.z + "]";
    }
}
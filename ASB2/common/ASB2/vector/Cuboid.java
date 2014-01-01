package ASB2.vector;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.nbt.NBTTagCompound;

public class Cuboid implements ICuboidIterator {
    
    boolean is3D = true;
    int xSize, ySize, zSize;
    boolean xNeg, yNeg, zNeg;
    Vector3 corner;
    Set<Vector3> composingBlocks = new HashSet<Vector3>();
    
    public Cuboid(Vector3 firstCorner, Vector3 opositeCorner) {
        
        corner = firstCorner;
        Vector3 subsracted = firstCorner.clone().distance(opositeCorner);
        
        xSize = subsracted.intX();
        if (xSize < 0) {
            xNeg = true;
            xSize = Math.abs(xSize);
        }
        
        ySize = subsracted.intY();
        if (ySize < 0) {
            yNeg = true;
            ySize = Math.abs(ySize);
        }
        
        zSize = subsracted.intZ();
        if (zSize < 0) {
            zNeg = true;
            zSize = Math.abs(zSize);
        }
        
        if (xSize == 0 || ySize == 0 || zSize == 0) {
            is3D = false;
        }
    }
    
    public Cuboid(Vector3 firstCorner, int relativeXSize, int relativeYSize, int relativeZSize) {
        this(firstCorner, firstCorner.clone().add(relativeXSize, relativeYSize, relativeZSize));
    }
    
    public Cuboid(Cuboid cuboid) {
        this(cuboid.getCore(), cuboid.getOppositeCore());
    }
    
    public int getXSize() {
        
        return xSize;
    }
    
    public int getYSize() {
        
        return ySize;
    }
    
    public int getZSize() {
        
        return zSize;
    }
    
    public int getRelativeXSize() {
        
        return xNeg ? this.getXSize() * -1 : this.getXSize();
    }
    
    public int getRelativeYSize() {
        
        return yNeg ? this.getYSize() * -1 : this.getYSize();
    }
    
    public int getRelativeZSize() {
        
        return zNeg ? this.getZSize() * -1 : this.getZSize();
    }
    
    public boolean getIs3D() {
        
        return is3D;
    }
    
    public Vector3 getCore() {
        
        return corner.clone();
    }
    
    public Vector3 getOppositeCore() {
        
        return corner.clone().add(this.getRelativeXSize(), this.getRelativeYSize(), this.getRelativeZSize());
    }
    
    /*
     * ASB2 shouldn't touch this method. It is fine how it is;
     */
    public boolean iterate(ICuboidIterator iterator, Object... providedInfo) {
        
        for (int x = 0; x <= this.xSize; x++) {
            
            for (int y = 0; y <= this.ySize; y++) {
                
                for (int z = 0; z <= this.zSize; z++) {
                    
                    if (!iterator.iterate(this.corner.clone().add(new Vector3(xNeg ? x * -1 : x, yNeg ? y * -1 : y, zNeg ? z * -1 : z)), providedInfo)) {
                        
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public Set<Vector3> getComposingBlock() {
        
        if (composingBlocks.isEmpty()) {
            
            this.iterate(this, 0);
        }
        return composingBlocks;
    }
    
    public Set<Vector3> getCornersBlocks() {
        
        Set<Vector3> corners = new HashSet<Vector3>();
        
        corners.add(this.getCore());
        corners.add(this.getOppositeCore());
        
        corners.add(this.getCore().add(getRelativeXSize(), 0, 0));
        corners.add(this.getCore().add(getRelativeXSize(), getRelativeYSize(), 0));
        corners.add(this.getCore().add(getRelativeXSize(), 0, getRelativeZSize()));
        corners.add(this.getCore().add(0, getRelativeYSize(), 0));
        corners.add(this.getCore().add(0, getRelativeYSize(), getRelativeZSize()));
        corners.add(this.getCore().add(0, 0, getRelativeZSize()));
        return corners;
    }
    
    public Set<Vector3> getBlocksAtLevel(int level) {
        
        Set<Vector3> blocks = new HashSet<Vector3>();
        
        if (this.ySize <= level) {
            
            for (int x = 0; x <= this.xSize; x++) {
                
                for (int z = 0; z <= this.zSize; z++) {
                    
                    blocks.add(this.getCore().add(new Vector3(xNeg ? x * -1 : x, yNeg ? ySize * -1 : ySize, zNeg ? z * -1 : z)));
                }
            }
        }
        return blocks;
    }
    
    @Override
    public boolean iterate(Vector3 vector, Object... providedInfo) {
        
        if ((int) providedInfo[0] == 0) {
            composingBlocks.add(vector);
        }
        return true;
    }
    
    public Cuboid clone() {
        return new Cuboid(this);
    }
    
    public boolean contains(Vector3 vector) {
        
        return this.getComposingBlock().contains(vector);
    }
    
    @Override
    public String toString() {
        
        return "Cuboid XSize: " + this.xSize + ", YSize: " + this.ySize + ", ZSize: " + this.zSize;
    }
    
    public NBTTagCompound save(NBTTagCompound tag) {
        
        tag.setCompoundTag("coreVector", this.getCore().writeToNBT(new NBTTagCompound()));
        tag.setCompoundTag("coreOpposingVector", this.getOppositeCore().writeToNBT(new NBTTagCompound()));
        return tag;
    }
    
    public static Cuboid load(NBTTagCompound tag) {
        
        return new Cuboid(Vector3.readFromNBT(tag.getCompoundTag("coreVector")), Vector3.readFromNBT(tag.getCompoundTag("coreOpposingVector")));
    }
}

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
        Vector3 subsracted = firstCorner.clone().subtract(opositeCorner);
        
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
        
        return xNeg ? xSize * -1 : xSize;
    }
    
    public int getRelativeYSize() {
        
        return yNeg ? ySize * -1 : ySize;
    }
    
    public int getRelativeZSize() {
        
        return zNeg ? zSize * -1 : zSize;
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
        
        composingBlocks.clear();
        
        return this.iterate(this, (Object) null) ? composingBlocks : null;
    }
    
    @Override
    public boolean iterate(Vector3 vector, Object... providedInfo) {
        
        composingBlocks.add(vector);
        return true;
    }
    
    public Cuboid clone() {
        return new Cuboid(this);
    }
    
    public NBTTagCompound save(NBTTagCompound tag) {
        
        tag.setCompoundTag("coreVector", this.getCore().writeToNBT(tag));
        tag.setCompoundTag("coreOpposingVector", this.getOppositeCore().writeToNBT(tag));
        return tag;
    }
    
    public static Cuboid load(NBTTagCompound tag) {
        
        return new Cuboid(Vector3.readFromNBT(tag.getCompoundTag("coreVector")), Vector3.readFromNBT(tag.getCompoundTag("coreOpposingVector")));
    }
}

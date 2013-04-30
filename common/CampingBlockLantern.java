package Connor_13_Camping.common;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class CampingBlockLantern extends BlockContainer
{
	private Class TestEntityClass;

	protected CampingBlockLantern(int i,Class tClass)
		{
		  super(i,Material.rock);
		  TestEntityClass = tClass;
	      float f = 0F;
	      setBlockBounds(0.3125F, 0.0F, 0.3125F, 0.6875F, 0.5625F, 0.6875F);
		}
   
    public TileEntity getBlockEntity()
    {
            try{
                    return (TileEntity)TestEntityClass.newInstance();
            }
            catch(Exception exception){
                    throw new RuntimeException(exception);
            }
    }
    
    public int idDropped(int i, Random random, int j)
    {
        return CampingMod.lanternIcon.itemID;
    }
    
    public int quanityDropped(Random random)
    {
    	  return 1;
    }
    
    public int getRenderType(){
		return -1;
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
    }

	public TileEntity createNewTileEntity(World world) 
	{
		return new CampingTileEntityLantern();
	}

}

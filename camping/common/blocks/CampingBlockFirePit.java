package Connor_13_Camping.camping.common.blocks;

import java.util.Random;

import Connor_13_Camping.camping.common.CampingMod;
import Connor_13_Camping.camping.common.tile_entities.CampingTileEntityFirePit;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class CampingBlockFirePit extends BlockContainer
{
	private Class TestEntityClass;

	public CampingBlockFirePit(int i,Class tClass)
		{
		  super(i,Material.rock);
		  TestEntityClass = tClass;
	      float f = 0F;
	      //Block Bounds
	      setBlockBounds(0F, 0F, 0F, 1F, .25F, 1F);
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
    //Spawn Particle
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
    	if (par5EntityPlayer.getCurrentEquippedItem() != null && par5EntityPlayer.getCurrentEquippedItem().itemID == Item.flintAndSteel.itemID)
    	{
    		this.randomDisplayTick(par1World, par2, par3, par4, null);
    		return true;
    	}
    	if (par5EntityPlayer.getCurrentEquippedItem() != null && par5EntityPlayer.getCurrentEquippedItem().itemID == Item.bucketWater.itemID)
    	{
    		return false;
    	}
    	else
    	{
    		return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
    	}
    }
    
    public int idDropped(int i, Random random, int j)
    {
        return CampingMod.firepitIcon.itemID;
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

	@Override
	public TileEntity createNewTileEntity(World world) 
	{
		return new CampingTileEntityFirePit();
	}

}


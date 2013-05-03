package Connor_13_Camping.camping.common.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import Connor_13_Camping.camping.common.CampingMod;
import Connor_13_Camping.camping.common.tile_entities.CampingTileEntityFirePit;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.world.World;

public class CampingBlockFirePit extends BlockContainer
{
	private Class TestEntityClass;

	public CampingBlockFirePit(int i,Class tClass)
	{
	  super(i,Material.rock);
	  TestEntityClass = tClass;
      float f = 0F;
      setBlockBounds(0F, 0F, 0F, 1F, .25F, 1F);
      this.setTickRandomly(true);
	}
   
    public TileEntity getBlockEntity()
    {
    	try
    	{
    		return (TileEntity)TestEntityClass.newInstance();
    	}
    	catch(Exception exception)
    	{
    		throw new RuntimeException(exception);
    	}
    } 
    
    private boolean isActive = false;
    
    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if(par5EntityPlayer.getCurrentEquippedItem() != null)
        {
        	if(isActive && par5EntityPlayer.getCurrentEquippedItem().itemID == Item.bucketWater.itemID)
        	{
        		isActive = false;
        		return true;
        	}
        	else if (!isActive && par5EntityPlayer.getCurrentEquippedItem().itemID == Item.flintAndSteel.itemID)
        	{
        		isActive = true;
        		return true;
        	}
        }
        
        return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
    }

    @SideOnly(Side.CLIENT)
    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (isActive)
        {
            float f = (float)par2 + 0.5F;
            float f1 = (float)par3 + 0.0F + par5Random.nextFloat() * 6.0F / 16.0F;
            float f2 = (float)par4 + 0.5F;
            float f3 = 0.52F;
            float f4 = par5Random.nextFloat() * 0.6F - 0.3F;

            par1World.spawnParticle("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("flame", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
    
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


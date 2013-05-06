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
        		this.setLightValue(0F);        		
        		return true;
        	}
        	else if (!isActive && par5EntityPlayer.getCurrentEquippedItem().itemID == Item.flintAndSteel.itemID)
        	{
        		isActive = true;
        		this.setLightValue(.9F);        		
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
            double d0 = (double)((float)par2 + 0.53125F);
            double d1 = (double)((float)par3 + 0.25F);
            double d2 = (double)((float)par4 + 0.53125F);
            
            //Smoke and flame for EXACT center (0.53125)
            par1World.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("flame", d0, d1, d2, 0.0D, 0.0D, 0.0D);
            
            //Offset Z (0.265625)
            //(-)
            par1World.spawnParticle("smoke", d0, d1, d2 - 0.265625, 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("flame", d0, d1, d2 - 0.265625, 0.0D, 0.0D, 0.0D);
            //(+)
            par1World.spawnParticle("smoke", d0, d1, d2 + 0.265625, 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("flame", d0, d1, d2 + 0.265625, 0.0D, 0.0D, 0.0D);
            
            //Offset X (0.265625)
            //(-)
            par1World.spawnParticle("smoke", d0 - 0.265625, d1, d2, 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("flame", d0 - 0.265625, d1, d2, 0.0D, 0.0D, 0.0D);
            //(+)
            par1World.spawnParticle("smoke", d0 + 0.265625, d1, d2, 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("flame", d0 + 0.265625, d1, d2, 0.0D, 0.0D, 0.0D);
            
            //Increase Y
            par1World.spawnParticle("smoke", d0, d1 + 0.25, d2, 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("flame", d0, d1 + 0.25, d2, 0.0D, 0.0D, 0.0D);
            
            par1World.spawnParticle("smoke", d0, d1 + 0.5, d2, 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("flame", d0, d1 + 0.5, d2, 0.0D, 0.0D, 0.0D);
        }
    }
    
    /**
     * Called right before the block is destroyed by a player.  Args: world, x, y, z, metaData
     */
    public void onBlockDestroyedByPlayer(World par1World, int x, int y, int z, int par5) 
    {
    	isActive = false;
    	this.setLightValue(0F);
    }

    public int idDropped(int i, Random random, int j)
    {
        return CampingMod.firepitIcon.itemID;
    }
    
    public int quanityDropped(Random random)
    {
    	  return 1;
    }
    
    public int getRenderType()
    {
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


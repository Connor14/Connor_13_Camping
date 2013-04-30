package Connor_13_Camping.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemBed;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class CampingBlockCabinBlock extends Block
{    
	protected CampingBlockCabinBlock(int par1, boolean par2)
	{
    	super(par1, Material.wood);
	}
	
    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
    	if(par1 == 1 || par1 == 0) //top or bottom
    	{
            return Block.planks.getBlockTextureFromSide(par1);
    	}
    	else
    	{
    		return null;
    	}
    }

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return CampingMod.TentBlock.blockID;
	}

	/**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World par1World, int x, int y, int z, EntityLiving par5EntityLiving, ItemStack par6ItemStack)
    {        

    	//Clears all the area that the cabin will take up BEFORE building
    	//Set airy = -1 for floor.  airy = 0 for no floor
    	for(int airy = 0;airy <= 3;airy++)
    	{
    		for(int airx = -4;airx <= 4;airx++)
    		{
    			for(int airz = -4;airz <= 4; airz++)
    			{    
    				if(airx == 0 && airy == 0 && airz ==0)
    				{
    					airz = airz + 1;
    				}
    				par1World.setBlockToAir(x + airx, y + airy, z + airz);
    			} 		
    		}
    	}
    	
    	int rotation = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        
        //When z increases (E)
        if (rotation == 0)
        {
            par1World.setBlock(x, y + 1, z, Block.cobblestone.blockID, rotation, 3);
        }

        //When x decreases (S)
        if (rotation == 1)
        {
            par1World.setBlock(x, y + 1, z, Block.netherrack.blockID, rotation, 3);
        }
        
        //When z decreases (W)
        if (rotation == 2)
        {
            par1World.setBlock(x, y + 1, z, Block.dirt.blockID, rotation, 3);
        }

        //When x increases (N)
        if (rotation == 3)
        {
        	
            par1World.setBlock(x, y + 1, z, Block.glowStone.blockID, rotation, 3);

        	//The Cabin is a 9 x 9 x 5 structure with a 7 x 7 x 3 interior
        	
        	//FLOOR PLACEMENT
        	/**
            int flrx = -4;
        	int flrz = 0;
        	for(flrx = -4; flrx <= 4; flrx++)
        	{
        		for(flrz = -4;flrz <= 4; flrz++)
        		{
                	par1World.setBlock(x + flrx, y - 1, z + flrz, Block.planks.blockID, rotation, 3);
        		}
        	}
        	*/
        	
        	//WALL PLACEMENT
        	int wallx;
        	int wallz;
        	int wally;
        	int wlongz;
        	int wshortx;        	
        	for(wally = 0; wally <=2; wally++)
        	{
        		//Longer Walls (front/back)
        		wallx = -4;
        		while(wallx <= 4)
        		{
        			for(wlongz = -4; wlongz <= 4; wlongz++)
        			{
        	        	par1World.setBlock(x + wallx, y + wally, z + wlongz, Block.brick.blockID, rotation, 3);
        			}
        			wallx = wallx + 8;
        		}
        		//Shorter Walls (left/right)
        		wallz = -4;
        		while(wallz <= 4)
        		{
        			for(wshortx = -3; wshortx <= 3; wshortx++)
        			{
        	        	par1World.setBlock(x + wshortx, y + wally, z + wallz, Block.stone.blockID, rotation, 3);
        			}
        			wallz = wallz + 8;
        		}
        	}
        	
        	//Roof PLACEMENT
        	int roofx;
        	int roofz;
        	for(roofx = -4; roofx <= 4; roofx++)
        	{
        		for(roofz = -4;roofz <= 4; roofz++)
        		{
                	par1World.setBlock(x + roofx, y + 3, z + roofz, Block.planks.blockID, rotation, 3);
        		}
        	}
        	
        	//Furnishing Placement
        	//DOOR
			par1World.setBlockToAir(x - 4, y, z);
			par1World.setBlockToAir(x - 4, y + 1, z);
        	ItemDoor.placeDoorBlock(par1World, x - 4, y, z, rotation, doorWood);
        	
        	par1World.setBlock(x, y, z - 1, Block.bed.blockID, rotation, 3);

        	//
        }
    }
    /**
     * Called right before the block is destroyed by a player.  Args: world, x, y, z, metaData
     */
    public void onBlockDestroyedByPlayer(World par1World, int x, int y, int z, int par5) 
    {
    	//Removes the entire cabin and floor
    	//Set deletey = -1 for removing floor.  deletey = 0 for no floor
    	for(int deletey = 0;deletey <= 3;deletey++)
    	{
    		for(int deletex = -4;deletex <= 4;deletex++)
    		{
    			for(int deletez = -4;deletez <= 4; deletez++)
    			{    				
    				par1World.setBlockToAir(x + deletex, y + deletey, z + deletez);
    			} 		
    		}
    	}
    }
}

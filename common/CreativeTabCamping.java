package Connor_13_Camping.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabCamping extends CreativeTabs 
{
	public CreativeTabCamping(String label) 
	{
	    super(label);
	}
	
	@Override
	public ItemStack getIconItemStack() 
	{
	    return new ItemStack(CampingMod.TentPlacer);
	}
}

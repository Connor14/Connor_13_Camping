package Connor_13_Camping.common;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod(modid = "connor_Camping", name = "Camping", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

//To do
	//register textures
	//register entities
//Matt's Ideas
	//Stain Glass (with disign)
	//Throne
	//Armour
	//Bowls with Flames
	//Shields
//Seprate Mod
	//Cooking Mod
		//Peppers
		//Spices
		//New Food
		//Drinks
public class CampingMod 
{
	
	@SidedProxy(clientSide = "Connor_13_Camping.client.ClientProxyConnor_13_Camping", serverSide = "Connor_13_Camping.common.CommonProxyConnor_13_Camping")
	public static CommonProxyConnor_13_Camping proxy;
	
	public static CreativeTabs Camping = new CreativeTabCamping("Camping");

	public static Item TentPlacer;
	public static Block TentBlock;

	@Init
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();
		
		LanguageRegistry.instance().addStringLocalization("itemGroup.Camping", "en_US", "Camping");

		TentPlacer = new CampingItemTentPlacer(251).setUnlocalizedName("tentplacer").setCreativeTab(CampingMod.Camping);//add in the rest
		TentBlock = new CampingBlockCabinBlock(252, true).setHardness(3.0F).setResistance(10.0F).setUnlocalizedName("tentblock").setCreativeTab(CampingMod.Camping);//add in the rest
		
		LanguageRegistry.addName(TentPlacer, "Tent Placer");	
		LanguageRegistry.addName(TentBlock, "Tent Block");
		
		GameRegistry.registerBlock(TentBlock);
		
		GameRegistry.addRecipe(new ItemStack(TentPlacer, 1), new Object[]
		{
			" X ", " X ", " X ", 'X', Block.pumpkin
		});
		
		GameRegistry.addRecipe(new ItemStack(TentBlock, 1), new Object[]
		{
			" X ", " X ", " X ", 'X', Block.dirt
		});
	}
}

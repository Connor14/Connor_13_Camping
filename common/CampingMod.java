package Connor_13_Camping.common;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemReed;
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

//Seprate Mod
	//Cooking Mod
		//Peppers
		//Spices
		//New Food
		//Drinks


//Find a custom model rendering video tutorial
public class CampingMod 
{
	
	@SidedProxy(clientSide = "Connor_13_Camping.client.ClientProxyConnor_13_Camping", serverSide = "Connor_13_Camping.common.CommonProxyConnor_13_Camping")
	public static CommonProxyConnor_13_Camping proxy;
	
	public static CreativeTabs Camping = new CreativeTabCamping("Camping");

	public static Item TentPlacer;
	public static Block TentBlock;
	
	public static Block lantern;
	public static Item lanternIcon;

	@Init
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();
		
		LanguageRegistry.instance().addStringLocalization("itemGroup.Camping", "en_US", "Camping");

		TentPlacer = new CampingItemTentPlacer(251).setUnlocalizedName("tentplacer").setCreativeTab(CampingMod.Camping);//add in the rest
		TentBlock = new CampingBlockCabinBlock(252, true).setHardness(3.0F).setResistance(10.0F).setUnlocalizedName("tentblock").setCreativeTab(CampingMod.Camping);//add in the rest
		
		lantern = (new CampingBlockLantern(212, CampingTileEntityLantern.class)).setHardness(.2F).setLightValue(.9F).setUnlocalizedName("lantern");
		lanternIcon = (new ItemReed(213, lantern)).setUnlocalizedName("lanternIcon");
		
		LanguageRegistry.addName(TentPlacer, "Tent Placer");	
		LanguageRegistry.addName(TentBlock, "Tent Block");
		LanguageRegistry.addName(lanternIcon, "Lantern");
		
		GameRegistry.registerBlock(TentBlock);
		GameRegistry.registerBlock(lantern);
		GameRegistry.registerTileEntity(CampingTileEntityLantern.class, "TileEntityLantern");

		GameRegistry.addRecipe(new ItemStack(TentPlacer, 1), new Object[]
		{
			" X ", " X ", " X ", 'X', Block.pumpkin
		});
		
		GameRegistry.addRecipe(new ItemStack(TentBlock, 1), new Object[]
		{
			" X ", " X ", " X ", 'X', Block.dirt
		});
		GameRegistry.addRecipe(new ItemStack(lanternIcon, 1), new Object[]
		{
			" X ", " X ", " X ", 'X', Block.gravel
		});
	}
}

package Connor_13_Camping.camping.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraftforge.client.MinecraftForgeClient;
import Connor_13_Camping.camping.common.*;
import Connor_13_Camping.camping.common.render.*;
import Connor_13_Camping.camping.common.tile_entities.*;




public class ClientProxyConnor_13_Camping extends CommonProxyConnor_13_Camping
{
	@Override
	public void registerRenderThings()
	{
    	ClientRegistry.bindTileEntitySpecialRenderer(CampingTileEntityLantern.class, new CampingRenderLantern());
    	ClientRegistry.bindTileEntitySpecialRenderer(CampingTileEntityLanternStand.class, new CampingRenderLanternStand());
    	ClientRegistry.bindTileEntitySpecialRenderer(CampingTileEntityTable.class, new CampingRenderTable());
    	ClientRegistry.bindTileEntitySpecialRenderer(CampingTileEntityFirePit.class, new CampingRenderFirePit());

	}
}

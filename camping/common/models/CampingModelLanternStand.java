package Connor_13_Camping.camping.common.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class CampingModelLanternStand extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
  
  public CampingModelLanternStand()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 6, 2, 6);
      Shape1.setRotationPoint(-3F, 22F, -3F);
      Shape1.setTextureSize(64, 64);
      Shape1.mirror = true;
      Shape2 = new ModelRenderer(this, 0, 0);
      Shape2.addBox(0F, 0F, 0F, 2, 12, 2);
      Shape2.setRotationPoint(-1F, 10F, -1F);
      Shape2.setTextureSize(64, 64);
      Shape2.mirror = true;
      Shape3 = new ModelRenderer(this, 0, 0);
      Shape3.addBox(0F, 0F, 0F, 6, 2, 6);
      Shape3.setRotationPoint(-3F, 8F, -3F);
      Shape3.setTextureSize(64, 64);
      Shape3.mirror = true;
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
  }
  public void renderModel (float f1)
  {
	Shape1.render(f1);
	Shape2.render(f1);
	Shape3.render(f1);
  }
  
}
  

package Connor_13_Camping.camping.common.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class CampingModelLantern extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
  
  public CampingModelLantern()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Shape1 = new ModelRenderer(this, 40, 0);
      Shape1.addBox(0F, 0F, 0F, 6, 3, 6);
      Shape1.setRotationPoint(-3F, 21F, -3F);
      Shape1.setTextureSize(64, 64);
      Shape1.mirror = true;
      Shape2 = new ModelRenderer(this, 0, 17);
      Shape2.addBox(0F, 0F, 0F, 4, 7, 4);
      Shape2.setRotationPoint(-2F, 15F, -2F);
      Shape2.setTextureSize(64, 64);
      Shape2.mirror = true;
      Shape3 = new ModelRenderer(this, 0, 0);
      Shape3.addBox(0F, 0F, 0F, 6, 1, 6);
      Shape3.setRotationPoint(-3F, 16F, -3F);
      Shape3.setTextureSize(64, 64);
      Shape3.mirror = true;
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
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
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
  }

}


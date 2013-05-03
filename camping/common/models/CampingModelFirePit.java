package Connor_13_Camping.camping.common.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class CampingModelFirePit extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;
    ModelRenderer Shape14;
    ModelRenderer Shape15;
    ModelRenderer Shape16;
    ModelRenderer Shape17;
    ModelRenderer Shape18;
    ModelRenderer Shape19;
    ModelRenderer Shape20;
    ModelRenderer Shape21;
  
  public CampingModelFirePit()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Shape1 = new ModelRenderer(this, 24, 0);
      Shape1.addBox(0F, 0F, 0F, 10, 1, 10);
      Shape1.setRotationPoint(-5F, 23F, -5F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 41);
      Shape2.addBox(0F, 0F, 0F, 3, 4, 3);
      Shape2.setRotationPoint(-8F, 20F, -8F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 12, 41);
      Shape3.addBox(0F, 0F, 0F, 3, 4, 3);
      Shape3.setRotationPoint(5F, 20F, 5F);
      Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 24, 41);
      Shape4.addBox(0F, 0F, 0F, 3, 4, 3);
      Shape4.setRotationPoint(5F, 20F, -8F);
      Shape4.setTextureSize(64, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 36, 41);
      Shape5.addBox(0F, 0F, 0F, 3, 4, 3);
      Shape5.setRotationPoint(-8F, 20F, 5F);
      Shape5.setTextureSize(64, 32);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 50, 57);
      Shape6.addBox(0F, 0F, 0F, 3, 3, 4);
      Shape6.setRotationPoint(-8F, 21F, -5F);
      Shape6.setTextureSize(64, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 52, 51);
      Shape7.addBox(0F, 0F, 0F, 3, 2, 3);
      Shape7.setRotationPoint(-8F, 22F, -1F);
      Shape7.setTextureSize(64, 32);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 0, 33);
      Shape8.addBox(0F, 0F, 0F, 3, 3, 3);
      Shape8.setRotationPoint(-8F, 21F, 2F);
      Shape8.setTextureSize(64, 32);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 12, 33);
      Shape9.addBox(0F, 0F, 0F, 3, 3, 3);
      Shape9.setRotationPoint(5F, 21F, -5F);
      Shape9.setTextureSize(64, 32);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
      Shape10 = new ModelRenderer(this, 52, 46);
      Shape10.addBox(3F, 0F, 0F, 3, 2, 3);
      Shape10.setRotationPoint(-5F, 22F, -8F);
      Shape10.setTextureSize(64, 32);
      Shape10.mirror = true;
      setRotation(Shape10, 0F, 0F, 0F);
      Shape11 = new ModelRenderer(this, 50, 38);
      Shape11.addBox(0F, 0F, 0F, 3, 3, 4);
      Shape11.setRotationPoint(5F, 21F, 1F);
      Shape11.setTextureSize(64, 32);
      Shape11.mirror = true;
      setRotation(Shape11, 0F, 0F, 0F);
      Shape12 = new ModelRenderer(this, 50, 31);
      Shape12.addBox(0F, 0F, 0F, 4, 3, 3);
      Shape12.setRotationPoint(1F, 21F, -8F);
      Shape12.setTextureSize(64, 32);
      Shape12.mirror = true;
      setRotation(Shape12, 0F, 0F, 0F);
      Shape13 = new ModelRenderer(this, 24, 33);
      Shape13.addBox(0F, 0F, 0F, 3, 3, 3);
      Shape13.setRotationPoint(-5F, 21F, -8F);
      Shape13.setTextureSize(64, 32);
      Shape13.mirror = true;
      setRotation(Shape13, 0F, 0F, 0F);
      Shape14 = new ModelRenderer(this, 52, 25);
      Shape14.addBox(3F, 0F, 0F, 3, 2, 3);
      Shape14.setRotationPoint(2F, 22F, -2F);
      Shape14.setTextureSize(64, 32);
      Shape14.mirror = true;
      setRotation(Shape14, 0F, 0F, 0F);
      Shape15 = new ModelRenderer(this, 50, 18);
      Shape15.addBox(0F, 0F, 0F, 4, 3, 3);
      Shape15.setRotationPoint(-5F, 21F, 5F);
      Shape15.setTextureSize(64, 32);
      Shape15.mirror = true;
      setRotation(Shape15, 0F, 0F, 0F);
      Shape16 = new ModelRenderer(this, 36, 33);
      Shape16.addBox(0F, 0F, 0F, 3, 3, 3);
      Shape16.setRotationPoint(2F, 21F, 5F);
      Shape16.setTextureSize(64, 32);
      Shape16.mirror = true;
      setRotation(Shape16, 0F, 0F, 0F);
      Shape17 = new ModelRenderer(this, 0, 26);
      Shape17.addBox(3F, 0F, 0F, 3, 2, 3);
      Shape17.setRotationPoint(-4F, 22F, 5F);
      Shape17.setTextureSize(64, 32);
      Shape17.mirror = true;
      setRotation(Shape17, 0F, 0F, 0F);
      Shape18 = new ModelRenderer(this, 0, 51);
      Shape18.addBox(0F, 0F, -7F, 3, 10, 3);
      Shape18.setRotationPoint(-3F, 15F, 5F);
      Shape18.setTextureSize(64, 32);
      Shape18.mirror = true;
      setRotation(Shape18, -0.3490659F, 0F, 0.3490659F);
      Shape19 = new ModelRenderer(this, 12, 51);
      Shape19.addBox(0F, 0F, 0F, 3, 10, 3);
      Shape19.setRotationPoint(-1F, 14F, -2F);
      Shape19.setTextureSize(64, 32);
      Shape19.mirror = true;
      setRotation(Shape19, -0.3490659F, 0F, -0.3490659F);
      Shape20 = new ModelRenderer(this, 24, 51);
      Shape20.addBox(0F, 0F, 0F, 3, 10, 3);
      Shape20.setRotationPoint(-1F, 15F, -1F);
      Shape20.setTextureSize(64, 32);
      Shape20.mirror = true;
      setRotation(Shape20, 0.3490659F, 0F, -0.3490659F);
      Shape21 = new ModelRenderer(this, 36, 51);
      Shape21.addBox(0F, 0F, 0F, 3, 10, 3);
      Shape21.setRotationPoint(-2F, 14F, -1F);
      Shape21.setTextureSize(64, 32);
      Shape21.mirror = true;
      setRotation(Shape21, 0.3490659F, 0F, 0.3490659F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
    Shape9.render(f5);
    Shape10.render(f5);
    Shape11.render(f5);
    Shape12.render(f5);
    Shape13.render(f5);
    Shape14.render(f5);
    Shape15.render(f5);
    Shape16.render(f5);
    Shape17.render(f5);
    Shape18.render(f5);
    Shape19.render(f5);
    Shape20.render(f5);
    Shape21.render(f5);
  }
  
  public void renderModel (float f1)
  {
	    Shape1.render(f1);
	    Shape2.render(f1);
	    Shape3.render(f1);
	    Shape4.render(f1);
	    Shape5.render(f1);
	    Shape6.render(f1);
	    Shape7.render(f1);
	    Shape8.render(f1);
	    Shape9.render(f1);
	    Shape10.render(f1);
	    Shape11.render(f1);
	    Shape12.render(f1);
	    Shape13.render(f1);
	    Shape14.render(f1);
	    Shape15.render(f1);
	    Shape16.render(f1);
	    Shape17.render(f1);
	    Shape18.render(f1);
	    Shape19.render(f1);
	    Shape20.render(f1);
	    Shape21.render(f1);
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

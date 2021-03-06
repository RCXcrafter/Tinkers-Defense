package lance5057.tDefense.armor.renderers;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.ArmorCore;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

/**
 * ModelBiped - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class ModelSheath extends ArmorRenderer
{
	public ModelRenderer	sheath;
	public ModelRenderer	belt;

	String					Color[];
	int						rgbColors[];

	public ModelSheath()
	{
		super(0.5f, 0, 64, 64);

		this.textureWidth = 64;
		this.textureHeight = 64;

		this.belt = new ModelRenderer(this, 16, 32);
		this.belt.setRotationPoint(-4.5F, 0.0F, 0.5F);
		this.belt.addBox(0.0F, 0.0F, -3.0F, 1, 12, 5, 0.0F);
		this.setRotateAngle(belt, 0.0F, 0.0F, -0.7853981633974483F);
		this.bipedBody.addChild(belt);

		this.sheath = new ModelRenderer(this, 0, 32);
		this.sheath.setRotationPoint(0f, 0f, 0f);
		this.sheath.addBox(-5.0F, 0.0F, 2.0F, 5, 16, 2, -0.4F);
		this.setRotateAngle(sheath, 0.0F, 0.0F, -0.45F);
		this.bipedBody.addChild(sheath);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		GL11.glPushMatrix();

		for(int i = 0; i < 10; i++)
		{
			String texture = ((ArmorCore) this.stack.getItem()).getTexture(i, stack);
			if(texture != "")
			{

				GL11.glPushMatrix();

				((ArmorCore) this.stack.getItem()).renderArmor(entity, f, f1, f2, f3, f4, f5, colors, stack, i);
				super.render(entity, f, f1, f2, f3, f4, f5);

				GL11.glPopMatrix();
			}
		}

		GL11.glPopMatrix();
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}

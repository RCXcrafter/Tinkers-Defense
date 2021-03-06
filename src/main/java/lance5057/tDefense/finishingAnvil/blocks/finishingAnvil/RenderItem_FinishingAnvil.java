package lance5057.tDefense.finishingAnvil.blocks.finishingAnvil;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import org.lwjgl.opengl.GL11;

public class RenderItem_FinishingAnvil extends RenderItem
{
	private Gui_FinishingAnvil	anvilGui;

	RenderItem_FinishingAnvil(Gui_FinishingAnvil gui)
	{
		super();
		anvilGui = gui;
	}

	@Override
	public void renderItemAndEffectIntoGUI(FontRenderer fontRenderer, TextureManager textureManager, ItemStack itemStack, int x, int y)
	{
		if(itemStack == null)
		{
			return;
		}

		RenderHelper.enableGUIStandardItemLighting();

		Slot slot = anvilGui.inventorySlots.getSlotFromInventory(anvilGui.inventory, 0);

		if(slot.getStack() != null)
		{
			GL11.glPushMatrix();

			GL11.glScalef(3.438f, 3.43f, 1.0f);
			super.renderItemAndEffectIntoGUI(fontRenderer, textureManager, itemStack, x, y);

			GL11.glPopMatrix();
		}
	}
}

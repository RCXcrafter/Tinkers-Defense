package lance5057.tDefense.armor.items.straps;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

public class StrapsContainer extends Container
{
	/** The Item Inventory for this Container, only needed if you want to reference isUseableByPlayer */
	public final ItemStrapsInv inventory;

	/** Using these will make transferStackInSlot easier to understand and implement
	 * INV_START is the index of the first slot in the Player's Inventory, so our
	 * InventoryItem's number of slots (e.g. 5 slots is array indices 0-4, so start at 5)
	 * Notice how we don't have to remember how many slots we made? We can just use
	 * InventoryItem.INV_SIZE and if we ever change it, the Container updates automatically. */
	private static final int INV_START = ItemStrapsInv.INVSIZE, INV_END = INV_START+26,
			HOTBAR_START = INV_END+1, HOTBAR_END = HOTBAR_START+8;

	// If you're planning to add armor slots, put those first like this:
	// ARMOR_START = InventoryItem.INV_SIZE, ARMOR_END = ARMOR_START+3,
	// INV_START = ARMOR_END+1, and then carry on like above.

	public StrapsContainer(EntityPlayer par1Player, InventoryPlayer inventoryPlayer, ItemStrapsInv inventoryItem)
	{
		this.inventory = inventoryItem;

		int i;

		// ITEM INVENTORY - you'll need to adjust the slot locations to match your texture file
		// I have them set vertically in columns of 4 to the right of the player model
		this.addSlotToContainer(new Slot(this.inventory, 0, 80, 8+23));

		// If you want, you can add ARMOR SLOTS here as well, but you need to
		// make a public version of SlotArmor. I won't be doing that in this tutorial.
		/*
		for (i = 0; i < 4; ++i)
		{
			// These are the standard positions for survival inventory layout
			this.addSlotToContainer(new SlotArmor(this.player, inventoryPlayer, inventoryPlayer.getSizeInventory() - 1 - i, 8, 8 + i * 18, i));
		}
		*/

		// PLAYER INVENTORY - uses default locations for standard inventory texture file
		for (i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		// PLAYER ACTION BAR - uses default locations for standard action bar texture file
		for (i = 0; i < 9; ++i)
		{
			this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer)
	{
		// be sure to return the inventory's isUseableByPlayer method
		// if you defined special behavior there:
		return inventory.isUsableByPlayer(entityplayer);
	}

	/**
	 * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
	 */
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int index)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			// If item is in our custom Inventory or armor slot
			if (index < INV_START)
			{
				// try to place in player inventory / action bar
				if (!this.mergeItemStack(itemstack1, INV_START, HOTBAR_END+1, true))
				{
					return null;
				}

				slot.onSlotChange(itemstack1, itemstack);
			}
			// Item is in inventory / hotbar, try to place in custom inventory or armor slots
			else
			{
				/*
				If your inventory only stores certain instances of Items,
				you can implement shift-clicking to your inventory like this:
				
				// Check that the item is the right type
				if (itemstack1.getItem() instanceof ItemCustom)
				{
					// Try to merge into your custom inventory slots
					// We use 'InventoryItem.INV_SIZE' instead of INV_START just in case
					// you also add armor or other custom slots
					if (!this.mergeItemStack(itemstack1, 0, InventoryItem.INV_SIZE, false))
					{
						return null;
					}
				}
				// If you added armor slots, check them here as well:
				// Item being shift-clicked is armor - try to put in armor slot
				if (itemstack1.getItem() instanceof ItemArmor)
				{
					int type = ((ItemArmor) itemstack1.getItem()).armorType;
					if (!this.mergeItemStack(itemstack1, ARMOR_START + type, ARMOR_START + type + 1, false))
					{
						return null;
					}
				}
				Otherwise, you have basically 2 choices:
				1. shift-clicking between player inventory and custom inventory
				2. shift-clicking between action bar and inventory
				 
				Be sure to choose only ONE of the following implementations!!!
				*/
				/**
				 * Implementation number 1: Shift-click into your custom inventory
				 */
				if (index >= INV_START)
				{
					// place in custom inventory
					if (!this.mergeItemStack(itemstack1, 0, INV_START, false))
					{
						return null;
					}
				}
				
				/**
				 * Implementation number 2: Shift-click items between action bar and inventory
				 */
				// item is in player's inventory, but not in action bar
				if (index >= INV_START && index < HOTBAR_START)
				{
					// place in action bar
					if (!this.mergeItemStack(itemstack1, HOTBAR_START, HOTBAR_END+1, false))
					{
						return null;
					}
				}
				// item in action bar - place in player inventory
				else if (index >= HOTBAR_START && index < HOTBAR_END+1)
				{
					if (!this.mergeItemStack(itemstack1, INV_START, INV_END+1, false))
					{
						return null;
					}
				}
			}

			if (itemstack1.stackSize == 0)
			{
				slot.putStack((ItemStack) null);
			}
			else
			{
				slot.onSlotChanged();
			}

			if (itemstack1.stackSize == itemstack.stackSize)
			{
				return null;
			}

			slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
		}

		return itemstack;
	}

	/**
	 * You should override this method to prevent the player from moving the stack that
	 * opened the inventory, otherwise if the player moves it, the inventory will not
	 * be able to save properly
	 */
	@Override
	public ItemStack slotClick(int slotId, int dragType, ClickType clickTypeIn, EntityPlayer player) {
		// this will prevent the player from interacting with the item that opened the inventory:
		if (slotId >= 0 && getSlot(slotId) != null && (getSlot(slotId).getStack() == player.getHeldItem(EnumHand.MAIN_HAND) || getSlot(slotId).getStack() == player.getHeldItem(EnumHand.OFF_HAND))) {
			return null;
		}
		return super.slotClick(slotId, dragType, clickTypeIn, player);
	}
}
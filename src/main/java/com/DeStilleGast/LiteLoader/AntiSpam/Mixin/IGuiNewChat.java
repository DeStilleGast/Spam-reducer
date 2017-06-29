package com.DeStilleGast.LiteLoader.AntiSpam.Mixin;

import net.minecraft.client.gui.ChatLine;
import net.minecraft.client.gui.GuiNewChat;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

/**
 * Created by DeStilleGast on 28-6-2017.
 */
@Mixin(GuiNewChat.class)
public interface IGuiNewChat {

    @Accessor("drawnChatLines")
    @Final
    public List<ChatLine> getDrawnChatLines();
}

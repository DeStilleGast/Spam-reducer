package com.DeStilleGast.LiteLoader.AntiSpam;

import com.DeStilleGast.LiteLoader.AntiSpam.Mixin.IGuiNewChat;
import com.mumfrey.liteloader.ChatFilter;
import com.mumfrey.liteloader.core.LiteLoaderEventBroker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ChatLine;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;

import java.io.File;
import java.util.List;

/**
 * Created by DeStilleGast on 29-6-2017.
 */
public class LiteModAntiSpam implements ChatFilter{

    private String lastMessage = "";
    private int spamCount = 1;

    @Override
    public boolean onChat(ITextComponent chat, String message, LiteLoaderEventBroker.ReturnValue<ITextComponent> newMessage) {
        if (lastMessage.equalsIgnoreCase(TextFormatting.getTextWithoutFormattingCodes(message))) {
            List<ChatLine> chatLines = ((IGuiNewChat) Minecraft.getMinecraft().ingameGUI.getChatGUI()).getDrawnChatLines();
            if(chatLines.size() > 1)
                chatLines.remove(0);

            newMessage.set(chat.appendText(" [x" + ++spamCount + "]"));
        } else {
            lastMessage = TextFormatting.getTextWithoutFormattingCodes(message);
            spamCount = 1;
        }

        return true;
    }

    @Override
    public String getVersion() {
        return "0.1";
    }

    @Override
    public void init(File configPath) {

    }

    @Override
    public void upgradeSettings(String version, File configPath, File oldConfigPath) {

    }

    @Override
    public String getName() {
        return "Client side spam reducer";
    }
}

package com.tuxpenguins.mymod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = MyMod.MODID, version = MyMod.VERSION)
public class MyMod
{
    public static final String MODID = "mymod";
    public static final String VERSION = "1.0";
    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent.Post event)
    {
        if (event.type == RenderGameOverlayEvent.ElementType.TEXT)
        {
            this.drawHUD(event.resolution);
        }
    }

    public static int rgbToHex(int r, int g, int b) {
        // Make sure r, g, b are within valid range (0-255)
        r = Math.max(0, Math.min(r, 255));
        g = Math.max(0, Math.min(g, 255));
        b = Math.max(0, Math.min(b, 255));

        // Shift red, green, and blue components and combine them into a single integer
        return (r << 16) + (g << 8) + b;
    }

    public void drawHUD(ScaledResolution resolution)
    {
        int top = 0;
        int left = 0;
        int bottom = resolution.getScaledHeight();
        int right = resolution.getScaledWidth();
        final FontRenderer renderer = Minecraft.getMinecraft().fontRendererObj;
        String text = "nigga";
        renderer.drawStringWithShadow(text, (right - renderer.getStringWidth(text)) / 2f, bottom / 4f, rgbToHex(255, 255, 0));
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
        System.out.println("TUX_MOD init");
    }
}

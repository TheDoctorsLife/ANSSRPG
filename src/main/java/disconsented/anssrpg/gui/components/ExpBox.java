/*The MIT License (MIT)

Copyright (c) 2015 Disconsented, James Kerr

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */
package disconsented.anssrpg.gui.components;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.client.FMLClientHandler;
import disconsented.anssrpg.common.Reference;

/**
 * @author Disconsented
 *
 */
public class ExpBox extends Gui{
    //176x76
    private int x;
    private int y;
    public int expCurrent = 0;
    public int expRequired = 0;
    private float currentPercent = 0;
    public int level = 0;
    public String name = "Not A Name";
    private ResourceLocation texture = new ResourceLocation(Reference.ID, "expbox.png");
    private ResourceLocation greenTexture = new ResourceLocation(Reference.ID, "green.png");
    private FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
    
    /**
     * 
     * @param x
     * @param y
     * @param expCurrent
     * @param expRequired
     * @param level
     * @param name
     */
    public ExpBox(int x, int y, int expCurrent, int expRequired, int level, String name){
        this.x = x;
        this.y = y;
        this.expCurrent = expCurrent;
        this.expRequired = expRequired;
        this.name = name;        
        this.level = level;
        this.currentPercent = (expCurrent * 100) / expRequired;       
    }
    public void draw(){
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(texture);
        drawTexturedModalRectClone(x, y, 0, 0, 256, 256);
//        * Name box -  9,9-106x12
        this.drawString(fontRenderer, name, this.x + 9, this.y + 11, 0xBEFF00);        
//        * Level box - 132,9-32x12
        this.drawString(fontRenderer, level+"->"+(level+1), 132 + this.x, this.y + 11, 0xBEFF00);  
//        * 0% - 15,38-20x12
        this.drawString(fontRenderer, "0%", 14 + this.x, this.y + 40, 0xBEFF00);  
//        * 100% - 144,38-20x12
        this.drawString(fontRenderer, "100%", 144 + this.x, this.y + 40, 0xBEFF00);  
//        * numerical exp box - 41,56-71x12
        this.drawString(fontRenderer, expCurrent+"", 41 + this.x, this.y + 58, 0xBEFF00); 
//        * percentile exp box - 118,56-20x12
        this.drawString(fontRenderer, currentPercent+"%", 118 + this.x, this.y + 58, 0xBEFF00); 
//        * bar box - 40,36-99x16
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(greenTexture);
        drawTexturedModalRectClone(x+40, y+36, 0, 0, (int) currentPercent, 16);
    }

    public void calcPercentage(){
        this.currentPercent = (expCurrent * 100) / expRequired; 
    }
   private void drawTexturedModalRectClone(int p_73729_1_, int p_73729_2_, int p_73729_3_, int p_73729_4_, int p_73729_5_, int p_73729_6_)
    {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        Tessellator.instance.setColorRGBA_F(1F, 1F, 1F, 1F);
        tessellator.addVertexWithUV((double)(p_73729_1_ + 0), (double)(p_73729_2_ + p_73729_6_), (double)this.zLevel, (double)((float)(p_73729_3_ + 0) * f), (double)((float)(p_73729_4_ + p_73729_6_) * f1));
        tessellator.addVertexWithUV((double)(p_73729_1_ + p_73729_5_), (double)(p_73729_2_ + p_73729_6_), (double)this.zLevel, (double)((float)(p_73729_3_ + p_73729_5_) * f), (double)((float)(p_73729_4_ + p_73729_6_) * f1));
        tessellator.addVertexWithUV((double)(p_73729_1_ + p_73729_5_), (double)(p_73729_2_ + 0), (double)this.zLevel, (double)((float)(p_73729_3_ + p_73729_5_) * f), (double)((float)(p_73729_4_ + 0) * f1));
        tessellator.addVertexWithUV((double)(p_73729_1_ + 0), (double)(p_73729_2_ + 0), (double)this.zLevel, (double)((float)(p_73729_3_ + 0) * f), (double)((float)(p_73729_4_ + 0) * f1));
        tessellator.draw();
    }
}

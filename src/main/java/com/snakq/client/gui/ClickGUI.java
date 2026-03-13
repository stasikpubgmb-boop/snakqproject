package com.snakq.client.gui;
import com.snakq.client.module.Module; 
import com.snakq.client.module.ModuleManager;
import net.minecraft.client.gui.screen.Screen; 
import net.minecraft.client.gui.DrawContext; 
import net.minecraft.text.Text;
public class ClickGUI extends Screen {
    public ClickGUI() { 
        super(Text.literal("ClickGUI")); 
    }
    @Override public void render(DrawContext ctx, int mx, int my, float delta) {
        this.renderBackground(ctx,mx,my,delta); 
        int y=10;
        for(Module m:ModuleManager.getModules()) { 
            ctx.fill(10,y,110,y+12,0xAA000000); 
            ctx.drawTextWithShadow(textRenderer,m.getName(),12,y+2,m.isEnabled()?0xFF00FF00:0xFFAAAAAA); 
            y+=14; 
        }
        super.render(ctx,mx,my,delta);
    }
    @Override public boolean mouseClicked(double mx,double my,int btn) {
        int y=10; 
        for(Module m:ModuleManager.getModules()) { 
            if(mx>=10&&mx<=110&&my>=y&&my<=y+12){
                m.toggle();return true;
            } 
            y+=14; 
        } 
        return super.mouseClicked(mx,my,btn);
    }
    @Override public boolean shouldPause(){return false;}
}

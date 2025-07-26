/*
 * Copyright (c) 2024 lax1dude. All Rights Reserved.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 */

package net.lax1dude.eaglercraft.v1_8.minecraft;

import net.lax1dude.eaglercraft.v1_8.Display;
import net.lax1dude.eaglercraft.v1_8.opengl.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public abstract class ScreenVisualViewport extends Screen {

    protected ScreenVisualViewport() {
        super(Component.literal(""));
    }

    protected int offsetX;
    protected int offsetY;

    @Override
    public void resize(Minecraft mc, int width, int height) {
        Display.wasVisualViewportResized(); // clear state
        offsetX = Display.getVisualViewportX() * width / mc.getWindow().getScreenWidth();
        offsetY = Display.getVisualViewportY() * height / mc.getWindow().getScreenHeight();

        int viewportWidth = Display.getVisualViewportW() * width / mc.getWindow().getScreenWidth();
        int viewportHeight = Display.getVisualViewportH() * height / mc.getWindow().getScreenHeight();

        super.resize(mc, viewportWidth, viewportHeight);
    }

    @Override
    public void tick() {
        if (Display.wasVisualViewportResized()) {
            Minecraft mc = Minecraft.getInstance();
            resize(mc, mc.getWindow().getGuiScaledWidth(), mc.getWindow().getGuiScaledHeight());
        }
        tick0();
    }

    protected void tick0() {
        super.tick();
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        int adjustedMouseX = mouseX - offsetX;
        int adjustedMouseY = mouseY - offsetY;

        graphics.pose().pushPose();
        graphics.pose().translate(offsetX, offsetY, 0.0f);
        render0(graphics, adjustedMouseX, adjustedMouseY, partialTicks);
        graphics.pose().popPose();
    }

    protected void render0(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        super.render(graphics, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        double adjustedX = mouseX - offsetX;
        double adjustedY = mouseY - offsetY;
        return mouseClicked0(adjustedX, adjustedY, button) || super.mouseClicked(mouseX, mouseY, button);
    }

    protected boolean mouseClicked0(double mouseX, double mouseY, int button) {
        return false;
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        double adjustedX = mouseX - offsetX;
        double adjustedY = mouseY - offsetY;
        return mouseReleased0(adjustedX, adjustedY, button) || super.mouseReleased(mouseX, mouseY, button);
    }

    protected boolean mouseReleased0(double mouseX, double mouseY, int button) {
        return false;
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        double adjustedX = mouseX - offsetX;
        double adjustedY = mouseY - offsetY;
        return mouseDragged0(adjustedX, adjustedY, button, dragX, dragY) || 
               super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
    }

    protected boolean mouseDragged0(double mouseX, double mouseY, int button, double dragX, double dragY) {
        return false;
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY) {
        double adjustedX = mouseX - offsetX;
        double adjustedY = mouseY - offsetY;
        return mouseScrolled0(adjustedX, adjustedY, scrollY) || 
               super.mouseScrolled(mouseX, mouseY, scrollX, scrollY);
    }

    protected boolean mouseScrolled0(double mouseX, double mouseY, double scrollDelta) {
        return false;
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        return keyPressed0(keyCode, scanCode, modifiers) || 
               super.keyPressed(keyCode, scanCode, modifiers);
    }

    protected boolean keyPressed0(int keyCode, int scanCode, int modifiers) {
        return false;
    }

    @Override
    public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
        return keyReleased0(keyCode, scanCode, modifiers) || 
               super.keyReleased(keyCode, scanCode, modifiers);
    }

    protected boolean keyReleased0(int keyCode, int scanCode, int modifiers) {
        return false;
    }

    @Override
    public boolean charTyped(char codePoint, int modifiers) {
        return charTyped0(codePoint, modifiers) || 
               super.charTyped(codePoint, modifiers);
    }

    protected boolean charTyped0(char codePoint, int modifiers) {
        return false;
    }

}
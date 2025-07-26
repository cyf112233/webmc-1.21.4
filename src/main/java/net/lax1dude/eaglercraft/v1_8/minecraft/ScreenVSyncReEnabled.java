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

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;

public class ScreenVSyncReEnabled extends Screen {

    private final Screen cont;

    public ScreenVSyncReEnabled(Screen cont) {
        super(Component.translatable("options.vsyncReEnabled.title"));
        this.cont = cont;
    }

    @Override
    protected void init() {
        this.clearWidgets();
        this.addRenderableWidget(Button.builder(Component.translatable("options.vsyncReEnabled.continue"), 
            btn -> this.minecraft.setScreen(cont))
            .bounds(this.width / 2 - 100, this.height / 6 + 136, 200, 20)
            .build());
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(graphics, mouseX, mouseY, partialTicks);
        graphics.drawCenteredString(this.font, Component.translatable("options.vsyncReEnabled.title"), this.width / 2, 70, 11184810);
        graphics.drawCenteredString(this.font, Component.translatable("options.vsyncReEnabled.0"), this.width / 2, 95, 16777215);
        graphics.drawCenteredString(this.font, Component.translatable("options.vsyncReEnabled.1"), this.width / 2, 120, 16777215);
        graphics.drawCenteredString(this.font, Component.translatable("options.vsyncReEnabled.2"), this.width / 2, 145, 16777215);
        graphics.drawCenteredString(this.font, Component.translatable("options.vsyncReEnabled.3"), this.width / 2, 160, 16777215);
        super.render(graphics, mouseX, mouseY, partialTicks);
    }
}
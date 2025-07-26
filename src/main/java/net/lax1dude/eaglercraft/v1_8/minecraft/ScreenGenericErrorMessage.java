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
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class ScreenGenericErrorMessage extends Screen {

    private final Component message1;
    private final Component message2;
    private final Screen cont;

    public ScreenGenericErrorMessage(Component title, Component message, Screen cont) {
        this(title, message, Component.empty(), cont);
    }

    public ScreenGenericErrorMessage(Component title, String message1, String message2, Screen cont) {
        this(title, Component.literal(message1), Component.literal(message2), cont);
    }

    public ScreenGenericErrorMessage(Component title, Component message1, Component message2, Screen cont) {
        super(Component.translatable("gui.error.title"));
        this.message1 = message1 == null ? Component.empty() : message1;
        this.message2 = message2 == null ? Component.empty() : message2;
        this.cont = cont;
    }

    @Override
    public void init() {
        this.clearWidgets();
        this.addRenderableWidget(Button.builder(
            Component.translatable("gui.done"),
            btn -> this.minecraft.setScreen(cont)
        ).bounds(this.width / 2 - 100, this.height / 6 + 96, 200, 20).build());
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
        guiGraphics.drawCenteredString(this.font, this.title, this.width / 2, 30, 0xFFFFFF);
        guiGraphics.drawCenteredString(this.font, this.message1, this.width / 2, 70, 0xAAAAAA);
        guiGraphics.drawCenteredString(this.font, this.message2, this.width / 2, 90, 0xFFFFFF);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
    }
}
package org.cloudburstmc.protocol.java.packet.play.serverbound;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.cloudburstmc.protocol.java.data.inventory.ItemStack;
import org.cloudburstmc.protocol.java.packet.handler.JavaPlayPacketHandler;
import org.cloudburstmc.protocol.java.packet.JavaPacket;
import org.cloudburstmc.protocol.java.packet.type.JavaPacketType;
import org.cloudburstmc.protocol.java.packet.type.JavaPlayPacketType;

@Data
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class EditBookPacket implements JavaPacket<JavaPlayPacketHandler> {
    private ItemStack book;
    private boolean signing;
    private int slot;

    @Override
    public boolean handle(JavaPlayPacketHandler handler) {
        return handler.handle(this);
    }

    @Override
    public JavaPacketType getPacketType() {
        return JavaPlayPacketType.EDIT_BOOK;
    }
}

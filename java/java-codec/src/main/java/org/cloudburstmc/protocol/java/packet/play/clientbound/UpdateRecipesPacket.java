package org.cloudburstmc.protocol.java.packet.play.clientbound;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.cloudburstmc.protocol.common.PacketSignal;
import org.cloudburstmc.protocol.java.data.crafting.Recipe;
import org.cloudburstmc.protocol.java.packet.JavaPacket;
import org.cloudburstmc.protocol.java.packet.handler.JavaPlayPacketHandler;
import org.cloudburstmc.protocol.java.packet.type.JavaPacketType;

import java.util.List;

@Data
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class UpdateRecipesPacket implements JavaPacket<JavaPlayPacketHandler> {
    private List<Recipe> recipes;

    @Override
    public PacketSignal handle(JavaPlayPacketHandler handler) {
        return handler.handle(this);
    }

    @Override
    public JavaPacketType getPacketType() {
        return null;
    }
}

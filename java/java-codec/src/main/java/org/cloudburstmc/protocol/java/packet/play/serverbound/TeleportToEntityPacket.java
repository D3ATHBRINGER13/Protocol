package org.cloudburstmc.protocol.java.packet.play.serverbound;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.cloudburstmc.protocol.common.PacketSignal;
import org.cloudburstmc.protocol.java.packet.JavaPacket;
import org.cloudburstmc.protocol.java.packet.handler.JavaPlayPacketHandler;
import org.cloudburstmc.protocol.java.packet.type.JavaPacketType;
import org.cloudburstmc.protocol.java.packet.type.JavaPlayPacketType;

import java.util.UUID;

@Data
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class TeleportToEntityPacket implements JavaPacket<JavaPlayPacketHandler> {
    private UUID entityUuid;

    @Override
    public PacketSignal handle(JavaPlayPacketHandler handler) {
        return handler.handle(this);
    }

    @Override
    public JavaPacketType getPacketType() {
        return JavaPlayPacketType.TELEPORT_TO_ENTITY;
    }
}

package org.cloudburstmc.protocol.java.packet.play.clientbound;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.cloudburstmc.protocol.java.packet.handler.JavaPlayPacketHandler;
import org.cloudburstmc.protocol.java.packet.JavaPacket;
import org.cloudburstmc.protocol.java.packet.type.JavaPacketType;
import org.cloudburstmc.protocol.java.packet.type.JavaPlayPacketType;

import java.util.HashMap;
import java.util.Map;

@Data
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class UpdateTagsPacket implements JavaPacket<JavaPlayPacketHandler> {
    private final Map<String, Map<String, int[]>> tags = new HashMap<>();

    @Override
    public boolean handle(JavaPlayPacketHandler handler) {
        return handler.handle(this);
    }

    @Override
    public JavaPacketType getPacketType() {
        return JavaPlayPacketType.UPDATE_TAGS;
    }
}
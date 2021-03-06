package org.cloudburstmc.protocol.java.packet.play.serverbound;

import com.nukkitx.math.vector.Vector3i;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.cloudburstmc.protocol.common.PacketSignal;
import org.cloudburstmc.protocol.java.packet.JavaPacket;
import org.cloudburstmc.protocol.java.packet.handler.JavaPlayPacketHandler;
import org.cloudburstmc.protocol.java.packet.type.JavaPacketType;
import org.cloudburstmc.protocol.java.packet.type.JavaPlayPacketType;

@Data
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class BlockEntityTagQueryPacket implements JavaPacket<JavaPlayPacketHandler> {
    private int transactionId;
    private Vector3i position;

    @Override
    public PacketSignal handle(JavaPlayPacketHandler handler) {
            return handler.handle(this);
    }

    @Override
    public JavaPacketType getPacketType() {
        return JavaPlayPacketType.BLOCK_ENTITY_TAG_QUERY;
    }
}

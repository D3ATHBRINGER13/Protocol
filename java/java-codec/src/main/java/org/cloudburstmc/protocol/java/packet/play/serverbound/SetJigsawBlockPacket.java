package org.cloudburstmc.protocol.java.packet.play.serverbound;

import com.nukkitx.math.vector.Vector3i;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.kyori.adventure.key.Key;
import org.cloudburstmc.protocol.common.PacketSignal;
import org.cloudburstmc.protocol.java.packet.JavaPacket;
import org.cloudburstmc.protocol.java.packet.handler.JavaPlayPacketHandler;
import org.cloudburstmc.protocol.java.packet.type.JavaPacketType;
import org.cloudburstmc.protocol.java.packet.type.JavaPlayPacketType;

@Data
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class SetJigsawBlockPacket implements JavaPacket<JavaPlayPacketHandler> {
    private Vector3i position;
    private Key name;
    private Key target;
    private Key pool;
    private String finalState;
    private String jointType;

    @Override
    public PacketSignal handle(JavaPlayPacketHandler handler) {
        return handler.handle(this);
    }

    @Override
    public JavaPacketType getPacketType() {
        return JavaPlayPacketType.SET_JIGSAW_BLOCK;
    }
}

package org.cloudburstmc.protocol.java.packet.play.clientbound;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.kyori.adventure.key.Key;
import org.cloudburstmc.protocol.common.PacketSignal;
import org.cloudburstmc.protocol.java.data.SoundSource;
import org.cloudburstmc.protocol.java.packet.JavaPacket;
import org.cloudburstmc.protocol.java.packet.handler.JavaPlayPacketHandler;
import org.cloudburstmc.protocol.java.packet.type.JavaPacketType;
import org.cloudburstmc.protocol.java.packet.type.JavaPlayPacketType;

@Data
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class StopSoundPacket implements JavaPacket<JavaPlayPacketHandler> {
    private Key key;
    private SoundSource soundSource;

    @Override
    public PacketSignal handle(JavaPlayPacketHandler handler) {
        return handler.handle(this);
    }

    @Override
    public JavaPacketType getPacketType() {
        return JavaPlayPacketType.STOP_SOUND;
    }
}

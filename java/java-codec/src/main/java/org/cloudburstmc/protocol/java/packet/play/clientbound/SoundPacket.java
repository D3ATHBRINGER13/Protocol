package org.cloudburstmc.protocol.java.packet.play.clientbound;

import com.nukkitx.math.vector.Vector3i;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.cloudburstmc.protocol.common.PacketSignal;
import org.cloudburstmc.protocol.java.data.SoundEvent;
import org.cloudburstmc.protocol.java.data.SoundSource;
import org.cloudburstmc.protocol.java.packet.JavaPacket;
import org.cloudburstmc.protocol.java.packet.handler.JavaPlayPacketHandler;
import org.cloudburstmc.protocol.java.packet.type.JavaPacketType;
import org.cloudburstmc.protocol.java.packet.type.JavaPlayPacketType;

@Data
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class SoundPacket implements JavaPacket<JavaPlayPacketHandler> {
    private SoundEvent sound;
    private SoundSource source;
    private Vector3i position;
    private float volume;
    private float pitch;

    @Override
    public PacketSignal handle(JavaPlayPacketHandler handler) {
        return handler.handle(this);
    }

    @Override
    public JavaPacketType getPacketType() {
        return JavaPlayPacketType.SOUND;
    }
}

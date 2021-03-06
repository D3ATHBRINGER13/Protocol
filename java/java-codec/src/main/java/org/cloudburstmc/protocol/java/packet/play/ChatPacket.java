package org.cloudburstmc.protocol.java.packet.play;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.kyori.adventure.text.Component;
import org.cloudburstmc.protocol.common.PacketSignal;
import org.cloudburstmc.protocol.java.data.text.ChatPosition;
import org.cloudburstmc.protocol.java.packet.BidirectionalJavaPacket;
import org.cloudburstmc.protocol.java.annotation.DirectionAvailability;
import org.cloudburstmc.protocol.java.packet.handler.JavaPlayPacketHandler;
import org.cloudburstmc.protocol.java.packet.type.JavaPacketType;
import org.cloudburstmc.protocol.java.packet.type.JavaPlayPacketType;

import java.util.UUID;

@Data
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class ChatPacket implements BidirectionalJavaPacket<JavaPlayPacketHandler> {
    private Component message;

    @DirectionAvailability(JavaPacketType.Direction.CLIENTBOUND)
    private ChatPosition position;

    @DirectionAvailability(JavaPacketType.Direction.CLIENTBOUND)
    private UUID senderUuid;

    @Override
    public PacketSignal handle(JavaPlayPacketHandler handler) {
        return handler.handle(this);
    }

    @Override
    public JavaPacketType getPacketType() {
        return JavaPlayPacketType.CHAT;
    }
}

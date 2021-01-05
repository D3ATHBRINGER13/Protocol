package org.cloudburstmc.protocol.java.v754.serializer.play;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.java.JavaPacketHelper;
import org.cloudburstmc.protocol.java.JavaPacketSerializer;
import org.cloudburstmc.protocol.java.packet.play.ContainerAckPacket;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ContainerAckSerializer_v754 implements JavaPacketSerializer<ContainerAckPacket> {
    public static final ContainerAckSerializer_v754 INSTANCE = new ContainerAckSerializer_v754();

    @Override
    public void serialize(ByteBuf buffer, JavaPacketHelper helper, ContainerAckPacket packet) {
        buffer.writeByte(packet.getWindowId());
        buffer.writeShort(packet.getActionId());
        buffer.writeBoolean(packet.isAccepted());
    }

    @Override
    public void deserialize(ByteBuf buffer, JavaPacketHelper helper, ContainerAckPacket packet) {
        packet.setWindowId(buffer.readByte());
        packet.setActionId(buffer.readShort());
        packet.setAccepted(buffer.readBoolean());
    }
}

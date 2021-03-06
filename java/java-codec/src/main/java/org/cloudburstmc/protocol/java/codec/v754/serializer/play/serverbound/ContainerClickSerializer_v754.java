package org.cloudburstmc.protocol.java.codec.v754.serializer.play.serverbound;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.common.exception.PacketSerializeException;
import org.cloudburstmc.protocol.java.codec.JavaCodecHelper;
import org.cloudburstmc.protocol.java.codec.JavaPacketSerializer;
import org.cloudburstmc.protocol.java.data.inventory.ClickType;
import org.cloudburstmc.protocol.java.packet.play.serverbound.ContainerClickPacket;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ContainerClickSerializer_v754 implements JavaPacketSerializer<ContainerClickPacket> {
    public static final ContainerClickSerializer_v754 INSTANCE = new ContainerClickSerializer_v754();

    @Override
    public void serialize(ByteBuf buffer, JavaCodecHelper helper, ContainerClickPacket packet)
            throws PacketSerializeException {
        buffer.writeByte(packet.getContainerId());
        buffer.writeShort(packet.getSlot());
        buffer.writeByte(packet.getButton());
        buffer.writeShort(packet.getUniqueId());
        helper.writeVarInt(buffer, packet.getClickType().ordinal());
        helper.writeItemStack(buffer, packet.getItemStack());
    }

    @Override
    public void deserialize(ByteBuf buffer, JavaCodecHelper helper, ContainerClickPacket packet)
            throws PacketSerializeException {
        packet.setContainerId(buffer.readByte());
        packet.setSlot(buffer.readShort());
        packet.setButton(buffer.readByte());
        packet.setUniqueId(buffer.readShort());
        packet.setClickType(ClickType.getById(helper.readVarInt(buffer)));
        packet.setItemStack(helper.readItemStack(buffer));
    }
}

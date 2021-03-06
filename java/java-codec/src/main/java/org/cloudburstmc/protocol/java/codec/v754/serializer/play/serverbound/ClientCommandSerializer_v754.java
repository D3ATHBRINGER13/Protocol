package org.cloudburstmc.protocol.java.codec.v754.serializer.play.serverbound;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.common.exception.PacketSerializeException;
import org.cloudburstmc.protocol.java.codec.JavaCodecHelper;
import org.cloudburstmc.protocol.java.codec.JavaPacketSerializer;
import org.cloudburstmc.protocol.java.data.command.CommandAction;
import org.cloudburstmc.protocol.java.packet.play.serverbound.ClientCommandPacket;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ClientCommandSerializer_v754 implements JavaPacketSerializer<ClientCommandPacket> {
    public static final ClientCommandSerializer_v754 INSTANCE = new ClientCommandSerializer_v754();

    @Override
    public void serialize(ByteBuf buffer, JavaCodecHelper helper, ClientCommandPacket packet)
            throws PacketSerializeException {
        helper.writeVarInt(buffer, packet.getAction().ordinal());
    }

    @Override
    public void deserialize(ByteBuf buffer, JavaCodecHelper helper, ClientCommandPacket packet)
            throws PacketSerializeException {
        packet.setAction(CommandAction.getById(helper.readVarInt(buffer)));
    }
}

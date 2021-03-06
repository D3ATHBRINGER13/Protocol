package org.cloudburstmc.protocol.java.codec.v754.serializer.play;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.kyori.adventure.text.serializer.plain.PlainComponentSerializer;
import org.cloudburstmc.protocol.java.codec.BidirectionalJavaPacketSerializer;
import org.cloudburstmc.protocol.java.codec.JavaCodecHelper;
import org.cloudburstmc.protocol.java.data.text.ChatPosition;
import org.cloudburstmc.protocol.java.packet.play.ChatPacket;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatSerializer_v754 extends BidirectionalJavaPacketSerializer<ChatPacket> {
    public static final ChatSerializer_v754 INSTANCE = new ChatSerializer_v754();

    @Override
    public void serializeClientbound(ByteBuf buffer, JavaCodecHelper helper, ChatPacket packet) {
        helper.writeComponent(buffer, packet.getMessage());
        buffer.writeByte(packet.getPosition().ordinal());
        helper.writeUUID(buffer, packet.getSenderUuid());
    }

    @Override
    public void deserializeClientbound(ByteBuf buffer, JavaCodecHelper helper, ChatPacket packet) {
        packet.setMessage(helper.readComponent(buffer));
        packet.setPosition(ChatPosition.getById(buffer.readByte()));
        packet.setSenderUuid(helper.readUUID(buffer));
    }

    @Override
    public void serializeServerbound(ByteBuf buffer, JavaCodecHelper helper, ChatPacket packet) {
        helper.writeString(buffer, PlainComponentSerializer.plain().serialize(packet.getMessage()));
    }

    @Override
    public void deserializeServerbound(ByteBuf buffer, JavaCodecHelper helper, ChatPacket packet) {
        packet.setMessage(PlainComponentSerializer.plain().deserialize(helper.readString(buffer)));
    }
}

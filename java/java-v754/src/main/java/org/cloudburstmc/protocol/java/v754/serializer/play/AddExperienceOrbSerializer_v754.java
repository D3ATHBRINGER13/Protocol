package org.cloudburstmc.protocol.java.v754.serializer.play;

import com.nukkitx.network.VarInts;
import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.java.JavaPacketHelper;
import org.cloudburstmc.protocol.java.JavaPacketSerializer;
import org.cloudburstmc.protocol.java.packet.play.AddExperienceOrbPacket;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddExperienceOrbSerializer_v754 implements JavaPacketSerializer<AddExperienceOrbPacket> {
    public static final AddExperienceOrbSerializer_v754 INSTANCE = new AddExperienceOrbSerializer_v754();

    @Override
    public void serialize(ByteBuf buffer, JavaPacketHelper helper, AddExperienceOrbPacket packet) {
        VarInts.writeUnsignedInt(buffer, packet.getEntityId());
        helper.writePosition(buffer, packet.getPosition());
        buffer.writeShort(packet.getAmount());
    }

    @Override
    public void deserialize(ByteBuf buffer, JavaPacketHelper helper, AddExperienceOrbPacket packet) {
        packet.setEntityId(VarInts.readInt(buffer));
        packet.setPosition(helper.readPosition(buffer));
        packet.setAmount(buffer.readShort());
    }
}
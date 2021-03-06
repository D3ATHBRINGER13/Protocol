package org.cloudburstmc.protocol.java.codec.v754.serializer.play;

import com.nukkitx.math.vector.Vector2f;
import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.common.exception.PacketSerializeException;
import org.cloudburstmc.protocol.java.codec.BidirectionalJavaPacketSerializer;
import org.cloudburstmc.protocol.java.codec.JavaCodecHelper;
import org.cloudburstmc.protocol.java.packet.play.MoveVehiclePacket;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MoveVehicleSerializer_v754 extends BidirectionalJavaPacketSerializer<MoveVehiclePacket> {
    public static final MoveVehicleSerializer_v754 INSTANCE = new MoveVehicleSerializer_v754();

    @Override
    public void serialize(ByteBuf buffer, JavaCodecHelper helper, MoveVehiclePacket packet) throws PacketSerializeException {
        helper.writePosition(buffer, packet.getPosition());
        // Yes, Java flips these values for whatever reason
        buffer.writeFloat(packet.getRotation().getY());
        buffer.writeFloat(packet.getRotation().getX());
    }

    @Override
    public void deserialize(ByteBuf buffer, JavaCodecHelper helper, MoveVehiclePacket packet) throws PacketSerializeException {
        packet.setPosition(helper.readPosition(buffer));
        float y = buffer.readFloat();
        float x = buffer.readFloat();
        packet.setRotation(Vector2f.from(x, y));
    }
}

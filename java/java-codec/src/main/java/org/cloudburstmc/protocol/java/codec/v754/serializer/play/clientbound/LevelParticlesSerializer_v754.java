package org.cloudburstmc.protocol.java.codec.v754.serializer.play.clientbound;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.common.exception.PacketSerializeException;
import org.cloudburstmc.protocol.java.codec.JavaCodecHelper;
import org.cloudburstmc.protocol.java.codec.JavaPacketSerializer;
import org.cloudburstmc.protocol.java.data.world.Particle;
import org.cloudburstmc.protocol.java.data.world.ParticleType;
import org.cloudburstmc.protocol.java.packet.play.clientbound.LevelParticlesPacket;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LevelParticlesSerializer_v754 implements JavaPacketSerializer<LevelParticlesPacket> {
    public static final LevelParticlesSerializer_v754 INSTANCE = new LevelParticlesSerializer_v754();

    @Override
    public void serialize(ByteBuf buffer, JavaCodecHelper helper, LevelParticlesPacket packet) throws PacketSerializeException {
        buffer.writeInt(helper.getParticleId(packet.getParticle().getType()));
        buffer.writeBoolean(packet.isOverrideLimiter());
        helper.writePosition(buffer, packet.getPosition());
        helper.writeVector3f(buffer, packet.getDistance());
        buffer.writeFloat(packet.getMaxSpeed());
        buffer.writeInt(packet.getCount());
        helper.writeParticleData(buffer, packet.getParticle());
    }

    @Override
    public void deserialize(ByteBuf buffer, JavaCodecHelper helper, LevelParticlesPacket packet) throws PacketSerializeException {
        ParticleType type = helper.getParticle(buffer.readInt());
        packet.setOverrideLimiter(buffer.readBoolean());
        packet.setPosition(helper.readPosition(buffer));
        packet.setDistance(helper.readVector3f(buffer));
        packet.setMaxSpeed(buffer.readFloat());
        packet.setCount(buffer.readInt());
        packet.setParticle(new Particle(type, helper.readParticleData(buffer, type)));
    }
}

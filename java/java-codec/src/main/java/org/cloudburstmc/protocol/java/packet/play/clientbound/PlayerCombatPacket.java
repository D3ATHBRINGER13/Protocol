package org.cloudburstmc.protocol.java.packet.play.clientbound;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.kyori.adventure.text.Component;
import org.cloudburstmc.protocol.java.data.CombatEvent;
import org.cloudburstmc.protocol.java.packet.handler.JavaPlayPacketHandler;
import org.cloudburstmc.protocol.java.packet.JavaPacket;
import org.cloudburstmc.protocol.java.packet.type.JavaPacketType;
import org.cloudburstmc.protocol.java.packet.type.JavaPlayPacketType;

@Data
@EqualsAndHashCode(doNotUseGetters = true, callSuper = false)
public class PlayerCombatPacket implements JavaPacket<JavaPlayPacketHandler> {
    private CombatEvent combatEvent;
    private int playerEntityId;
    private int killerEntityId;
    private int duration;
    private Component message;

    @Override
    public boolean handle(JavaPlayPacketHandler handler) {
        return handler.handle(this);
    }

    @Override
    public JavaPacketType getPacketType() {
        return JavaPlayPacketType.PLAYER_COMBAT;
    }
}

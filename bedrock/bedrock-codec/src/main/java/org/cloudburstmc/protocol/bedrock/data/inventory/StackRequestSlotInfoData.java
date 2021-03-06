package org.cloudburstmc.protocol.bedrock.data.inventory;

import lombok.Value;

/**
 * Holds information on a specific slot client-side.
 */
@Value
public class StackRequestSlotInfoData {
    // container the slot was in
    ContainerSlotType container;

    // slot is the index of the slot within the container
    byte slot;

    // stackNetworkId is the unique stack ID that the client assumes to be present in this slot. The server
    // must check if these IDs match. If they do not match, servers should reject the stack request that the
    // action holding this info was in.
    int stackNetworkId;
}

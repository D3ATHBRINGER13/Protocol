package org.cloudburstmc.protocol.bedrock.data.inventory.stackrequestactions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * CraftRecipeStackRequestActionData is sent by the client the moment it begins crafting an item. This is the
 * first action sent, before the Consume and Create item stack request actions.
 * This action is also sent when an item is enchanted. Enchanting should be treated mostly the same way as
 * crafting, where the old item is consumed.
 */
@AllArgsConstructor
@Getter
@Setter
public class CraftRecipeStackRequestActionData implements RecipeStackRequestActionData {
    int recipeNetworkId;

    @Override
    public StackRequestActionType getType() {
        return StackRequestActionType.CRAFT_RECIPE;
    }
}

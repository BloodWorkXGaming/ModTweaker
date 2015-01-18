package modtweaker.mods.botania.lexicon.commands;

import java.util.Collections;
import java.util.List;

import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.lexicon.LexiconCategory;
import minetweaker.MineTweakerAPI;
import minetweaker.MineTweakerImplementationAPI;
import minetweaker.api.player.IPlayer;
import minetweaker.api.server.ICommandFunction;

public class LexiconCategoryLogger implements ICommandFunction{

    @Override
    public void execute(String[] arguments, IPlayer player) {
    	List<LexiconCategory> categories=BotaniaAPI.getAllCategories();
        System.out.println("Categories: " + categories.size());
        for (LexiconCategory category : categories) {
            System.out.println("Category " + category.getUnlocalizedName());
            MineTweakerAPI.logCommand(category.getUnlocalizedName());
        }

        if (player != null) {
            player.sendChat(MineTweakerImplementationAPI.platform.getMessage("List generated; see minetweaker.log in your minecraft dir"));
        }
    }
}

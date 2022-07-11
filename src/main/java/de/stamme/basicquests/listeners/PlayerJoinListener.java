package de.stamme.basicquests.listeners;

import de.stamme.basicquests.main.Main;
import de.stamme.basicquests.main.PlayerData;
import de.stamme.basicquests.main.QuestPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerJoinListener implements Listener {

	@EventHandler
	public void onPlayerJoin(@NotNull PlayerJoinEvent event) {
		Player player = event.getPlayer();

		// load player data from file - if not successful generate new QuestPlayer
		if (!PlayerData.loadPlayerData(player)) {
			QuestPlayer joinedPlayer = new QuestPlayer(player);
			Main.getPlugin().getQuestPlayers().put(player.getUniqueId(), joinedPlayer);
		}

//		if (Main.getPlugin().getQuestPlayers().containsKey(player.getUniqueId())) {
//			QuestPlayer questPlayer = Main.getPlugin().getQuestPlayers().get(player.getUniqueId());
//			// Outputting 100 example quests in console (balancing purpose)
//			for (int i = 0; i < 100; i++) {
//				try {
//					Quest q = QuestGenerator.generate(questPlayer);
//
//					Main.log(q.getInfo(true));
//
//				} catch (QuestGenerationException e) {
//					Main.log(e.message);
//					e.printStackTrace();
//				}
//			}
//		}
	}
}

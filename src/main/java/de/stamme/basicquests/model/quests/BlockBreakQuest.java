package de.stamme.basicquests.model.quests;

import de.stamme.basicquests.config.MessagesConfig;
import de.stamme.basicquests.config.MinecraftLocaleConfig;
import de.stamme.basicquests.model.rewards.Reward;
import org.bukkit.Material;

import java.text.MessageFormat;

public class BlockBreakQuest extends Quest {


	// ---------------------------------------------------------------------------------------
	// Quest State
	// ---------------------------------------------------------------------------------------

	private final Material material;


	// ---------------------------------------------------------------------------------------
	// Constructor
	// ---------------------------------------------------------------------------------------

	public BlockBreakQuest(Material mat, int goal, Reward reward) {
		super(goal, reward);
		this.material = mat;
	}


	// ---------------------------------------------------------------------------------------
	// Functionality
	// ---------------------------------------------------------------------------------------

	@Override
	public QuestData toData() {
		QuestData data = super.toData();
		data.setQuestType(QuestType.BREAK_BLOCK.name());
		data.setMaterial(material.name());
		return data;
	}


	// ---------------------------------------------------------------------------------------
	// Getter & Setter
	// ---------------------------------------------------------------------------------------

	/**
	 * @return String in the format: "Break <amount> <material>"
 	 */
	@Override
	public String getName() {
		int goal = getGoal();
		if (goal <= 1) {
			String singularName = MinecraftLocaleConfig.getMinecraftName(getOptionKey(), "block.minecraft.");
			return MessageFormat.format(MessagesConfig.getMessage("quests.break-block.singular"), singularName);
		} else {
			String pluralName = MessagesConfig.getPluralName(getQuestType(), getOptionKey(), "block.minecraft.");
			return MessageFormat.format(MessagesConfig.getMessage("quests.break-block.plural"), goal, pluralName);
		}
	}

	@Override
	public String[] getDecisionObjectNames() {
		return new String[]{QuestType.BREAK_BLOCK.name(), material.name()};
	}

	@Override
	public String getOptionKey() {
		return material.toString();
	}

	public Material getMaterial() {
		return material;
	}

	@Override
	public final QuestType getQuestType() {
		return QuestType.BREAK_BLOCK;
	}
}

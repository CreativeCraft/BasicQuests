package de.stamme.basicquests.quests;

import de.stamme.basicquests.util.StringFormatter;
import org.bukkit.Material;

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
		return String.format("Break %s %s", this.getGoal(), StringFormatter.format(material.toString()));
	}

	@Override
	public String[] getDecisionObjectNames() {
		return new String[]{QuestType.BREAK_BLOCK.name(), material.name()};
	}

	public Material getMaterial() {
		return material;
	}
}

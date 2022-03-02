package com.BrassAmber.ba_bt.util;

import javax.annotation.Nullable;

import com.BrassAmber.ba_bt.entity.block.BTObelisk;
import com.BrassAmber.ba_bt.entity.block.BTMonolith;
import com.BrassAmber.ba_bt.init.BTEntityTypes;
import com.BrassAmber.ba_bt.init.BTItems;

import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

public enum GolemType implements StringRepresentable {
	EMPTY("empty"),
	LAND("land"),
	OCEAN("ocean"),
	NETHER("nether"),
	CORE("core"),
	END("end"),
	SKY("sky");

	private String name;

	GolemType(String name) {
		this.name = name;
	}

	/*********************************************************** Monolith Spawning ********************************************************/

	/**
	 * Get the correct Monolith key for the Correct Monolith Entity
	 */
	public static @NotNull EntityType<?> getGolemFor(GolemType golemType) {
		return switch (golemType) {
			default -> BTEntityTypes.LAND_GOLEM;
			case OCEAN -> BTEntityTypes.OCEAN_GOLEM;
			case NETHER -> BTEntityTypes.NETHER_GOLEM;
			case CORE -> BTEntityTypes.CORE_GOLEM;
			case END -> BTEntityTypes.END_GOLEM;
			case SKY -> BTEntityTypes.SKY_GOLEM;
		};
	}

	/*********************************************************** Obelisk ********************************************************/

	/**
	 * Get the correct Obelisk for the Golem Type.
	 * @return
	 */
	@NotNull
	public static EntityType<BTObelisk> getObeliskFor(GolemType golemType) {
		return switch (golemType) {
			default -> BTEntityTypes.LAND_OBELISK;
			case OCEAN -> BTEntityTypes.OCEAN_OBELISK;
			case NETHER -> BTEntityTypes.NETHER_OBELISK;
			case CORE -> BTEntityTypes.CORE_OBELISK;
			case END -> BTEntityTypes.END_OBELISK;
			case SKY -> BTEntityTypes.SKY_OBELISK;
		};
	}


	/*********************************************************** Monolith ********************************************************/

	/**
	 * Get the correct Monolith Item for the Correct Monolith Entity.
	 */
	@Nullable
	public static Item getMonolithItemFor(GolemType golemType) {
		return switch (golemType) {
			default -> null;
			case LAND -> BTItems.LAND_MONOLITH;
			case OCEAN -> BTItems.OCEAN_MONOLITH;
			case NETHER -> BTItems.NETHER_MONOLITH;
			case CORE -> BTItems.CORE_MONOLITH;
			case END -> BTItems.END_MONOLITH;
			case SKY -> BTItems.SKY_MONOLITH;
		};
	}

	/**
	 * Return the correct GolemType for each Monolith Entity.
	 */
	public static GolemType getTypeForMonolith(BTMonolith BTMonolithEntity) {
		EntityType<?> entityType = BTMonolithEntity.getMonolithType();
		if (entityType != null) {
			if (entityType.equals(BTEntityTypes.LAND_MONOLITH)) {
				return LAND;
			} else if (entityType.equals(BTEntityTypes.OCEAN_MONOLITH)) {
				return OCEAN;
			} else if (entityType.equals(BTEntityTypes.NETHER_MONOLITH)) {
				return NETHER;
			} else if (entityType.equals(BTEntityTypes.CORE_MONOLITH)) {
				return CORE;
			} else if (entityType.equals(BTEntityTypes.END_MONOLITH)) {
				return END;
			} else if (entityType.equals(BTEntityTypes.SKY_MONOLITH)) {
				return SKY;
			}
		}

		// Couldn't get EntityType
		return EMPTY;
	}

	/*********************************************************** Eyes ********************************************************/

	/**
	 * Return the matching Guardian Eye for each GolemType.
	 */
	@Nullable
	public static Item getEyeFor(GolemType golemType) {
		switch (golemType) {
		case EMPTY:
		default:
			return null;
		case LAND:
			return BTItems.LAND_GUARDIAN_EYE;
		case OCEAN:
			return BTItems.OCEAN_GUARDIAN_EYE;
		case NETHER:
			return BTItems.NETHER_GUARDIAN_EYE;
		case CORE:
			return BTItems.CORE_GUARDIAN_EYE;
		case END:
			return BTItems.END_GUARDIAN_EYE;
		case SKY:
			return BTItems.SKY_GUARDIAN_EYE;
		}
	}

	/**
	 * Return the previous GolemType in fighting order.
	 */
	@Nullable
	public static GolemType getPreviousGolemType(GolemType golemType) {
		switch (golemType) {
		case EMPTY:
		case LAND:
		default:
			return EMPTY;
		case OCEAN:
			return LAND;
		case NETHER:
			return OCEAN;
		case CORE:
			return NETHER;
		case END:
			return CORE;
		case SKY:
			return END;
		}
	}

	/*********************************************************** Keys ********************************************************/

	@Nullable
	public static Item getKeyFor(GolemType golemType) {
		switch (golemType) {
		case EMPTY:
		default:
			return (Item) null;
		case LAND:
			return BTItems.LAND_MONOLOITH_KEY;
		case OCEAN:
			return BTItems.OCEAN_MONOLOITH_KEY;
		case NETHER:
			return BTItems.NETHER_MONOLOITH_KEY;
		case CORE:
			return BTItems.CORE_MONOLOITH_KEY;
		case END:
			return BTItems.END_MONOLOITH_KEY;
		case SKY:
			return BTItems.SKY_MONOLOITH_KEY;
		}
	}

	/*********************************************************** Extra ********************************************************/

	public static GolemType getTypeForName(String name) {
		switch (name) {
			case "empty":
			default:
				return null;
			case "land":
				return LAND;
			case "ocean":
				return OCEAN;
			case "nether":
				return NETHER;
			case "core":
				return CORE;
			case "end":
				return END;
			case "sky":
				return SKY;
		}
	}

	@Override
	public String getSerializedName() {
		return this.name;
	}
}

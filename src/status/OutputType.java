package status;

import java.util.ArrayList;
import java.util.HashMap;

import agents.Worm;

public enum OutputType {
	CURRENT_X, CURRENT_Y, CURRENT_Z, ENERGY, MASS, PROGENY, TIME_BORN, TIME_LARVA, TIME_ADULT, TIME_WORMBAG, LIFESTAGE, DEATH;

	public OutputType oTypeConvert(String type) {
		OutputType returnType = null;
		switch (type) {
		case "CURRENT_X" : returnType = OutputType.CURRENT_X;
		break;
		case "CURRENT_Y" : returnType = OutputType.CURRENT_Y;
		break;
		case "CURRENT_Z" : returnType = OutputType.CURRENT_Z;
		break;
		case "ENERGY" : returnType = OutputType.ENERGY;
		break;
		case "MASS" : returnType = OutputType.MASS;
		break;
		case "PROGENY" : returnType = OutputType.PROGENY;
		break;
		case "TIME_BORN" : returnType = OutputType.TIME_BORN;
		break;
		case "TIME_LARVA" : returnType = OutputType.TIME_LARVA;
		break;
		case "TIME_ADULT" : returnType = OutputType.TIME_ADULT;
		break;
		case "TIME_WORMBAG" : returnType = OutputType.TIME_WORMBAG;
		break;
		case "LIFESTAGE" : returnType = OutputType.LIFESTAGE;
		break;
		case "DEATH" : returnType = OutputType.DEATH;
		break;
		}
		return returnType;
	} 

	@Override
	public String toString() {
		String s = "";
		switch (this) {
		case CURRENT_X:
			s = "CURRENT_X";
			break;
		case CURRENT_Y:
			s = "CURRENT_Y";
			break;
		case CURRENT_Z:
			s = "CURRENT_Z";
			break;
		case ENERGY:
			s = "ENERGY";
			break;
		case MASS:
			s = "MASS";
			break;
		case PROGENY:
			s = "PROGENY";
			break;
		case TIME_BORN:
			s = "TIME_BORN";
			break;
		case DEATH:
			s = "DEATH";
			break;
		case LIFESTAGE:
			s = "LIFESTAGE";
			break;
		case TIME_ADULT:
			s = "TIME_ADULT";
			break;
		case TIME_LARVA:
			s = "TIME_LARVA";
			break;
		case TIME_WORMBAG:
			s = "TIME_WORMBAG";
			break;
		}
		return s;
	}

	public HashMap<Integer, Object> getValue (ArrayList<Worm> worms) {
		HashMap<Integer, Object> values = new HashMap<Integer, Object>();
		for (int i = 0; i < worms.size(); ++i) {
			Worm curWorm = worms.get(i);
			Integer curId = curWorm.id;
			Object value = null;
			switch (this) {
			case CURRENT_X:
				value = curWorm.currentX;
				break;
			case CURRENT_Y:
				value = curWorm.currentY;
				break;
			case CURRENT_Z:
				value = curWorm.currentZ;
				break;
			case ENERGY:
				value = curWorm.energy_reserve;
				break;
			case MASS:
				value = curWorm.mass;
				break;
			case PROGENY:
				value = curWorm.num_progeny;
				break;
			case TIME_BORN:
				value = curWorm.time_born;
				break;
			case DEATH:
				value = curWorm.death;
				break;
			case LIFESTAGE:
				value = curWorm.stage;
				break;
			case TIME_ADULT:
				value = curWorm.time_adult;
				break;
			case TIME_LARVA:
				value = curWorm.time_larva;
				break;
			case TIME_WORMBAG:
				value = curWorm.time_wormbag;
				break;
			}
			values.put(curId, value);
		}
		return values;
	}
}

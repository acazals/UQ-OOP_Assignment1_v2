package examblock.model;

import java.util.ArrayList;

public class UnitList {

    private ArrayList<Unit> units;

    public UnitList() {
        this.units = new ArrayList<>();
    }

    public void addUnit(Unit unit) {
        this.units.add(unit);
    }

    public ArrayList<Unit> all() {
        return new ArrayList<>(units);
    }

    public Unit getUnit(String title, Character unitId) {
        if (this.units.isEmpty()) {
            throw new IllegalStateException("");
        } else {
            boolean temp = false;
            for (int i=0; i<this.units.size(); i++) {
                if (units.get(i).getTitle().equals(title) && units.get(i).id() == unitId) {
                    temp = true;
                    return units.get(i);
                }
            }
            if (!temp) {
                // unit not found
                throw new IllegalStateException("");

            };  // no unit corresponding found
        }
        return null;
    }

    public void removeUnit(Unit unit) {
        if (this.units.contains(unit)) {
            this.units.remove(unit);
        }
    }

    public String getFullDetail() {
        if (this.units.isEmpty()) {
            return "";
        } else {
            String total = "";
            for (int i=0; i<this.units.size(); i++) {
                total = total + this.units.get(i).getFullDetail() + "\n";
            }
            return total;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Unit unit : this.units) {
            String str = unit.getSubject() + " : Unit " + unit.id() + " " + unit.getTitle() + "\n";
            sb.append(str);
        }
        return sb.toString();
    }
}

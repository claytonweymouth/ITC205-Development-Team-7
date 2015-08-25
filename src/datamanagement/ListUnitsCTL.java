package datamanagement;

/**
 * Utility class for listing units.
 */
public class ListUnitsCTL {
  private UnitManager unitManager_;



  public ListUnitsCTL() {
    this.unitManager_ = UnitManager.UM();
  }



  /**
   * Adds unit names from the instance UnitManager to
   * the given UnitLister.
   * 
   * @param unitLister
   */
  public void listUnits(IUnitLister unitLister) {
    unitLister.clearUnits();
    UnitMap units = this.unitManager_.getUnits();

    for (String s : units.keySet()) {
      unitLister.addUnit(units.get(s));
    }
  }



}

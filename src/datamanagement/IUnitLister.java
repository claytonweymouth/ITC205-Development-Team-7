package datamanagement;

/**
 * Allow for units to be removed or added
 */
public interface IUnitLister {
    public void clearUnits();
    public void addUnit(IUnit unit);
}

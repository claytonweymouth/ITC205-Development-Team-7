package datamanagement;

import java.util.List;
import org.jdom.*;



public class UnitManager {

	private static UnitManager self = null;
	private UnitMap UnitMap_;

        
        
        /**
         * If unitmap is null, call method unitmanager and return that result of method
         * @return self 
         */
	public static UnitManager UnitMap_() {
		if (self == null)
			self = new UnitManager();
		return self;
	}

        
        
	/**
         * UnitManager populates UnitMap_ with result of UnitMap 
         */
        private UnitManager() {
		UnitMap_ = new UnitMap();
	}

        
        
	public IUnit getUnit(String uc) {
		IUnit iUnit_ = UnitMap_.get(uc);
		return iUnit_ != null ? iUnit_ : createUnit(uc);

	}

        
        /**
         * 
         * @param unitCode
         * @return  iUnit_
         * @throws RuntimeException
         */
	private IUnit createUnit(String unitCode) {

		IUnit iUnit_;
                  //creation of element for unit table
		for (Element el : (List<Element>) XMLManager.getXML().getDocument()
				.getRootElement().getChild("unitTable").getChildren("unit"))
			if (unitCode.equals(el.getAttributeValue("uid"))) {
				StudentUnitRecordList slist;

				slist = null;
				iUnit_ = new Unit(el.getAttributeValue("uid"),
						el.getAttributeValue("name"), Float.valueOf(
								el.getAttributeValue("ps")).floatValue(), Float
								.valueOf(el.getAttributeValue("cr"))
								.floatValue(), Float.valueOf(
								el.getAttributeValue("di")).floatValue(), Float
								.valueOf(el.getAttributeValue("hd"))
								.floatValue(), Float.valueOf(
								el.getAttributeValue("ae")).floatValue(),
						Integer.valueOf(el.getAttributeValue("asg1wgt"))
								.intValue(), Integer.valueOf(
								el.getAttributeValue("asg2wgt")).intValue(),
						Integer.valueOf(el.getAttributeValue("examwgt"))
								.intValue(), StudentUnitRecordManager.getInstance()
								.instance().getRecordsByUnit(unitCode));
				UnitMap_.put(iUnit_.getUnitCode(), iUnit_);
				return iUnit_;
			}

		throw new RuntimeException("DBMD: createUnit : unit not in file");
	}

        
        /**
         * get units attributes, display within unitmap
         * @return UnitMap1
         */
	public UnitMap getUnits() {

		UnitMap UnitMap1;
		IUnit iUnit_;

		UnitMap1 = new UnitMap();
		for (Element el : (List<Element>) XMLManager.getInstance().getDocument()
				.getRootElement().getChild("unitTable").getChildren("unit")) {
			iUnit_ = new UnitProxy(el.getAttributeValue("uid"),
					el.getAttributeValue("name"));
			UnitMap1.put(iUnit_.getUnitCode(), iUnit_);
		}
                 //unit maps are filled with PROXY units
		return UnitMap1;
	}

}

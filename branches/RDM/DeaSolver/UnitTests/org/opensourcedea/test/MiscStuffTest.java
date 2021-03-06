package org.opensourcedea.test;

import org.junit.Test;

import org.opensourcedea.dea.DEAProblem;
import org.opensourcedea.dea.ModelType;
import org.opensourcedea.exception.DEAException;
import org.opensourcedea.exception.InvalidPropertyValueException;

public class MiscStuffTest {
	
	DEAProblem tester;// = new DEAProblem(20, 4);
	
	public void buildDEAProblem(ModelType ModelType) { //, DEAModelOrientation ModelOrientation) {
		
		tester.setModelType(ModelType);
		//tester.setModelOrientation(ModelOrientation);
		tester.setVariableNames(TestData.createTestVariableNames());
		tester.setVariableOrientations(TestData.createTestVariableOrientation());
		tester.setDataMatrix(TestData.createTestDataMatrix());
		tester.setDMUNames(TestData.createTestDMUNames());
		try {
			tester.setRTSLowerBound(0.8);
		} catch (InvalidPropertyValueException e) {
			e.printStackTrace();
		}
		try {
			tester.setRTSUpperBound(1.2);
		} catch (InvalidPropertyValueException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void checkWeightArrayLength() throws Exception {
		
		for(ModelType modType : ModelType.values()) {
			tester = new DEAProblem(20, 4);
			buildDEAProblem(modType);
			try {
				//System.out.print("Solving: " + tester.getModelType().toString() + "\r\n");
				tester.solve();
			}
			catch (DEAException e) {
				System.out.print("There was a problem solving model: " + tester.getModelType().toString());
				e.printStackTrace();
			}
			if (tester.getWeight(0).length > 4) {
				System.out.println("The model assumes: " + tester.getModelRTS().toString() + " RTS. The Model Type is: " +
			modType.toString() + " has: " + tester.getWeight(0).length + " weights. The Model Variables Type is: " +
						tester.getModelVariableTypes().toString());
			}
		}
		
		
	}
	
	@Test
	public void checkModelCharacteristics() {
		
		for(ModelType modType : ModelType.values()) {
			System.out.println("The model name is: " + modType.getName() + ".");
			System.out.println("The Model description is as follows:\n" + modType.getDescription() + "\n" +
			"The model Variables Type is: " + modType.getModelVariablesType().toString());

		}
				
	}
	
}

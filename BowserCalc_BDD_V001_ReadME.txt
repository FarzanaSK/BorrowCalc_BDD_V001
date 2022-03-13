Name of the Project : BorrowCalc_BDD_V001 
Framework Used : BDD
This is a simple BDD framework using Cucumber,TestNG,Selenium -Java.
There are four packages in BorrowCalc_BDD_V001/src/test/java 
1.base - is the base class where the declaration of the RemoteWebdriver is done.
2.features (this is a folder) - BorrowCalc_BDD_V001/src/test/java/features/BorrowCalc.feature
This is the entry point of the tests. The test cases are written in Gherkin language. 
3.runner - BorrowCalc_BDD_V001/src/test/java/runner/BorrowrCalcRunner.java
Here the feature file is mapped to the corresponding step defnition file. All other configuration required to run the tests are done here.
4.steps - BorrowCalc_BDD_V001\src\test\java\steps\BorrowCalcSteps.java
 This is the java implementation layer where the test case steps will have their corresponding java methods.

The test cases are run from the runner file. (Right Click on the BorrowCalcRunner.java file , Run As-> TestNG Test).

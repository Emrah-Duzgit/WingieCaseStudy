You can get all information about this assignment and the framework I used for this assignment below.

My framework is based on BDD concept with Gherkin language. It has 7 different packages which are ApachePOI,
FeatureFiles, Pages, Runners, StepDefinitions, Utilities, XMLFiles.

I include all the steps that my test case requires to FeatureFile package. Those steps are written in Gherkin
language so that anyone who has no idea about coding can easily understand what my test cases about.

StepDefinitions package includes the codedsteps of feature file. Feature file steps are connected to Steps class
in StepDefinitions package. My Steps class has two objects created from classes in Pages package, namely
DialogContent and LeftNav. I send my WebElements name in string format to methods in DialogContent and LeftNav
so that my Steps class operate the steps of feature file.

My framework is designed according to OOP principles. I used encapsulation in DialogContent and LeftNav classes.
Those classes also take inheritance from Parent class. My methods take string value which are being sent from
Steps class and equals them to the corresponding WebElement in my POM and then sends it to the Parent class.
Parent class includes many helper methods such as ……... For instance, Parent class takes the WebElement and then
waits, scrolls then clicks or sendkeys or makes assertions etc.

I generally use my Runners classes to perform Parallel test (or cross browser test), smoke test or regression
test by adding tag accordingly but in this case I have used it just to perform Parallel test and get an html
Extenteport.

Utilities package has two class. GWD class is where I made my driver settings. ExcelUtility is just
for ApachePoi, in other words for excel operations. I have used ExcelUtility to list the results of my test
scenario. And lastly, I have XMLFiles package. I created it to perform parallel testing and manage report settings.

I use extend report in order to show result of my test cases. (You can find test results in "test-output" directory

I  have a pom xml file. It is a file that contains all kinds of information about the project, from building
a project to how to build it, from dependencies to packaging. I have added tools in it that I need my projects as
dependency and I configured it for Jenkins.

At last I've uploaded my project to my github account then I made a connection between my github and jenkins account.
With this way I provided CI/CD as well.

package stepDefinitions;

public class TestContext {
    DataContext dataContext;

    public TestContext() {
        dataContext = new DataContext();
    }

    public DataContext getDataContext(){
        return dataContext;
    }
}
